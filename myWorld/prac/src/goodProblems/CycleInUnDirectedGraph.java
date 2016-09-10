package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 03/02/16.
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 *For example:
 *Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 *Hint:
 *
 *According to the definition of tree on Wikipedia:
 *Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 *In other words, any connected graph without simple cycles is a tree.”
 *: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 *“a tree is an undirected graph in which any two vertices are connected by exactly one path.
 *[0, 1] is the same as [1, 0] and thus will not appear together inedges.
 */
public class CycleInUnDirectedGraph {

    ArrayList<Boolean> visited=new ArrayList<>();
    ArrayList<ArrayList<Integer>> connectionsPerNode=new ArrayList<>(5);


    public static void main(String[] args) {
        CycleInUnDirectedGraph cycleInUnDirectedGraph=new CycleInUnDirectedGraph();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter connections");
        ArrayList<String> connections= new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        int node1,node2;
        for(String connection:connections) {
            node1=Integer.parseInt(connection.split(",")[0]);
            node2=Integer.parseInt(connection.split(",")[1]);
            if(cycleInUnDirectedGraph.connectionsPerNode.get(node1)==null) {
               cycleInUnDirectedGraph.connectionsPerNode.set(node1,new ArrayList<>());
            }
            cycleInUnDirectedGraph.connectionsPerNode.get(node1).add(node2);
        }
        for(int i=0;i<cycleInUnDirectedGraph.connectionsPerNode.size();i++) {
            cycleInUnDirectedGraph.visited.set(i,false);
        }
        System.out.println(cycleInUnDirectedGraph.ifCyclicGraph(0,-1,cycleInUnDirectedGraph.visited));


    }

    public boolean ifCyclicGraph(int node,
                                 int parent,ArrayList<Boolean> visited) {
        if(node==parent) {
            return false;
        }
        if(visited.get(node)) {
            return true;
        }
        visited.set(node,true);
        if(connectionsPerNode.get(node)!=null) {
            for (int i = 0; i < connectionsPerNode.get(node).size();i++) {
                if(ifCyclicGraph(connectionsPerNode.get(node).get(i),node,visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}









































