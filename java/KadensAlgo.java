package com.java;

//max sub array sum
//if all no are positive then sum of all will be max
//problem comes when nos are negative in between

public class KadensAlgo {

	public static void main(String[] args) 
	{
		int[] a= {1,2,-1,4,-8,6,1,2};
		System.out.println(maxSubArraySum(a));

	}
	static int maxSubArraySum(int[] a)
	{
		int maxSum=0;
		int sum=0;
		
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
			
			if(sum>maxSum)
				maxSum=sum;
			
			if(sum<0)
			{
				sum=0;
			}
		}
		return maxSum;
	}

}
