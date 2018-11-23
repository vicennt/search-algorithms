package com.vicennt.logic;

/**
 *
 * @author vicent
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        double[][] incidenceMatrix = createWeightMatrix();
        Node[] graph = createGraph(incidenceMatrix);
        SearchAlgorithms sa = new SearchAlgorithms();
        System.out.println("----- Incidence matrix with weights ----- ");
        for (int i = 0; i < incidenceMatrix.length; i++) {
            for (int j = 0; j < incidenceMatrix.length; j++) {
                System.out.print("[" + incidenceMatrix[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.print(" ");
        System.out.println("------- BFS Algorithm -------");
        Node first = graph[0];
        Node goal = graph[3];
        Node[] resultBFS = sa.BFS(graph, first, goal);
        String path = "";
        for(int i = 0; i < resultBFS.length; i++){
            if(resultBFS[i] == null)
                path += "[null]";   
            else
                path += "[" + (resultBFS[i].getId() + 1) + "]"; 
        }
        System.out.println("Path: "+ path);
    }

    public static Node[] createGraph(double[][] incidenceMatrix) {
        System.out.println("----- Graph -----");
        Node[] graph = new Node[incidenceMatrix.length];
        // Create nodes
        for (int i = 0; i < incidenceMatrix.length; i++) {
            graph[i] = new Node(i);
        }
        // Add neighbours
        for (int i = 0; i < incidenceMatrix.length; i++) {
            for (int j = 0; j < incidenceMatrix.length; j++) {
                if (incidenceMatrix[i][j] > 0) {
                    graph[i].addNeighbour(graph[j]);
                }
            }
            System.out.println(graph[i].toString());
        }
        return graph;
    }
    
    
    public static double[][] createWeightMatrix() {
        double[][] graphIncidenceMatrix = new double[4][4];
        // Node 1
        graphIncidenceMatrix[0][0] = 0;
        graphIncidenceMatrix[0][1] = 3.40;
        graphIncidenceMatrix[0][2] = 3.16;
        graphIncidenceMatrix[0][3] = 0;
        
        // Node 2
        graphIncidenceMatrix[1][0] = 0;
        graphIncidenceMatrix[1][1] = 0;
        graphIncidenceMatrix[1][2] = 2.90;
        graphIncidenceMatrix[1][3] = 1.60;
        
        // Node 3
        graphIncidenceMatrix[2][0] = 3.16;
        graphIncidenceMatrix[2][1] = 0;
        graphIncidenceMatrix[2][2] = 0;
        graphIncidenceMatrix[2][3] = 3.50;
        
        // Node 4
        graphIncidenceMatrix[3][0] = 0;
        graphIncidenceMatrix[3][1] = 0;
        graphIncidenceMatrix[3][2] = 3.16;
        graphIncidenceMatrix[3][3] = 0;
        return graphIncidenceMatrix;
    }

}
