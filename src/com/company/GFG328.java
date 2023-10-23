class Solution
{
    public int maxSumIS(int arr[], int n)  
    {
        int[] msis = new int[n];
        
        // Initialize the msis array with the values of the input array
        for (int i = 0; i < n; i++) {
            msis[i] = arr[i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }
        
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (msis[i] > maxSum) {
                maxSum = msis[i];
            }
        }
        
        return maxSum;
    }
}
