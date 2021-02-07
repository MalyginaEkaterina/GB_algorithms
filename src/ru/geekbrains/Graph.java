package ru.geekbrains;

import java.util.Arrays;

public class Graph {
    private class Vertex {
        char label;
        boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }

        @Override
        public String toString() {
            return String.format("V=%c", label);
        }
    }

    private final int MAX_VERTICES = 16;
    private Vertex[] vertexList;
    private int[][] adjacencyMatrix;
    private int currentSize;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjacencyMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        currentSize = 0;
    }

    public void addVertex(char label) {
        vertexList[currentSize++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1; // change 1 to weight for weight
        adjacencyMatrix[end][start] = 1; // delete this for direction
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v] + " ");
    }

    private int getUnvisitedVertex(int current) {
        for (int i = 0; i < currentSize; i++) {
            if (adjacencyMatrix[current][i] == 1 &&
                    !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void depthTraverse() {
        Stack stack = new Stack(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    public void widthTraverse() {
        Queue queue = new Queue(MAX_VERTICES);
        vertexList[0].wasVisited = true;
        queue.insert(0);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            displayVertex(current);
            int next;
            while ((next = getUnvisitedVertex(current)) != -1) {
                vertexList[next].wasVisited = true;
                queue.insert(next);
            }
        }
        resetFlags();
    }

    private void resetFlags() {
        for (int i = 0; i < currentSize; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void shortestPath(int from, int to) {
        Queue queue = new Queue(MAX_VERTICES);
        int[] vertexDist = new int[currentSize];
        vertexList[from].wasVisited = true;
        queue.insert(from);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            int next;
            while ((next = getUnvisitedVertex(current)) != -1) {
                vertexList[next].wasVisited = true;
                vertexDist[next] = vertexDist[current] + 1;
                if (next != to) {
                    queue.insert(next);
                } else {
                    Stack result = new Stack(currentSize);
                    result.push(next);
                    result.push(current);
                    int d = vertexDist[current];
                    for (int i = 0; i < d; i++) {
                        for (int j = 0; j < currentSize; j++) {
                            if (adjacencyMatrix[j][current] == 1 && vertexDist[j] == (vertexDist[current] - 1)) {
                                result.push(j);
                                current = j;
                                break;
                            }
                        }
                    }
                    while (!result.isEmpty()) {
                        displayVertex(result.pop());
                    }
                    resetFlags();
                    return;
                }
            }
        }
        resetFlags();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('a');
        g.addVertex('b');
        g.addVertex('c');
        g.addVertex('d');
        g.addVertex('e');
        g.addVertex('f');
        g.addVertex('g');
        g.addVertex('h');
        g.addVertex('i');
        g.addVertex('j');
        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(2, 5);
        g.addEdge(0, 3);
        g.addEdge(3, 5);
        g.addEdge(5, 8);
        g.addEdge(8, 9);
        g.addEdge(4, 9);
        g.addEdge(4, 6);
        g.addEdge(4, 7);
        //g.depthTraverse();
        //System.out.println();
        //g.widthTraverse();
        g.shortestPath(0, 9);
        System.out.println();
        g.shortestPath(0, 8);
        System.out.println();
        g.shortestPath(5, 7);
        System.out.println();
        g.shortestPath(0, 1);
    }
}
