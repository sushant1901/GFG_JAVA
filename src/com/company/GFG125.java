class Solution{
    public int countTriplets(int[] nums){
        int n = nums.length;
        //If the array contains less than 3 elements then there will be no magic triplets so return 0
        if(n <= 2){
            return 0;
        }
        int magicTripletsCount = 0;
        for(int i = 1;i<n-1;i++){
            //For every index count the number of smaller elements on the left side
            int small = 0,large = 0;
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    small++;
                }
            }
            //For every index count the number of larger elements on the right side
            for(int k=i+1;k<n;k++){
                if(nums[k] > nums[i]){
                    large++;
                }
            }
            //Add the number of triplets to the answer
            magicTripletsCount += small*large;
        }
        return magicTripletsCount;
    }
}
