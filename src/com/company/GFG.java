package com.company;

import java.io.*;
import java.util.*;
public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution1 ob = new Solution1();
            System.out.println(ob.sumOfMatrix(N, M, Grid));
        }
    }
}
class Solution1 {
    int sumOfMatrix(int N, int M, int[][] Grid) {
        int sum=0;
        for(int row=0;row<N;row++){
            for(int col=0;col<M;col++){
                sum+=Grid[row][col];
            }
        }
        return sum;
    }
}