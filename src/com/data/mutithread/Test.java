package com.data.mutithread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
//	public static void main(String args[]) throws IOException {
////		List<String> initialList = new ArrayList<>();
////		List<String> afterRunList = new ArrayList<>();
////		File fr1 = new File("/Users/s0q00i6/MyLearning/spark-course/src/main/resources/initialOffers.txt");
////
////		BufferedReader br = new BufferedReader(new FileReader(fr1));
////
////		String st;
////		while ((st = br.readLine()) != null)
////			initialList.add(st);
////
////		System.out.println(initialList.size());
////
////		File fr2 = new File("/Users/s0q00i6/git/forked/limo-spark/ProductCSV/finalOffers.txt");
////
////		BufferedReader br2 = new BufferedReader(new FileReader(fr2));
////
////		String s;
////		while ((s = br2.readLine()) != null)
////			afterRunList.add(s);
////
////		System.out.println(afterRunList.size());
////		Collections.sort(initialList);
////		Collections.sort(afterRunList);
////		initialList.removeAll(afterRunList);
////  
////		System.out.println(initialList.size());
////		
////		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/s0q00i6/MyLearning/spark-course/src/main/resources/OffersoAR.txt"));
////		for(String str:initialList) {
////	    writer.write(str);
////	    writer.newLine();
////		}
//	    writer.close();
//	}
	
	public static void main(String args[]) {
		String domain="SORTABLE,Geo";
		String search="Geo";
		boolean anyMatch = Arrays.stream(domain.split(",")).anyMatch(d->d.equals(search));
		System.out.println(anyMatch);
	}

}
