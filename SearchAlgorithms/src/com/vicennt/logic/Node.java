package com.vicennt.logic;

import java.util.ArrayList;

/**
 *
 * @author vicent
 */
public class Node implements Comparable {

    private int id;
    private ArrayList<Node> neighbours;

    public Node(int id) {
        this.id = id;
        neighbours = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addNeighbour(Node n) {
        neighbours.add(n);
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    @Override
    public int compareTo(Object o) {
        Node arg = (Node) o;
        if (this.id < arg.getId()) {
            return -1;
        } else if (this.id > arg.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String n = "[";
        for(int i = 0; i < neighbours.size(); i++){
            n += "[" + (neighbours.get(i).getId() + 1) + "]"; 
        }
        return "{Node "+ (id + 1) + " Neighbours:" + n + "}";
    }
    
    

}
