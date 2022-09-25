package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextGreaterElement {

	public static void main(String[] args) {
		
		
		int[] a=new int[] {1,2,1};
//		2 3 4 3 5 4 6 -1 4 
//		int[] b;
		nextGreaterElements(a);
		
		
	}
	
	 public static void nextGreaterElements(int[] nums) {
		 
		 
		 int n=nums.length; 
		 System.out.println("n:::"+n);
		 int a[] =new int[n];
		 Stack<Integer> s=new Stack<>();
		 int m=0;
		 for(int i=2*n-1;i>0;i--)
		 {
			 m=i%n;
			 a[m]=-1;
			 System.out.print("::m::"+m);
			 while(!s.isEmpty() && s.peek()<=nums[m])
			 {
//				 System.out.print(nums[m]+" A % " +i+"%");
				s.pop(); 
			 }
			 
			 if(!s.isEmpty() && s.peek()>nums[m])
				 
//				 System.out.print(nums[m]+" B % " +i+"%");
				 a[m]=s.peek();
//				 s.push(nums[m]);
				 
				 
//			 if(s.isEmpty())
			  
//				 System.out.print(nums[m]+"  C % " +i+"%");
//				 a[m]=-1;
			 s.push(nums[m]);
		 }
		 for(int k:a)
		 System.out.print(k+" ");
		 }
	 
	 
	 
	  static void nextGreaterElements2(int[] nums) {
	 int n=nums.length;
	 int a[] =new int[n];
	 Stack<Integer> s=new Stack<>();
	 for(int i=2*n-1;i>0;i--)
	 {
		 int m=i%n;
		
		 while(!s.isEmpty() && s.peek()<=nums[m])
			 s.pop();
		 if(!s.isEmpty()&& s.peek()>nums[m])
		 {
			 a[m]=s.peek();
		 s.push(nums[m]);
		 }
		 if(s.isEmpty())
		 {	 a[m]=-1;
		 s.push(nums[m]);
		 }
	 }
	 for(int k:a)
		 System.out.print(k+" ");
		  
	  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
		 
	 

}
