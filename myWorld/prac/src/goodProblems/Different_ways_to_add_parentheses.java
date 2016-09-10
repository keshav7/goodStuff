package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 30/01/16.
 */
public class Different_ways_to_add_parentheses {

    ArrayList<Integer> result =new ArrayList<>();
    HashMap<String,ArrayList<Integer>> memo=new HashMap<>();

    public ArrayList<Integer> findWays(String input) {
        if(memo.get(input)!=null) {
            return memo.get(input);
        }
        ArrayList<Integer> left,right,currentResult;
        currentResult=new ArrayList<>();
        String digit="";
        int i;
        for(i=0;i<input.length();++i) {
            if(Character.isDigit(input.charAt(i))) {
                digit+=input.charAt(i);
                digit.trim();
            }
            else {
                break;
            }
        }
        if(i==input.length()) {
            return new ArrayList<>(Arrays.asList(Integer.valueOf(digit)));
        }

        for(i=0;i<input.length();++i) {
            if(!Character.isDigit(input.charAt(i))) {
                left=findWays(input.substring(0,i));
                right=findWays(input.substring(i+1,input.length()));
                for(int eachLeft:left) {
                    for(int eachRight:right) {
                        currentResult.add(performArithematic(eachLeft,eachRight,input.charAt(i)));
                    }
                }
            }
        }
        memo.put(input,currentResult);
        return memo.get(input);
    }

    public int performArithematic(int left,int right,char operator) {
        switch(operator) {
            case '+': return left+right;
            case '-': return left-right;
            case '*': return left*right;
            case '/': return left/right;
            default: return 1;
        }
    }

    public static void main(String[] args) {
        Different_ways_to_add_parentheses different_ways_to_add_parentheses=new Different_ways_to_add_parentheses();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string with numebrs and operators only");
        String input=sc.nextLine();
        different_ways_to_add_parentheses.findWays(input);

        System.out.println(different_ways_to_add_parentheses.memo.get(input));
    }



}
