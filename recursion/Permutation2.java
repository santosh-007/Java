package com.recursion;

import java.util.ArrayList;

public class Permutation2 {

	public static void main(String[] args) 
	{
		String a="abc";
		Permutation(a,"");
	}

	
	static void Permutation(String s,String ans)
	{
		 ArrayList<ArrayList<Integer>> resAll= new ArrayList<>();
	
		if(s.length()==0)
		{	System.out.println(ans);
		return;}
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			String b=s.substring(0,i)+s.substring(i+1);
			
			Permutation(b, ans+ch);
		}
		
		
	}
}
