package com.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] a = { 99, 88, 77, 66, 55, 44, 33, 22, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));

	}

	static void sort(int[] a, int l, int h) {
		int pivotIndex = 0;
		if (l < h) {
			pivotIndex = partition(a, l, h);
			sort(a, l, pivotIndex - 1);
			sort(a, pivotIndex + 1, h);
		}
		return;
	}

	static int partition(int a[], int l, int h) {

		int i = l;
		int pivot = a[l];
		int j = h;

		while (i < j) {

			while (a[i] <= pivot && i < h)
				i++;

			while (a[j] >= pivot && j > l)
				j--;

			if (i < j)
				swap(a, i, j);
		}

		if (j != l)
			swap(a, j, l);

		return j;
	}

	static void swap(int[] a, int l, int k) {
		int temp = a[l];
		a[l] = a[k];
		a[k] = temp;
	}
	
	
	
//	***************************************************************************************
	
	
	

//	public static void main(String[] args) {
////		int[] a= {7,8,1,9,3,4,7,55,66,62,32,35};
//		int[] a= {99,88,77,66,55,44,33,22,11,9,8,7,6,5,4,3,2,1,0};
//		sort(a,0,a.length-1);
//		System.out.println(Arrays.toString(a));
//
//	}
//	
//	static void sort(int[] a, int l, int h)
//	{
//		 int  pivotIndex = 0;
////		System.out.println("l11::"+l+"::h:"+(h));
//		if(l<h)
//		{
//			pivotIndex =	partition(a,l,h);
////		System.out.println("pivotIndex::"+pivotIndex);
////		if(pivotIndex>0) {
////			System.out.println("l11::"+l+"::pivotIndex-1:"+(pivotIndex-1)+"::h:"+h);
//		sort(a,l,pivotIndex-1);
////		return;
////		}
////		if(pivotIndex<a.length) {
////			System.out.println("pivotIndex+1::"+(pivotIndex+1)+"::h:"+h);
//		sort(a,pivotIndex+1,h);
////		return;
//		}
//		return ;																														
//	}
//	
////	 int partition1(int[] a,int l,int h)
////	{
////		int pivot=a[l];
////		System.out.println("pivot::"+pivot);
////		int i=l+1;
////		int j=h;
////		while(i<=j)
////		{
////			System.out.println("a::"+Arrays.toString(a));
////			System.out.println("i::"+i+"::j::"+j+"a{i}"+a[i]+"::a[j]::"+a[j]);
////			while(a[i]<pivot && i<=h)
////			{
////				i++;
////				System.out.println("i::"+i+"a{i}"+a[i]);
////			}
////			while(j>0 && pivot<a[j])
////				j--;
////			
////			System.out.println("i::"+i+"::j::"+j);
////			if(i<j)
////				swap(a,i,j);
////			
////		}
////		System.out.println("l::"+l+"::j::"+j);
////		swap(a,l,j);
////		System.out.println(j);
////		return j;
////	}
//	
//static int partition(int a[], int l, int h){
//        
//        int i=l;
//        int pivot= a[l];
//        int j=h;
//      
//        while (i<j){
//            
//            while(a[i] <= pivot && i<h) i++;
//            
//            while(a[j] >= pivot && j>l) j--;
//            
//            if(i<j)
//                swap(a, i, j);
//        }
//        
//        if(j!=l)    
//            swap(a, j, l);
//        
//        return j;
//    }
//	static void swap(int[] a, int l,int k)
//	{
//		System.out.println("l::"+l+"::k::"+k);
//		System.out.println("a[i]::"+a[l]+"::a[j]::"+a[k]);
//		int temp=a[l];
//		a[l]=a[k];
//		a[k]=temp;		
//		System.out.println("a:1:"+Arrays.toString(a));
//	}

}
