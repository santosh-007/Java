package com.backtracking;

import java.util.ArrayList;

public class PermutationWithDuplicate {
	
	
	
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
        
        int length=A.size();
        
       return permutation(A,0,length,resAll);
          
    
    }
    static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> a, int l, int r ,ArrayList<ArrayList<Integer>> resAll)
    {
        if(l==r)
        {
//        	System.out.println(b);
            resAll.add(a);
            return resAll;            
        }
        
        for(int i=l;i<r;i++)
        {
//        	System.out.println(a+" "+b+" "+i);
          
        	swap(a,l,i);
        	
            permutation(a,l+1,r,resAll);
            swap(a,l,i);
        }
         return resAll;   
        
    }
    
    static ArrayList<Integer> swap(ArrayList<Integer> a,int l,int r)
    {
		int temp1=a.get(l);
		a.add(l, a.get(r));
		a.add(r, temp1);
		
    	  	return a;
    	
    }
    
}
