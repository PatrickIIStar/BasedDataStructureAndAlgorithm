package main.java.com.patrick.darastructure.graph;

import java.util.*;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/23 10:17
 * @declaration 邻接矩阵表示图的操作(无向图)
 */
public class MatrixGraph {
    // 顶点集合
    private final List<String> vertexes;

    // 邻接矩阵
    private final int[][] edges;

    // 访问标志，用于遍历
    private final boolean[] isVisited;

    // 边数
    private int numOfEdges;

    /**
     * @param n 顶点数
     * @declaration 构造函数
     */
    public MatrixGraph(int n) {
        vertexes = new ArrayList<>();
        edges = new int[n][n];
        // 初始为false
        isVisited = new boolean[n];
    }

    /**
     * @declaration 获取顶点数
     */
    public int getNumOfVertexes() {
        return vertexes.size();
    }

    public void insertVertex(String vertex) {
        if (vertexes.contains(vertex)) {
            return;
        }
        vertexes.add(vertex);
    }

    /**
     * @param vertex1 顶点A
     * @param vertex2 顶点B
     * @param weight  权值
     * @declaration 加入一条边
     */
    public void insertEdge(String vertex1, String vertex2, int weight) {
        // 自身不能连接自身
        if (vertex1.equals(vertex2)) {
            return;
        }
        int v1 = getIndexByVertex(vertex1);
        int v2 = getIndexByVertex(vertex2);
        // 如果权值为0，说明还未添加该条边，边数+1
        if (edges[v1][v2] == 0) {
            numOfEdges++;
        }
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
    }


    /**
     * @declaration 输出邻接矩阵
     */
    public void showMatrix() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * @declaration 获取边数
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * @declaration 获取某条边的权值
     */
    public int getEdgeWeight(String vertex1, String vertex2) {
        return edges[getIndexByVertex(vertex1)][getIndexByVertex(vertex2)];
    }

    /**
     * @declaration 深度优先搜索(回溯)，起始点为vertex
     * 1、先将起始点输出并标记为已访问
     * 2、将与vertex连接的第一个顶点nextVertex作为起始点进行dfs
     * 3、如果该点被访问，则寻找与vertex相连的且不为nextVertex的顶点
     * 4、将其作为起始点进行dfs
     * 5、如果nextVertex为null，说明一个连通图已经遍历结束
     * 6、最后遍历没有被访问过的点
     */
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


    /**
     * @declaration 广度优先搜索，起始点为vertex,用队列实现
     */
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


    /**
     * @declaration 获取与顶点vertex连接的第一个顶点
     * 在邻接矩阵中vertex行找到第一个不为0的元素
     */
    private String getNeighborVertex(String vertex) {
        int v = getIndexByVertex(vertex);
        for (int i = 0; i < getNumOfVertexes(); i++) {
            if (edges[v][i] > 0) {
                return getVertexByIndex(i);
            }
        }
        return null;
    }


    /**
     * @declaration 找到vertex1行 vertex2列之后第一个不为0的顶点
     */
    private String getNextNeighborVertex(String vertex1, String vertex2) {
        int v1 = getIndexByVertex(vertex1);
        int v2 = getIndexByVertex(vertex2);
        for (int i = v2 + 1; i < getNumOfVertexes(); i++) {
            if (edges[v1][i] > 0) {
                return getVertexByIndex(i);
            }
        }
        return null;
    }

    /**
     * @declaration 找没有被访问的结点进行dfs
     */
    private void dfs() {
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                dfs(vertexes.get(i));
            }
        }
    }


    /**
     * @declaration 找没有被访问的结点进行bfs
     */
    private void bfs() {
        for (int i = 0; i < vertexes.size(); i++) {
            if (!isVisited[i]) {
                bfs(vertexes.get(i));
            }
        }
    }

    /**
     * @declaration 由顶点获取顶点在集合中的下标
     */
    private int getIndexByVertex(String vertex) {
        return vertexes.indexOf(vertex);
    }

    /**
     * @declaration 由顶点的下标获取顶点
     */
    private String getVertexByIndex(int i) {
        return vertexes.get(i);
    }
}
