/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.*;

public class dijkstra {
    private static int getMinDistanceVertex(boolean[] visited, int[] distance) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }

        return minDistanceVertex;
    }
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = getMinDistanceVertex(visited, distance);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance, source);
    }

    private static void printSolution(int[] distance, int source) {
        System.out.println("Khoảng cách ngắn nhất từ đỉnh " + source + " đến các đỉnh khác:");
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Đỉnh " + i + " : " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng đỉnh: ");
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Nhập ma trận kề của đồ thị:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Nhập đỉnh nguồn: ");
        int source = scanner.nextInt();
        dijkstra(graph, source);
    }
}
