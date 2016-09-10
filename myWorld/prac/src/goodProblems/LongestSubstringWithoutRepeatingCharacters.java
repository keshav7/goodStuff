package goodProblems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 16/03/16.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();

        input=input.toLowerCase();
        HashMap<String,Integer> hash=new HashMap<>();
        int temp,p,q,max;
        temp=max=0;
        p=q=0;
        for(int i=0;i<input.length();i++) {
            String curr=Character.toString(input.charAt(i));
            if((hash.get(curr)==null)||
               (i-hash.get(curr)>temp)) {
                temp++;
                if(temp>max) {
                    max=temp;
                    p=i-temp+1;
                    q=i;
                }
            }
            else {
                temp=i-hash.get(curr);
            }
            hash.put(curr,i);

        }
        System.out.println(input.substring(p,q+1));
    }
}
