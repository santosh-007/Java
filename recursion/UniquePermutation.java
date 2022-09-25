package com.recursion;

import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;

// unique permutaion in lexicographical order (sorted)


public class UniquePermutation {


	public static void main(String[] args) {
		for(String s:find_permutation("SantoshK"))
		{
			System.out.println(s);
		}

	}
	static List<String> find_permutation(String S) 
    {
        TreeSet<String> t=new TreeSet<>();
        int l=S.length();
        t=permutation(S,"",t);
        
    List<String> al=new ArrayList<>();
    
    for(String s:t)
    {
        al.add(s);
    }
        
        
        return al;
    }
    
    static TreeSet<String> permutation(String S,String res,TreeSet<String> t) 
    {
    	System.out.println("S::"+S+"::res::"+res);
        if(S.length()==0)
        { 
        	t.add(res);
        return t;
        }
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
             String b=S.substring(0,i)+S.substring(i+1);
//            res=res+ch;
           t= permutation(b,res+ch,t);
            
        }
//        return;
        return t;
        
    }

}
