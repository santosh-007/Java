package com.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 99, 88, 77, 66, 55, 44};
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}
	
	static void sort(int[] a ,int l, int r)
	{
		if(l<r)
		{
			int mid=((l+r)/2);
			System.out.println("mid::"+mid);
			sort(a,l,mid);
			sort(a,mid+1,r);
			merge(a,l,mid,r);
		}
	}
	
	static void merge(int[] a,int l,int mid, int r)
	{
		int i=l;
		int j=mid+1;
		int k=l;
		int[] b=new int[r+1];
		while(i<=mid && j<=r)
		{
			System.out.println("a[i]::"+a[i]+"::a[j]::"+a[j]);
			if(a[i]<a[j])
			{
				b[k]=a[i];
				System.out.println("b[k]:i::"+b[k]);
				i++;
			}
			else
			{
				b[k]=a[j];
				System.out.println("b[k]:j::"+b[k]);
				j++;
			}
			k++;
		}
		if(i>mid)
		{
			while(j<=r) {
			b[k]=a[j];
			k++;
			j++;
			}
		}
		else if(j>r)
		{
			while(i<=mid) {
		b[k]=a[i];
		i++;
		k++;
		}
			}
		
		for(int t=l;t<=r;t++)
		{
			a[t]=b[t];
			System.out.println("a[t]:::"+a[t]);
		}
	}

}
