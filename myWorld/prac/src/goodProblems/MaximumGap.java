package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 21/03/16.
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Example 2 3 10 6 4 8 1 return 8 i.e. bw 2 and 10
 */
public class MaximumGap {


    public static void main(String[] args) {

        MaximumGap maximumGap=new MaximumGap();
        Scanner sc=new Scanner(System.in);
        int min,max;

        String input=sc.nextLine();
        ArrayList<String> inp=new ArrayList<>(Arrays.asList(input.split(" ")));
        ArrayList<Integer> inputInteger=maximumGap.convertStringArrToIntArr(inp);
        min=inputInteger.get(0);
        max=-1;
        for(int i=1;i<inputInteger.size();i++) {
            if(inputInteger.get(i)>min && (inputInteger.get(i)-min)>max) {
                max=inputInteger.get(i)-min;
            }
            else {
                min=inputInteger.get(i);
            }
        }
        System.out.println(max);

    }

    public ArrayList<Integer> convertStringArrToIntArr(ArrayList<String> strList) {
        ArrayList<Integer> intArr=new ArrayList<>();
        for(int i=0;i<strList.size();i++) {
            intArr.add(Integer.parseInt(strList.get(i)));
        }
        return intArr;
    }


}
