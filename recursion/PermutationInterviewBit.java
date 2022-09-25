package com.recursion;

import java.util.ArrayList;

public class PermutationInterviewBit {
	
	
	
	public static void main(String[] args)
	{
		ArrayList<Integer> A=new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(3);
		for(ArrayList<Integer> s:permute(A))
		{
			for(Integer s1:s)
			{
				System.out.print(s1+" ");
			}
			System.out.println("");
		}
	}
	  
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) 
    {
           ArrayList<ArrayList<Integer>> resAll= new ArrayList<>();
    
        ArrayList<Integer> res= new ArrayList<>();
       return permutation(A,res,resAll);
          
    
    }
    static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> a, ArrayList<Integer> b,ArrayList<ArrayList<Integer>> resAll)
    {
        if(a.size()==0)
        {
//        	System.out.println(b);
            resAll.add(b);
            return resAll;            
        }
        
        for(int i=0;i<a.size();i++)
        {
//        	System.out.println(a+" "+b+" "+i);
            Integer x=a.get(i);
            ArrayList<Integer> temp2=new ArrayList<>(b);
            temp2.add(x);
            ArrayList<Integer> temp=new ArrayList<>(a);
            temp.remove(x);
            permutation(temp,temp2,resAll);
        }
         return resAll;   
        
    }
}
