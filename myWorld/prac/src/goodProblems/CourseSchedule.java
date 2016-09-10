package goodProblems; /**
 * Created by keshav.gupta on 27/01/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 *Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you
 * should take to finish all courses.
 *There may be multiple correct orders, you just need to return one of them.
 *
 * If it is impossible to finish all courses, return an empty array.
 *For example:

 *2, [[1,0]] There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So the correct course order is [0,1]
 *4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take.
 * To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 * Another correct ordering is[0,2,1,3].
 */


public class CourseSchedule {
    private ArrayList<Integer> result=new ArrayList<>();
    private enum states {SEEN,UNSEEN,PROCESSED};
    ArrayList<states> nodeStates=new ArrayList<>();
    ArrayList<ArrayList<Integer>> directEdges;
    public static void main(String[] args) {
        int n;
        String line;
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        CourseSchedule courseSchedule=new CourseSchedule();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter total courses");
        n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter lists");
        while(sc.hasNextLine()) {
            line=sc.nextLine();
            if(line.isEmpty()) {
                break;
            }
            lists.add(courseSchedule.convertStringToIntArr(new ArrayList<String>(Arrays.asList(line.split(" ")))));
        }
        courseSchedule.scheduleOrder(n, lists);
    }

    public void scheduleOrder(int num,ArrayList<ArrayList<Integer>> connections ) {
        int node;
        ArrayList<Integer> nodeEdges;
        directEdges=new ArrayList<>(num);
        nodeStates=new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            directEdges.add(new ArrayList<>());
            nodeStates.add(null);
            nodeStates.set(i, states.UNSEEN);
        }
        for(ArrayList<Integer> edges: connections) {
            if(edges.size()==0) {
                continue;
            }
            node=edges.get(0);
            nodeEdges= new ArrayList<>(edges.subList(1,edges.size()));
            directEdges.set(node-1,nodeEdges);
        }
        createResultOrder();
    }

    public void createResultOrder() {
        for(int i=0;i<directEdges.size();i++) {
            if (!dfs(i)) {
                System.out.println("Unable to create Order");
                result.clear();
                return;
            }
        }
        System.out.println(result);
    }

    public Boolean dfs(int edge) {
        if(nodeStates.get(edge).equals(states.PROCESSED)) {
            return true;
        }
        if(nodeStates.get(edge).equals(states.SEEN)) {
            return false;
        }
        nodeStates.set(edge,states.SEEN);
        for(int node:directEdges.get(edge)) {
            if(!dfs(node-1)) {
                return false;
            }
        }
        nodeStates.set(edge,states.PROCESSED);
        result.add(edge+1);
        return true;
    }

    public ArrayList<Integer> convertStringToIntArr(ArrayList<String> stringArr) {
        ArrayList<Integer> integerArr=new ArrayList<Integer>();
        for(String str:stringArr) {
            integerArr.add(Integer.parseInt(str));
        }
        return integerArr;
    }
}
