package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class List {

	public static void main(String[] args) {
		HashMap<String,String> al=new HashMap<>();
		al.put("ruleID","1");
		al.put("routeID","2");
		al.put("userID","3");
		al.put("senderID","4");
		
		
		
			al.put("ruleID","5");
			al.put("routeID","6");
			al.put("userID","7");
			al.put("senderID","8");
			
			for(String key:al.keySet())
			{
				System.out.println(key+" "+al.get(key));
			
			}
			
		}
	}


