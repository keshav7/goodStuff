package goodProblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 21/05/16.
 */
public class Scalper {


    public static void main(String[] args) throws IOException {
        Scalper scal=new Scalper();
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        long res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        long _k;
        _k = Long.parseLong(in.nextLine().trim());




          res = scal.maximumAmount(_a, _k);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//
//        bw.close();
    }


    public long maximumAmount(int[] _a, long _k) {
        Arrays.sort(_a);

        long total=0;
        long sum=0;

        if(_a[0]==_a[_a.length-1]) {
                for(int i=0;i<_a.length&&total<_k;i++) {
                    sum+=_a[i];
                    _a[i]--;
                }
            if(total==_k) {
                return sum;
            }
            return -1;
        }
        else {
            return func(_a,1,0,0,_k);
        }

    }

    public long func(int[] arr,int index,long total,long sum,long k) {


        System.out.print("");

        long sum1=sum;
        long total1=total;
        for(int i=0;i<index;i++) {
            while(arr[i]>arr[index]&&total<k) {
                sum1+=arr[i];
                total1++;
                arr[i]--;
            }
            if(total==k) {
                return sum1;
            }
        }
        return func(arr,index+1,total1,sum1,k);

    }



}
