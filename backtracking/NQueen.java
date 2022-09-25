package com.backtracking;

import java.util.Arrays;

public class NQueen {

	public static void main(String[] args) 
	{
		int n=4,row=0;
		Integer a[][]=new Integer[n][n];
		for(Integer[] m:a) 
		{
		Arrays.fill(m, 0);
		}
		System.out.println(isNQueen(a,row,n));

	}

	static boolean isNQueen(Integer[][] board, int row ,int n)
	{
		
		if(row==n)
			return true;
		
		for(int col=0;col<n;col++)
		{
			if(isSafe(board,row,col,n))
			{
				board[row][col]=1;
				
			if(isNQueen(board, row+1, n))
			{
				return true;
			}
			board[row][col]=0;
			}
				
		}
		return false;	
		
	}
	static boolean isSafe(Integer[][] board, int row,int col,int n)
	{
		for(int i=0;i<row;i++)
		{
			int p=row-i;
			if(board[i][col]==1)
			 return false;
			
			if(col>=p) {
			if(board[i][col-p]==1)
				return false;
			}
			if(col+p<n) {
			if(board[i][col+p]==1)
				return false;
		}}
		
		return true;
	}
	
}
