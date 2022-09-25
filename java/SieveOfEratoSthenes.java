package com.java;

import java.util.ArrayList;
import java.util.Arrays;

public class SieveOfEratoSthenes {

	public static void main(String[] args) {
		int n=1000;
		boolean[] al=IsPrime(n);
		for(int i=2;i<=n;i++)
		{
//			if(al[i]==true)
//		System.out.println(i+" "+al[i]);
		}
	}
	
	static boolean[] IsPrime(int n)
	{
		boolean[] a=new boolean[n+1];
		
		Arrays.fill(a,true);
		a[0]=false;
		a[1]=false;
		int count=0;
		
		for(int i=2;i*i<=n;i++)
		{
			if(a[i]==true)
			{
			for(int j=2*i;j<=n;j=j+i)
			{
//				System.out.println(j);
				a[j]=false;
				count++;
			}
		}}
		System.out.println("total iteration count:::"+count);
				
		return a;
	}

}
