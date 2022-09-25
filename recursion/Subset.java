package com.recursion;

import java.util.ArrayList;

public class Subset {
public static int count=0;
	private static ArrayList<String> al=new ArrayList<>();	
	public static void main(String[] args) 
	{
		String s="jyoti";
		String curr="";
		int i=0;
		ArrayList<String> result=new ArrayList<>();
		result=SubsetList(s,i,curr);
		System.out.println(count);
		System.out.println(result.size());
		System.out.println(result);
		

	}

	static ArrayList<String> SubsetList(String a,int i,String curr)
	{
	
		if(i==a.length())
		{
			al.add(curr);
			count++;
			return al;
			}
		else
			 SubsetList(a,i+1,curr+a.charAt(i));
		 SubsetList(a,i+1,curr);
			
	
		return al;
		
		
	}
	
}
