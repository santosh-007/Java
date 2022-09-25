package com.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a= {1,3,2,6,3,4,9,5,67,4,9};
		System.out.println(Arrays.toString(Sort(a)));

	}
	
	static int[] Sort(int[] a)
	{
		for(int i=1;i<a.length;i++)
		{
			int temp=a[i];
			int j=i-1;
			while(j>=0 && a[j]>temp)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
	
		return a;
	}

}
