package com.java;

public class BestTimeToBuySellStock2 {

	public static void main(String[] args) 
	{
		int[] a= {5,2,6,1,4,7,3,6};
		System.out.println(maxprofit(a));
		
	}
	static int maxprofit(int[] a)
	{
		int profit=0;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]<a[i+1])
				profit+=a[i+1]-a[i];
		}
		return profit;
	}

}
