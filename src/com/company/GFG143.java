//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        int[] dx = new int[]{2,2,1,-1,-2,-2,1,-1};
        int[] dy = new int[]{1,-1,2,2,1,-1,-2,-2};
        long mod = 1000000007;
        long ans = (long)((M*N)%mod * (M*N-1)%mod +mod)%mod; // total number of possible ways with attack
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                // attack position of second knigth
                for(int k = 0;k<8;k++){
                    int ni = i+dx[k];
                    int nj = j+dy[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<M){
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
}
