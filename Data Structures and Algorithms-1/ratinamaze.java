package dsaproject;

public class ratinamaze {
	
	static boolean isSafe(int [][]arr,int row,int col) {
		return(row<arr.length&&col<arr.length&&
				col>=0&&row>=0&&arr[row][col]==1);
	}
	
	static boolean findpath(int[][]arr,int[][]sol,int row,int col) {
		if(row==arr.length-1&&col==arr.length-1&&arr[row][col]==1) {
			sol[row][col]=1;
			return true;
		}
		if(isSafe(arr,row,col)) {
			sol[row][col]=1;
			
			if(findpath(arr,sol,row+1,col)) {
				return true;
			}
			if(findpath(arr,sol,row,col+1)) {
				return true;
			}
			sol[row][col]=0;
			return false;
		}
		return false;
	}
	static void print(int [][]array) {
		for (int i=0;i<array.length;i++) {
			for(int j=0;j<array.length;j++) {
				System.out.print(array [i][j]);
			}
			System.out.println();
			
		}
	}
	
	static void findpath(int[][]arr,int n ) {
		int [][] solution = new int[n][n];
		if(findpath(arr,solution,0,0)) {
			print(solution);
		}
		else {
			System.out.println("no solution");
		}
	}
	
	public static void main(String args[]) {
		int maze[][] = {{1,1,0,0},
						{1,1,0,0},
						{1,1,0,0},
						{0,1,1,1}};
		
		int n =maze.length;
		
		findpath(maze,n);
		}
}
