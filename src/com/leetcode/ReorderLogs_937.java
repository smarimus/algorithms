package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ReorderLogs_937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] logs = { "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car" };
		reorderLogFiles(logs);

	}

	public static String[] reorderLogFiles(String[] logs) {

		List<String> numberList = new ArrayList<>();
		Map<String, String> stringMap = new HashMap<>();
		int j = 0;
		
		
		for (String log : logs) {

			String[] logsArr = log.split(" ", 2);
			String data = logsArr[1];

			boolean isNumber = true;
			try {
				System.out.println(Integer.parseInt(data));
			} catch (NumberFormatException nf) {
				isNumber = false;
			}

			if (isNumber) {
				numberList.add(log);
			} else {
				stringMap.put(getKey(logsArr) + j++, log);
			}
		}

		TreeSet<String> sortedStrs = new TreeSet(stringMap.keySet());
		String[] result = new String[logs.length];
		int i = 0;
		for (String sortedStr : sortedStrs) {
			result[i++] = stringMap.get(sortedStr);
		}
		for (String s : numberList) {
			result[i++] = s;
		}

		return result;
	}
	
	static String getKey(String[] logs){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < logs.length; i++) {
			sb.append(logs[i]);
		}
		return sb.toString();
	}

}
