//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


 
class Solution
{
    int findK(int A[][], int n, int m, int k)
    {
       int startRow=0, startCol=0, endRow=n-1, endCol=m-1,indx=0;
       int arr[]= new int [n*m];
       while(startRow <= endRow && startCol<=endCol &&indx<=k){
           for(int j=startCol ;j<=endCol;j++){
               arr[indx]=A[startRow][j];
               indx++;
           }
           for(int i=startRow+1;i<=endRow;i++){
               arr[indx]=A[i][endCol];
               indx++;
           }
           for(int j=endCol-1;j>=startCol;j--){
               if(startRow==endRow){
                   break;
               }
               arr[indx]=A[endRow][j];
               indx++;
           }
           for(int i=endRow-1;i>=startRow+1;i--){
               if(startCol==endCol){
                   break;
               }
               arr[indx]=A[i][startRow];
               indx++;
           }
           startRow++;
           startCol++;
           endCol--;
           endRow--;
       }
       return arr[k-1];
    }
}
