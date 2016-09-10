package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 04/05/16.
 */
public class kFlipZeroes {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Integer k=sc.nextInt();


        ArrayList<String> input= new ArrayList<String>(Arrays.asList(str.split(" ")));

        ArrayList<Integer> inputInts=new ArrayList<>();
        input.forEach(p->inputInts.add(Integer.parseInt(p)));

        int p,q,count,zeroCount,oneCount,max;
        zeroCount=oneCount=max=0;
        p=q=0;



        while(q<inputInts.size()) {
            if(inputInts.get(q)==0) {
                zeroCount++;
            }
            while(p<q&&zeroCount>k) {
                if(inputInts.get(p)==0) {
                    zeroCount--;
                    p++;
                }
            }

            if((q-p+1)>k) {
                max=q-p+1;
            }

            q++;
        }

        System.out.println("Answer: "+max);

    }
}
