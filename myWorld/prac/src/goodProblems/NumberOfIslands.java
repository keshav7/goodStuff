package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 28/03/16.
 */
public class NumberOfIslands {

    int max;
    ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
    ArrayList<ArrayList<Boolean>> processedMemo=new ArrayList<>();
    ArrayList<ArrayList<Boolean>> visitedMemo=new ArrayList<>();
    public static void main(String[] args) {

        NumberOfIslands numberOfIslands=new NumberOfIslands();
        Scanner sc=new Scanner(System.in);
        String line;
        ArrayList<String> input;
        ArrayList<Integer> inputInt=new ArrayList<>();
        ArrayList<Boolean> processedBool=new ArrayList<>();
        ArrayList<Boolean> visitedBool=new ArrayList<>();
        while(sc.hasNextLine()) {
            line=sc.nextLine();
            if(line.isEmpty()) {
                break;
            }
            input= new ArrayList(Arrays.asList(line.split(" ")));
            inputInt.clear();
            processedBool.clear();
            visitedBool.clear();
            input.forEach(p -> inputInt.add(Integer.valueOf(p)));
            input.forEach(p -> processedBool.add(null));
            input.forEach(p->visitedBool.add(false));
            numberOfIslands.matrix.add((ArrayList<Integer>) inputInt.clone());
            numberOfIslands.processedMemo.add((ArrayList<Boolean>)processedBool.clone());
            numberOfIslands.visitedMemo.add((ArrayList<Boolean>)visitedBool.clone());
        }
//        System.out.println(numberOfIslands.matrix);
//        System.out.println(numberOfIslands.processedMemo);
        numberOfIslands.findNumberOfIslands(0, 0, numberOfIslands.matrix.size(), numberOfIslands.matrix.get(0).size());
        System.out.println(numberOfIslands.max);

    }


    public boolean findNumberOfIslands(int i,int j,int m,int n) {

        if(i==0&&j==3) {
            System.out.println("hello");
        }
        if(i<0||i>=m||j<0||j>=n) {
            return false;
        }
        if(processedMemo.get(i).get(j)!=null) {
            return processedMemo.get(i).get(j);
        }
        if(visitedMemo.get(i).get(j)) {
            if(matrix.get(i).get(j)==1) {
                return true;
            }
            return false;
        }

        visitedMemo.get(i).set(j,true);

        Boolean l=findNumberOfIslands(i,j-1,m,n);
        Boolean r=findNumberOfIslands(i,j+1,m,n);
        Boolean u=findNumberOfIslands(i-1,j,m,n);
        Boolean d=findNumberOfIslands(i+1,j,m,n);

        processedMemo.get(i).set(j,true);

        if(!l && !r && !u && !d && matrix.get(i).get(j)==1) {
            max++;
            System.out.println("i: "+i+"  j: "+j+"\n");
            //return true;
        }
        else {
            processedMemo.get(i).set(j, false);
        }
//        if(matrix.get(i).get(j)==0) {
//            return false;
//        }

        return processedMemo.get(i).get(j);

    }

}
