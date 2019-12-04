package com.data.miscellenious;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileProcessorThread implements Callable<Map<Boolean,Map<String,List<String>>>> {
	File file;
	String date;
	String searchKey;
	
	public LogFileProcessorThread(File file, String date, String searchKey) {
		this.file = file;
		this.date = date;
		this.searchKey = searchKey;
	}
	@Override
	public Map<Boolean,Map<String,List<String>>> call() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStream = new InputStreamReader(fileInputStream);
		List<String> lines = new ArrayList<>();
		Map<Boolean,Map<String,List<String>>> map = new HashMap<>();
		try(BufferedReader bis= new BufferedReader(inputStream)) {
			String line;
			while((line = bis.readLine())!=null) {
				lines.add(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		Stack<String> stk = new Stack<>();
		Stream<String> s = lines.stream();
		List<String> infoList = new ArrayList<>();
		StringBuffer nextLine = new StringBuffer("N");
		Map<String,List<String>> fileAndFileInfoMap = new HashMap<>();
		List<String> ls = s.filter(l->checkForPatterMatch(l,stk,infoList,nextLine)).collect(Collectors.toList());
		 fileAndFileInfoMap.put(file.getName(),infoList );
		map.put(!ls.isEmpty(),fileAndFileInfoMap);
		infoList.forEach(System.out::println);
		return map;
	}
	private boolean checkForPatterMatch(String l,Stack<String> stk, List<String> infoList, StringBuffer nextLine) {
		stk.push(l);
		Boolean flag = false;
		String previousLine = "";
		if(l.startsWith(date) && l.contains(searchKey)) {
			stk.pop();// remove current line
			previousLine = stk.pop();// need previous line;
			infoList.add(previousLine);
			infoList.add(l);
			stk.clear();
			flag=true;
			nextLine.delete(0, nextLine.length()).append("Y");
			return flag;
		}
		if(nextLine.toString().equals("Y")) {
			infoList.add(l);
		}
		nextLine.delete(0, nextLine.length()).append("N");
		return flag;
	}

	
}
