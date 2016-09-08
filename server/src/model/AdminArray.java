package model;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import database2.SQL;
import model.Admin;



public class AdminArray {
	private static AdminArray instance;
	Admin[] admin = new  Admin[3];
	private AdminArray() {
		
		
		System.out.println("Constructor of the Model was called");
	}
	public static AdminArray getInstance() {
		if (instance == null)
			instance = new AdminArray();
		System.out.println("got an Instance of the Model");
		return instance;
	}
	public boolean checkAdmin(String n,String k){
		for (int i = 0; i <3; i++){
			if(admin[i].checkLogin(n, k)){
				return true;
				
			}
			}
		return false;
	}
	
	public void writeAdmin(String n,String k,String eMail){
		int i = addAdmin();
		if (i != -1){
			admin[i] = new Admin(n, k, eMail);
			try {
				PrintWriter out1 = new PrintWriter("nadmin"+i+".txt");
				out1.println(n);
				PrintWriter out2 = new PrintWriter("kadmin"+i+".txt");
				out2.println(k);
				PrintWriter out3 = new PrintWriter("eadmin"+i+".txt");
				out3.println(eMail);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private int addAdmin(){
		for (int i = 0; i <3; i++){
			if(admin[i] == null){
				return i;
				
			}
		}
		return -1;
	}
}
