package com.recursion;
import java.util.ArrayList;

public class Permutation {
private static ArrayList<String> al=new ArrayList<>();
	public static void main(String[] args) {
//	int i=0;
	String a="abc";
//	String b=a,c="";
	int l=0, r = a.length()-1;
		AllPermutation(a,l,r);
	}
	static void AllPermutation(String a,int l,int r)
	{
		if(l==(r-1)) {
			System.out.println(a);
		return;
		}
		for(int i=0;i<=r-l;i++) {
		a=swap(a,l,i,r);
		AllPermutation(a, l+1, r);
		a=swap(a,l,i,r);
		}
		
	}
	static String swap(String s,int l,int i,int k)
	{
//		System.out.println(l+"::"+k);
//		System.out.println(a.substring(0,l));
//		System.out.println(l+"::a.substring(l, l)"+a.substring(0,l)+"::a.substring(l, k):"+a.substring(l+1, k));
		String s1="";
//		
//		if(l==k)
//		 s=a;		
//		else
//			s=a.substring(0,l)+a.charAt(k)+a.substring(l, k)+a.charAt(l);
		String a=s.substring(0,l);
//		String b=s.charAt(i);
		String c= i!=(k-2)?s.substring(i+1):"";
		s1=s.charAt(i)+a+c;
		
		
	return s1;	
	}

}
