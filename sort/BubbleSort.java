package com.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] a= {1,3,2,5,4,6,9,7,8,10};
		System.out.println(Arrays.toString(Sort(a)));

	}

	static int[] Sort(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			boolean sorted=false;
			for(int j=0;j<a.length-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					sorted=true;
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
			}	}
			if(!sorted)
				break;
		}
		
		return a;
	}
}
