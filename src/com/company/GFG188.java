// from pepcoding--->Longest Subarray With Equal Number Of 0s 1s And 2s
import java.util.*;

public class hashMap4 {

    public static int solution(int[] arr) {
        int answer=0;
        int z0=0;
        int z1=0;
        int z2=0;
        
        HashMap<String,Integer>memo= new HashMap<>();
        String expr=(z1-z0)+"-"+(z2-z1);
        memo.put(expr,1);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) z0++;
            else if(arr[i]==1) z1++;
            else z2++;
            
            expr=(z1-z0)+"-"+(z2-z1);
            
            if(memo.containsKey(expr)){
                answer=Math.max(answer,i-memo.get(expr));
            }else{
                memo.put(expr,i);
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }
            System.out.println(solution(arr));
        }
    }

}
