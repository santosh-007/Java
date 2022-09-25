package com.sort;

import java.util.Arrays;

//get the min element and swap with starting element

public class SelectionSort {

	public static void main(String[] args) {
		int[] a= {1,3,2,6,3,4,9,5,67,4,9};
		System.out.println(Arrays.toString(Sort(a)));

	}
	static int[] Sort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			int min=a[i];
			int temp=i;
			for(int j=i;j<a.length;j++)
			{
				if(a[j]<min)
				{
					min=a[j];
					temp=j;
				}
				
			}
			int temp1=a[i];
			a[i]=a[temp];
			a[temp]=temp1;
			
		}
		
		return a;
	}

}
