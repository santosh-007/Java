package com.java;

public class BoyerMooreMajorityVotingAlgorithm {

	public static void main(String[] args) {
		int[] a= {1,1,1,2,3,4,2,3,4,4,4,5,4,4,4,4};
System.out.println(Solution(a));
	}
	
	static int Solution(int[] a)
	{
		int count=0,no=-1;
		
		
		
		for(int i=0;i<a.length;i++)
		{
			if(count==0)
			{
				no=a[i];
			}
			else
			{
				if(a[i]==no)
					count++;
				else
					count--;
			}
		}
		count=0;
			for(int j=0;j<a.length;j++)
			{
				if(no==a[j])
					count++;
				
			}
			if(count>=(a.length/2))
				return no;
			return -1;
		
	}

}
