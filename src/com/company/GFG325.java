class Solution {
    static int isPossible(int N, int arr[]) {
        // code here
        long count = 0;
        for(int i =0;i<N;i++) {
            count+=arr[i];
        }
        if(count%3==0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
