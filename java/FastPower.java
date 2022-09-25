package com.java;

public class FastPower {

	public static void main(String[] args) 
	{
		
System.out.println(FastPowerCal(4,4));
	}
	static int FastPowerCal(int a,int b)
	{ int res=1;
	
	while(b>0)
	{
		if((b&1)!=0)
		{
			res=res*a;
		}
		a=a*a;;
		b=b>>1;
	}
	
	return res;
	}

}
