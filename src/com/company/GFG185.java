import java.util.*;
public class hashMap1 {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String str = scn.next();
            int k = scn.nextInt();
            System.out.println(solution(str,k));
        }
    }

    private static int solution(String str,int k){
        HashMap<Character,Integer> memo = new HashMap<>();
        int answer=0;
        int distinct =0;
        int release =0;

        for(int acquire =0;acquire< str.length();acquire++){
            Character currentChar= str.charAt(acquire);
            if(memo.containsKey(currentChar)){
                memo.put(currentChar,memo.get(currentChar)+1);
            }else{
                memo.put(currentChar,1);
                distinct++;
            }

            while(release < acquire && distinct > k){
                Character discardChar = str.charAt(release);
                release+=1;

                memo.put(discardChar,memo.get(discardChar)-1);
                if(memo.get(discardChar) == 0){
                    memo.remove(discardChar);
                    distinct-=1;
                }
            }
            answer+=acquire-release+1;
        }
        return answer;
    }
}
