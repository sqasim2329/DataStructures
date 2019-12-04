package com.data.miscellenious;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonParser {
	
	public static void main(String args[]) throws Exception {
		String path = "C:\\Users\\Sqasim\\git\\vaautomationjunits\\src\\test\\resources\\mappings";
		File dir = new File(path);
		File[] files = dir.listFiles((file)-> file.getName().toLowerCase().endsWith(".json"));
		for(int i=0; i < files.length; i++) {
			try (FileReader reader = new FileReader(files[i]))
	        {
	            //Read JSON file
				JSONParser jsonParser = new JSONParser();
	            Object obj = jsonParser.parse(reader);
	            System.out.println("file correct "+files[i].getName());
	        }catch(Exception e) {
	        	System.out.println(files[i]);
	        	throw e;
	        }
		}
	}

}
