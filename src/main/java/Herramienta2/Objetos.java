package Herramienta2;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class Objetos {
	static String ejemplo;
	
	public static  String app() throws IOException { 
	Properties obj = new Properties();					
	 FileInputStream objfile = new FileInputStream("C:\\Automatizacion"+"\\"+"object.properties");									
	 obj.load(objfile);	
	 ejemplo=obj.getProperty("app");
	 System.out.println(ejemplo);
	 return ejemplo;
	}
	
	public static  String deviceName() throws IOException { 
		Properties obj = new Properties();					
		 FileInputStream objfile = new FileInputStream("C:\\Automatizacion"+"\\"+"object.properties");									
		 obj.load(objfile);	
		 ejemplo=obj.getProperty("deviceName");
		 System.out.println(ejemplo);
		 return ejemplo;
		}
	
	public static void main(String []args) throws IOException {
		
		//Properties obj = new Properties();
		Properties obj1 = new Properties();	
		Objetos obj=new Objetos();
		//obj1=obj.app();
		String ejemplo1=obj1.getProperty("MobileName");
		System.out.println(ejemplo1);
		
	}

}

