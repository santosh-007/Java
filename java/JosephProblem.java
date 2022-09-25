package com.java;

public class JosephProblem {

	public static void main(String[] args) {
		
System.out.println(Joseph(2,3));
	}
	
	static int Joseph(int m,int k)
	{
		if(m==1)
			return 0;
		else return (Joseph(m-1,k)+k)%m; 
	}

}
