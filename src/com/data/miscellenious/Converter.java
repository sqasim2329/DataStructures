package com.data.miscellenious;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Converter {
	
	public static void main(String args[]) throws IOException {
		InputStream resourceAsStream = Converter.class.getResourceAsStream("Item.csv");
		BufferedReader br= new BufferedReader(new InputStreamReader(resourceAsStream));
		List<String> item=new ArrayList<>();
		String line="";
		while((line=br.readLine())!=null) {
			item.add(line.trim());
        }
		
	}

}
