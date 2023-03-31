public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer>stack= new Stack<>();
        
        int answer[]=new int[A.length];
        
        for(int i=0;i<A.length;i++){
            int currentVal=A[i];
            while(!stack.isEmpty() && stack.peek()>=currentVal)
                stack.pop();
            
            answer[i]=stack.isEmpty()?-1:stack.peek();
            stack.push( currentVal);
        }
        
        return answer;
    }
}
