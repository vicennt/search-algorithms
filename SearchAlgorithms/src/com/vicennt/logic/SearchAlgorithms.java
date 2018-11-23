package com.vicennt.logic;

import java.util.PriorityQueue;

/**
 *
 * @author vicent
 */
public class SearchAlgorithms {

    public Node[] BFS(Node[] graph, Node first, Node goal) {
        int[] state = new int[graph.length];
        double[] distance = new double[graph.length];
        Node[] father = new Node[graph.length];

        for (Node n : graph) {
            state[n.getId()] = 0;
            distance[n.getId()] = 1000;
            father[n.getId()] = null;
        }
        state[first.getId()] = 1;
        distance[first.getId()] = 0;
        father[first.getId()] = null;
        PriorityQueue q = new PriorityQueue();
        q.add(first);
        int count = 0;
        while (!q.isEmpty()) {
            String s = "State: ";
            String d = "Distance: ";
            String f = "Father: ";
            Node node = (Node) q.poll();
            if (node.equals(goal)) {
                return father;
            }
            for (Node neigbour : node.getNeighbours()) {
                if (state[neigbour.getId()] == 0) {
                    state[neigbour.getId()] = 1;
                    distance[neigbour.getId()] = distance[node.getId()] + 1;
                    father[neigbour.getId()] = node;
                    q.add(neigbour);
                }
            }

            for (int i = 0; i < graph.length; i++) {
                s += "[" + state[i] + "]";
                d += "[" + distance[i] + "]";
                if (father[i] != null) {
                    f += "[" + father[i].getId() + "]";
                } else {
                    f += "[null]";
                }

            }

            System.out.println("---- Stats Iteration " + count);
            System.out.println(s);
            System.out.println(d);
            System.out.println(f);
            count++;
        }
        return null;
    }
}
