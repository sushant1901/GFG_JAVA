//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;

        int[] visited = new int[100000];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int temp = q.poll();
            int currentSteps = visited[temp];

            for (int num : arr) {
                int newStart = (temp * num) % 100000;

                if (newStart == end) return currentSteps + 1;
                if (visited[newStart] == -1) {
                    q.offer(newStart);
                    visited[newStart] = currentSteps + 1;
                }
            }
        }

        return -1;
    }
}
