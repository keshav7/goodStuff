package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 01/02/16.
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPositiveNumber {

    public static void main(String[] args) {
        FirstMissingPositiveNumber obj=new FirstMissingPositiveNumber();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers list");
        String input = sc.nextLine();
        ArrayList<Integer> inputNumbers = obj.convertStringToIntArr(new ArrayList(
                                        Arrays.asList(input.split(" "))));
        System.out.println("First missing positive number is:" + obj.findFirstMissingPositiveNumber(inputNumbers));
        System.out.println(inputNumbers);

    }

    public int findFirstMissingPositiveNumber(ArrayList<Integer> inputNumbers) {
        int i=0;
        while(i<inputNumbers.size()) {
            if((i==inputNumbers.get(i)-1)||
                    (inputNumbers.get(i)<0)||
                    (inputNumbers.get(i)>=inputNumbers.size())) {
                i++;
                continue;
            }
            Collections.swap(inputNumbers,i,inputNumbers.get(i)-1);
        }
        for(i=0;i<inputNumbers.size();i++) {
            if(inputNumbers.get(i)!=i+1) {
                return i+1;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> convertStringToIntArr(ArrayList<String> stringArr) {
        ArrayList<Integer> integerArr=new ArrayList<Integer>();
        for(String str:stringArr) {
            integerArr.add(Integer.parseInt(str));
        }
        return integerArr;
    }


}
