package model;

import java.util.ArrayList;

import database2.ProfileChart;
import database2.SQL;

public class Model {
	private static Model instance;
	private SQL sql;

	private Model() {
		sql = new SQL();
		System.out.println("bla");
	}

	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		System.out.println("got new Instance of the Model");
		return instance;
	}
	
	public ArrayList<ProfileChart> getCharts(int id,boolean gender,int kstu, int age) {
		int g;
		if (gender){
			 g = 1;
		}else{
			g = 0;
		}
		
		if (sql.checkID(id)) {
			
			return sql.getProfilecharts(g, kstu, 0);
		}
		else {
			return null ;
			}
	}
	public int Login (String em ,String ps){
		return sql.LogIn(em, ps);
		
	}
	public int getGender(int id){
		return sql.getGender(id);
	}
}
