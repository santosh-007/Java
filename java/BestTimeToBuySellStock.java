package com.java;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		int[] a= {7,1,5,3,6,4};
System.out.println(maxProfit(a));
	}
	
	static int maxProfit(int[] prices)
	{
		 int profit=0;
	        int maxProfit=0;
	       int min=prices[0];
	        
	        for(int i=1;i<prices.length;i++)
	        {
	            if(min>prices[i])
	                min=prices[i];
	            
//	            else
//	            {
	                profit=prices[i]-min;
	                if(profit>maxProfit)
	                    maxProfit=profit;
	                System.out.println(maxProfit);
//	            }
	        }
	        return maxProfit;
	    }
	}


