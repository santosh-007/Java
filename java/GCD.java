package com.java;

public class GCD {

	public static void main(String[] args) {
//		int a=GcdNo(12,8);
//System.out.println(a);
		
		System.out.println(GcdNo(15,27));
	}
static int GcdNo(int a,int b)
{

	
//	
//	if(b==0)
//	{
//		return a;
//	}
//	else return GcdNo(b,a%b);
	
return b==0?a:GcdNo(b,a%b);
		
	
	
//return a;
}
}
