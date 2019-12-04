package com.data.miscellenious;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LogFileReader {

	public static void main(String args[]) throws IOException {
		String date = "2019-06-20";
		String path = "C:\\Users\\Sqasim\\Desktop\\Mass RCD"; 
		String searchKey = "heyhey";
		File dir = new File(path);
		File[] files = dir.listFiles((file)-> file.getName().toLowerCase().endsWith("txt"));
		int numberOfThreads =  calculateNumberOfThreads(files);
		System.out.println("numberOfthreads:"+numberOfThreads);
		ExecutorService ex = Executors.newFixedThreadPool(numberOfThreads);
		List<Future<Map<Boolean,Map<String,List<String>>>>> futureTasks =  new ArrayList<>();
		Map<Boolean, Map<String,List<String>>> fileMap =Collections.synchronizedMap(new HashMap<>());
		for(File file: files) {
			futureTasks.add(ex.submit(new LogFileProcessorThread(file,date,searchKey)));
		}
		try {
			for(Future<Map<Boolean,Map<String,List<String>>>> future:futureTasks ) {
				Map<Boolean, Map<String,List<String>>> futureResponse;
				futureResponse = future.get();
				Set<Boolean> statusKey = futureResponse.keySet();
				for(Boolean status:statusKey) {
					if(!fileMap.containsKey(status)) {
						Map<String,List<String>> fileInfoMap = new HashMap<>();
						Set<Entry<String,List<String>>> entrySet= futureResponse.get(status).entrySet();
						for(Entry<String,List<String>> entry: entrySet) {
							fileInfoMap.put(entry.getKey(),entry.getValue());
						}
						fileMap.put(status, fileInfoMap);
					}else {
						Set<Entry<String,List<String>>> entrySet= futureResponse.get(status).entrySet();
						for(Entry<String,List<String>> entry: entrySet) {
							fileMap.get(status).put(entry.getKey(), entry.getValue());
						}
						
					}
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(fileMap);
	}

	private static int calculateNumberOfThreads(File[] files) { 
		if(files.length >= 10)
			return 10;
		else
			return files.length;
	}

}

