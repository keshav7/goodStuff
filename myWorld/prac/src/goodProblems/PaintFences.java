package goodProblems;

import java.util.Scanner;

/**
 * Created by keshav.gupta on 30/03/16.
 *
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *You have to paint all the posts such that no more than two adjacent
 * fence posts have the same color.
 *Return the total number of ways you can paint the fence.
 *Note: n and k are non-negative integers.
 *
 *
 */

public class PaintFences {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(findWays(n,k,0,0,false));
    }


    public static int findWays(int n,int k,int index,int prev,boolean flag) {
        int ways=0;
        int retWays=0;
        if(index==n) {
            return 1;
        }

        for(int i=1;i<=k;i++) {
            if(i==prev) {
                if(!flag) {
                    ways += findWays(n, k, index + 1, i, true);
                }
                continue;
            }
            ways+=findWays(n,k,index+1,i,false);
        }

        return ways;
    }
}
