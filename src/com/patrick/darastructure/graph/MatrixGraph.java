package com.patrick.darastructure.graph;

import java.util.*;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/23 10:17
 * @declaration 邻接矩阵表示图
 */
public class MatrixGraph {
    private final List<String> vertexes;
    private final int[][] edges;
    private final boolean[] isVisited;
    private int numOfEdges;

    public MatrixGraph(int n) {
        vertexes = new ArrayList<>();
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex) {
        if (vertexes.contains(vertex)) {
            return;
        }
        vertexes.add(vertex);
    }

    public void insertEdge(String vertex1, String vertex2, int weight) {
        if (vertex1.equals(vertex2)) {
            return;
        }
        int v1 = getIndexByVertex(vertex1);
        int v2 = getIndexByVertex(vertex2);
        if (edges[v1][v2] == 0) {
            numOfEdges++;
        }
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }

    public void showMatrix() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getEdgeWeight(String vertex1, String vertex2) {
        return edges[vertexes.indexOf(vertex1)][vertexes.indexOf(vertex2)];
    }

    public void dfs(String vertex) {
        isVisited[getIndexByVertex(vertex)] = true;
        System.out.print(vertex + "\t");
        String nextVertex = getNeighborVertex(vertex);
        while (nextVertex != null) {
            if (!isVisited[getIndexByVertex(nextVertex)]) {
                dfs(nextVertex);
            }
            nextVertex = getNextNeighborVertex(vertex, nextVertex);
        }
        dfs();
    }

    public void bfs(String vertex) {
        Queue<String> vertexQueue = new LinkedList<>();
        isVisited[getIndexByVertex(vertex)] = true;
        System.out.print(vertex + "\t");
        vertexQueue.add(vertex);
        while (!vertexQueue.isEmpty()) {
            String headVertex = vertexQueue.remove();
            String nextVertex = getNeighborVertex(headVertex);
            while (nextVertex != null) {
                if (!isVisited[getIndexByVertex(nextVertex)]) {
                    System.out.print(nextVertex + "\t");
                    isVisited[getIndexByVertex(nextVertex)] = true;
                    vertexQueue.add(nextVertex);
                }
                nextVertex = getNextNeighborVertex(headVertex, nextVertex);
            }
        }
        bfs();
    }


    private String getNeighborVertex(String vertex) {
        int v = getIndexByVertex(vertex);
        for (int i = 0; i < vertexes.size(); i++) {
            if (edges[v][i] > 0) {
                return getVertexByIndex(i);
            }
        }
        return null;
    }

    private String getNextNeighborVertex(String vertex1, String vertex2) {
        int v1 = getIndexByVertex(vertex1);
        int v2 = getIndexByVertex(vertex2);
        for (int i = v2 + 1; i < vertexes.size(); i++) {
            if (edges[v1][i] > 0) {
                return getVertexByIndex(i);
            }
        }
        return null;
    }

    private void dfs() {
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                dfs(vertexes.get(i));
            }
        }
    }

    private void bfs() {
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                bfs(vertexes.get(i));
            }
        }
    }

    private int getIndexByVertex(String vertex) {
        return vertexes.indexOf(vertex);
    }

    private String getVertexByIndex(int i) {
        return vertexes.get(i);
    }
}
