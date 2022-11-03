import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}
class Solution {

    int removals(int[] arr, int n, int k) {

        // code here

        Arrays.sort(arr);

        int i=0,j=0;

        int ans=0;

        while(j<n)

        {

            while(arr[j]-arr[i]>k)

            {

                i++;

            }

            j++;

            ans=Math.max(ans,j-i);

        }

        return n-ans;

    }

}
