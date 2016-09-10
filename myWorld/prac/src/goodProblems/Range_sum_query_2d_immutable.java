package goodProblems;

import java.util.*;

/**
 * Created by keshav.gupta on 04/04/16.
 *
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 *Range Sum Query 2D The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *Example:
 *Given matrix = [
 *[3, 0, 1, 4, 2],
 *[5, 6, 3, 2, 1],
 *[1, 2, 0, 1, 5],
 *[4, 1, 0, 1, 7],
 *[1, 0, 3, 0, 5]
 *]
 *sumRegion(2, 1, 4, 3) -> 8
 *update(3, 2, 2)
 *sumRegion(2, 1, 4, 3) -> 10
 *
 */
public class Range_sum_query_2d_immutable {

    public ArrayList<ArrayList<Integer>> input=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> hash=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Range_sum_query_2d_immutable range_sum_query_2d_immutable=new Range_sum_query_2d_immutable();
//        System.out.println("Enter number of rows\n");
//        int numRows=sc.nextInt();
        ArrayList<String> stringArr;
        ArrayList<Integer> input=new ArrayList<>();
        for(int i=0;i<5;i++) {
            String str=sc.nextLine();
            stringArr= new ArrayList<>(Arrays.asList(str.split(" ")));
            input.clear();
            stringArr.forEach(p -> input.add(Integer.parseInt(p)));
            range_sum_query_2d_immutable.input.add((ArrayList<Integer>)input.clone());
        }
        System.out.println(range_sum_query_2d_immutable.input);
        range_sum_query_2d_immutable.populateHash(range_sum_query_2d_immutable.input);
        System.out.println(range_sum_query_2d_immutable.getSum(2,1,4,3));

    }

    public void populateHash(ArrayList<ArrayList<Integer>> input) {
        int col=input.size();
        int i,j,sum;
        ArrayList<Integer> temp=new ArrayList<Integer>(Collections.nCopies(col+1,0));
        for(i=0;i<col+1;i++) {
            hash.add((ArrayList<Integer>)temp.clone());
        }
        for(i=1;i<col+1;i++) {
            for(j=1;j<col+1;j++) {
                sum=hash.get(i-1).get(j)+hash.get(i).get(j-1)-hash.get(i-1).get(j-1)+input.get(i-1).get(j-1);
                hash.get(i).set(j,sum);
            }
        }
        System.out.println("\n" + hash);

    }

    public int getSum(int i,int j,int m,int n) {
        return hash.get(m+1).get(n+1)-(hash.get(i).get(n+1)+hash.get(m+1).get(j))+hash.get(i).get(j);
    }
}
