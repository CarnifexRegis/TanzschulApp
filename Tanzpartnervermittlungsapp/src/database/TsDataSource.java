package database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

/**
 * Manages Database Interactions
 * NOT  READY
 * @author Simon Stolz
 *
 */
public class TsDataSource {

    private static final String LOG_TAG = TsDataSource.class.getSimpleName();

    private SQLiteDatabase db;
    /**
     * source: http://www.programmierenlernenhq.de/sqlite-datenbank-in-android-app-integrieren/
     * An instance of our deb helper used to interact with the db
     */
    private TsDbHelper dbHelper;
    private String[] columns = {
           TsDbHelper.COLUMN_ID,
           TsDbHelper.COLUMN_CSOURCE,
           TsDbHelper.COLUMN_SSOURCE,
           TsDbHelper.COLUMN_IDP
    };



    public TsDataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new TsDbHelper(context);
    }
    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + db.getPath());
      }

      public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
      }
      public Picture createPicture(String cSource, String sSource, int idp) {
          ContentValues values = new ContentValues();
          values.put(TsDbHelper.COLUMN_CSOURCE, cSource);
          values.put(TsDbHelper.COLUMN_SSOURCE, sSource);
          values.put(TsDbHelper.COLUMN_IDP, idp);

          long insertId = db.insert(TsDbHelper.TABLE_PICTURE, null, values);

          Cursor cursor = db.query(TsDbHelper.TABLE_PICTURE,
                  columns, TsDbHelper.COLUMN_ID + "=" + insertId,
                  null, null, null, null);

          cursor.moveToFirst();
          Picture pic = cursorToPicture(cursor);
          cursor.close();

          return pic;
      }

      private Picture cursorToPicture(Cursor cursor) {
          int idIndex = cursor.getColumnIndex(TsDbHelper.COLUMN_ID);
          int idcs = cursor.getColumnIndex(TsDbHelper.COLUMN_CSOURCE);
          int idss = cursor.getColumnIndex(TsDbHelper.COLUMN_SSOURCE);
          int ididp = cursor.getColumnIndex(TsDbHelper.COLUMN_IDP);

          String cs = cursor.getString(idcs);
          String ss = cursor.getString(idss);
          int idp = cursor.getInt(ididp);
          long id = cursor.getLong(idIndex);

          Picture pic = new Picture(cs,ss,idp,id);

          return pic;
      }

      public List<Picture> getAllPictures() {
          List<Picture> PicList = new ArrayList<>();

          Cursor cursor = db.query(TsDbHelper.TABLE_PICTURE,
                  columns, null, null, null, null, null);

          cursor.moveToFirst();
          Picture pic;

          while(!cursor.isAfterLast()) {
              pic = cursorToPicture(cursor);
              PicList.add(pic);
              Log.d(LOG_TAG, "ID: " + pic.getId() + ", Inhalt: " + pic.toString());
              cursor.moveToNext();
          }

          cursor.close();

          return PicList;
      }
     
      public void addSSource(String sSource){
    	  try{
        	  SQLiteStatement stmt = db.compileStatement("UPDATE "+ TsDbHelper.TABLE_PICTURE+ " SET "+ TsDbHelper.COLUMN_SSOURCE+" = ? WHERE "+ TsDbHelper.COLUMN_IDP + " = -1 ;");
        	  	stmt.bindString(1, sSource);
        	  	stmt.execute();
        	  	stmt.close();
     		 	}catch(Exception e){
     		 		e.printStackTrace();
     		 	}
    	  
      }
      /**
       *  Source : https://github.com/leletec/NameMemo/blob/master/app/src/main/java/database/SettingsDAO.java
       *  http://www.programmierenlernenhq.de/daten-in-sqlite-datenbank-schreiben-und-lesen-in-android/
       * @return
       */
      public Picture getMyPic(){
    	  String countQuery = "SELECT * FROM picture WHERE idp = -1 ;";
  	    Cursor cursor = db.rawQuery(countQuery, null);
  	    int cnt = cursor.getCount();
  	    cursor.close(); 
  	  Picture pic = null;
  	  if(cnt>0){
    	  Cursor c = db.query(TsDbHelper.TABLE_PICTURE,columns,TsDbHelper.COLUMN_IDP + "=" + -1,null,null,null,null);
    	  c.moveToFirst();
    	  pic = cursorToPicture(c);
    	//  c.close();
    	
    	}
  	  return pic;
		}
      public void amendPic(String cs, String ss,int idp ){
    	  /**
    	   * http://stackoverflow.com/questions/15645192/inserting-integer-values-into-mysql-database-using-variables
    	   */

    	  String countQuery = "SELECT * FROM picture WHERE idp = "+idp+" ;";
    	    Cursor cursor = db.rawQuery(countQuery, null);
    	    int cnt= 0;
    	    try{
    	     cnt = cursor.getCount();}
    	    catch(Exception e){
    	    	e.printStackTrace();
    	    }
    	   
    	   
    	    cursor.close();
    	
    	  if(cnt>0){
    		  
    	  
    	  try{
    		 SQLiteStatement stmt = db.compileStatement("UPDATE "+ TsDbHelper.TABLE_PICTURE+ " SET "+ TsDbHelper.COLUMN_CSOURCE + " = ? , "+ TsDbHelper.COLUMN_SSOURCE+" = ? WHERE "+ TsDbHelper.COLUMN_IDP + " = ? ;");
    	  	stmt.bindString(1, cs);
 		 	stmt.bindString(2, ss);
 		 	stmt.bindString(2, idp +"");
 		 	stmt.executeUpdateDelete();
 		 	stmt.close();
 		 	}catch(Exception e){
 		 		e.printStackTrace();
 		 	}
    	  }else{
    		  createPicture(cs, ss, idp);
    	  }
      }
      /**
       * Extracts the Urls of all Contact Pictures
       * @param idp
       * @return Returns a List of Picture Objects if it fails to extract one of the Pictures teh Picture object contains an null value for clientSource 
       */
      public ArrayList<Picture> getFriendsPic(int[]idp){
    	  Cursor cursor;
    	  
    	  ArrayList<Picture>  picList = new ArrayList<Picture>();
    	  for (int i = 0 ;i <idp.length;i++){
    		  //http://stackoverflow.com/questions/1122679/querying-and-working-with-cursors-in-sqlite-on-android
    		  try{
    		  String q = "SELECT * FROM "+ TsDbHelper.TABLE_PICTURE+" WHERE "+TsDbHelper.COLUMN_IDP+" = ? ;";
    		  cursor = db.rawQuery(q,new String[]{idp[i]+""}); 
              cursor.moveToFirst();
              Picture pic;
              pic = cursorToPicture(cursor);
              picList.add(pic);
              Log.d(LOG_TAG, "ID: " + pic.getId() + ", Inhalt: " + pic.toString());
              if(cursor != null){
            	  cursor.close();}
              }catch(Exception e){
            	  picList.add(new Picture());
              }
    	    	
    	  }
    	  return picList;
      }
      
      public void addforeignPicList(ArrayList<Picture> pics){
    	
    	  SQLiteStatement stmt = db.compileStatement("INSERT INTO "+ TsDbHelper.TABLE_PICTURE+ " ("+ TsDbHelper.COLUMN_CSOURCE + " ,"+ TsDbHelper.COLUMN_SSOURCE + ","+ TsDbHelper.COLUMN_IDP + ")VALUES (?,?,?); ");
    	 
    	 for (int i = 0; i <pics.size() ;i++){
    		 try{
    		 Picture pic  = pics.get(i);
    		 stmt.bindString(1, pic.getClientSource());
    		 stmt.bindString(2, pic.getServerSource());
    		 stmt.bindDouble(3,pic.getIdp());
    		 stmt.executeInsert();
    		 stmt.close();
       	  }catch(Exception e){
       		  
       	  }
      }
      


}}
