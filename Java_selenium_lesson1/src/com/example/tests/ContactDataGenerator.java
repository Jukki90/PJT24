package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;

import com.thoughtworks.xstream.*;


public class ContactDataGenerator {

	public static void main(String[] args)throws IOException{
		if(args.length<3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File exists, please remove manually: " + file);
		}
		
		List<UserData> users = generateRandomContacts(amount);
		if("csv".equals(format)){
			saveContactToCsvFile(users, file);
		}else if("xml".equals(format)){
			saveContactToXmlFile(users, file);
		}else{
			System.out.println("unknown format"+format);
			return;
		}
	}
	
	
	//------- Save Methods ------------
		private static void saveContactToCsvFile(List<UserData> users, File file)throws IOException  {
				FileWriter writer = new FileWriter(file);
				for (UserData user:users){
					writer.write(user.getFirstName()+","+user.getLastName()+","+user.getMobilePhone()+",!"+"\n");
				}
				writer.close();
		}
		
		private static void saveContactToXmlFile(List<UserData> users, File file)throws IOException {
			XStream xstream = new XStream();
			xstream.alias("user", UserData.class);
			String xml = xstream.toXML(users);
			FileWriter writer = new FileWriter(file);
			writer.write(xml);
			writer.close();
		}
		
		
		
		//------- Generate methods --------------------------
		
		
		
		public static List<UserData> generateRandomContacts(int amount) {
				
			List<UserData> list = new ArrayList<UserData>();
			
			for(int i=0; i<amount;i++){
				UserData user = new UserData()
				.withFirstName(generateRandomString())
				.withLastName(generateRandomString())
				.withEmail(generateRandomString())
				.withMobilePhone(generateRandomString())
				.withHomePhone(generateRandomString())
				.withAddress(generateRandomString());

				list.add(user);
						
			}
			return list;
					
			}
		
		
		
		//------------------------------------------------------------------------------------
		public static String generateRandomString() {
			Random rnd= new Random();
			if (rnd.nextInt(3)==0){
				return "";
			}else{
				return ("test"+rnd.nextInt());
			}
		}
		
		
		public static String generateRandomNumber(int max) {
			Random rnd= new Random();
			String str="";
			str+=(rnd.nextInt(max)+1);
			return str;
		}

}
