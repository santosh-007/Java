package com.recursion;

public class Palindrome {

	public static void main(String[] args) {
		String s="racecar";
//		System.out.println(s.charAt(1));
System.out.println(IsPalindrome(s,0,s.length()-1));
	}

	static boolean IsPalindrome(String s,int l,int m)
	{
//		System.out.println(l+"::"+m);
	 if(l>=m)
		 return true;
//	 System.out.println(s.charAt(l)+"::"+s.charAt(m-1));
	 if(s.charAt(l)!=s.charAt(m))
		 return false;
	 else return IsPalindrome(s, l+1, m-1);
				
	}
	
}
