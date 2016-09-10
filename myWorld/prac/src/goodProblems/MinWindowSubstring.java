package goodProblems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 28/03/16.
 *
 * Minimum Window Substring Given a string S and a string T, find the minimum window in
 * S which will contain all the characters in T in complexity O(n).
 *
 *For example,
 *S = "ADOBECODEBANC"
 *T = "ABC"
 *Minimum window is "BANC".
 *Note: If there is no such window in S that covers all characters in T, return the emtpy string "".
 *
 *If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 *
 */
public class MinWindowSubstring {

    int left,count,currCount;
    HashMap<Character,Integer> mapPerChar,map;
    int p,q,len;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.printf("Enter main string");
        String S=sc.nextLine();
        //System.out.printf("Enter sub string");
        String T=sc.nextLine();
        MinWindowSubstring minWindowSubstring=new MinWindowSubstring();
        minWindowSubstring.findMinWindow(S,T);
        System.out.println("Substring is: "+S.substring(minWindowSubstring.p,minWindowSubstring.q+1));
    }

    public void findMinWindow(String s,String t) {
        p=q=0;
        len=s.length()+1;
        if(s.length()<t.length()) {
            return;
        }
        mapPerChar=new HashMap<>();
        map=new HashMap<>();
        currCount=0;
        count=t.length();

        int i=0;
        for(i=0;i<t.length();i++) {
            //populate character count for the smaller string
            if(mapPerChar.get(t.charAt(i))!=null) {
                mapPerChar.put(t.charAt(i),mapPerChar.get(t.charAt(i))+1);
                continue;
            }
            mapPerChar.put(t.charAt(i),1);
        }

        for(i=0;i<s.length();i++) {

            if(mapPerChar.get(s.charAt(i))!=null) {
                if(map.get(s.charAt(i))==null) {
                   map.put(s.charAt(i),1);
                }
                else {
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }

                if(map.get(s.charAt(i))<=mapPerChar.get(s.charAt(i))) {
                    currCount++;
                }
            }

            if(currCount==count) {
                while(map.get(s.charAt(left))==null||map.get(s.charAt(left))>mapPerChar.get(s.charAt(left))) {
                    if(map.get(s.charAt(left))!=null &&map.get(s.charAt(left))>mapPerChar.get(s.charAt(left))) {
                        map.put(s.charAt(left),map.get(s.charAt(left))-1);
                    }
                    left++;

                }
            }
            if((i-left+1)<len && currCount==count) {
                p=left;
                q=i;
                len=i-left+1;
            }

        }




    }



}
