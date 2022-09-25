package com.java;

public class MatrixRecursive {

	public static void main(String[] args) {
		System.out.println(Matrix(2,2));

	}
static int Matrix(int a,int b)
{
	int res=0;
if(a==1 || b==1)
{
	return 1;
}
else return Matrix(a-1,b)+Matrix(a,b-1);

 
}
}
