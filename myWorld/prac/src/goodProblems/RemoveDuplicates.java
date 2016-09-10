package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 05/04/16.
 *
 * Remove duplicates from sorted array
 *
 * Follow up : If duplicates are allowed at most twice.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String> stringInput;
        ArrayList<Integer> integerInput=new ArrayList<>();

        stringInput=new ArrayList<>(Arrays.asList(str.split(" ")));
        stringInput.forEach(p->integerInput.add(Integer.parseInt(p)));

        int i=0;
        int j=1;
        int temp;
        for(j=1;j<stringInput.size();j++) {
            if((integerInput.get(j)==integerInput.get(i)) &&
                    (i==0||integerInput.get(i-1)==integerInput.get(i))) {
                if(i==0) {
                    i++;
                }
                continue;
            }
            i++;

            temp=integerInput.get(i);
            integerInput.set(i,integerInput.get(j));
            integerInput.set(j,temp);
        }

        System.out.println(integerInput.subList(0,i+1));

    }

}
