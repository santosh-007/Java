package com.java;

public class TCS_1 {

	public static void main(String[] args) {
		TCS_1 obj=new TCS_1();
		System.out.println(obj.solve3(12,10));

	}
	
	
	 long solve3(int A, int B) {
	       long a = A;
	       long b = B;
	       long gcd = gcd(A, B);
	       
	       return ((a * b) / gcd);
	    }
	    
	    int gcd(int a, int b){
	    	System.out.println("a::"+a+":::b:::"+b);
	        if(b==0) return a;
	        return gcd(b%a,a);
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 int solve(int A,int B) 
    { 
		 int c=A<B?A:B;
		 System.out.println("C::"+c);
    int i=1;
    while((A%(c/i)!=0) || (B%(c/i)!=0))
    {
    	System.out.println("C/i::"+c/i);
//        if(((A%(c/i)!=0) || (B%(c/i)!=0)))
//        {
          i++;
          System.out.println("i::"+i);
//        }
        
    }
    int result=(A*B)/(c/i);
                return result;}
	 
	 
	 int solve2(int A,int B) 
	    { 
			 int c=A<B?A:B;
		 int d=A>B?A:B;
			 System.out.println("C::"+c);
	   	int result=d;
	for(int i=1;i<=c;i++)
	{System.out.println("d*i::"+d*i);
		if((d*i)%c==0)
		{
			
			result= d*i;
			System.out.println("result::"+result);
			break;
		}
	}
	    
	                return result;
	                }

}
