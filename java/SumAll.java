package com.java;

public class SumAll {

	public static void main(String[] args) 
	{
		SumAll obj=new SumAll();
		int result=obj.solve(99);
		System.out.println(result);
		   
		}
	
	  int solve(int A) 
	    {System.out.println("A1::"+A);
	        int sum=0;
	        while(A!=0)
	        {
	        	System.out.println("A2::"+A);
	        	System.out.println("sum::"+sum);
	            sum=sum+A%10;
	            System.out.println("sum2::"+sum);
	            A=A/10;
	            System.out.println("A3::"+A);
	        }
	        if(sum/10!=0)
	        { sum=solve(sum);
	        	 
	        }
	        else 
	        	System.out.println("sum final::"+sum);
            return sum;
//	        System.out.println("sum return::"+sum);
//	        return sum; 
	    }

	}


