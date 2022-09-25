package com.backtracking;

import java.util.Arrays;

public class KnightsTour {
	private static Integer[][] board=new Integer[8][8];
	private static Integer[] row=new Integer[] {2,1,-1,-2,-2,-1,1,2};
	private static Integer[] col=new Integer[] {1,2,2,1,-1,-2,-2,-1};
	private static int n=8;
	private static int itr=1;
	public static void main(String[] args) throws InterruptedException 
	{
		int n=0,m=0;
		
		for(Integer[] s:board)
		{
			Arrays.fill(s, -1);
		}
		
		CheckKnight(n,m);

	}
	
	private static void CheckKnight(int n1,int n2) throws InterruptedException
	{
	
		
		System.out.println("n1:::"+n1+":::n2::"+n2);
	if(!Knight(board,n1,n2,1,row,col))
	{
		System.out.println("Matrix does not exist");
	}
	else
		print(board);
		
	}
	
	private static void print(Integer[][] board)
	{
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{	
			System.out.print(board[i][j]+" ");
	    }
		System.out.println();
	}
	}
	
	private static boolean Knight(Integer[][] board,int i,int j,int count,Integer[] row,Integer[] col) throws InterruptedException
	{
//		Thread.sleep(100);
		int nextX,nextY;
		if(count==n*n)
			return true;
		System.out.println("i::"+i+":J::"+j+"::count::"+count);
		for(int k=0;k<8;k++)
		{
			nextX=i+row[k];
			nextY=j+col[k];
			if(IsSafe(board,nextX,nextY))
			{
				System.out.println("i:****:"+i+":J::"+j+"::count::"+count);
//				System.out.println(i+"::"+j);
				board[nextX][nextY]=count;
//				System.out.println(count);
				if(Knight(board, nextX, nextY, count+1, row, col))
					return true;
				else 
					board[nextX][nextY]=-1;
				}
			}
		return false;
		}
	
	private static boolean IsSafe(Integer[][] board,int x,int y)
	{
		
		if(x>=0 && x<8 && y>=0 &&  y <8 && board[x][y]==-1)
		{
			System.out.println(itr++);
				return true;
		}
		return false;		
	}

}
