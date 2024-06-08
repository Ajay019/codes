import java.util.*;

class Edge {
        int destination;
        int weight;
    
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

public class GraphArrayList{
        int v;
        private ArrayList<Edge>[] edges;

    
    public GraphArrayList(int v) {
        this.v = v;
        edges = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        edges[source].add(new Edge(destination, weight));
        edges[destination].add(new Edge(source, weight));
    }

    public ArrayList<Edge>[] getEdges() {
        return edges;
    }

    public static void main(String[] args) {
        int vertices = 5;
        GraphArrayList graph = new GraphArrayList(vertices);

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 15);
        graph.addEdge(1, 3, 20);
        graph.addEdge(2, 3, 25);
        graph.addEdge(3, 4, 30);

        ArrayList<Edge>[] edges = graph.getEdges();
        for (int i = 0; i < edges.length; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge edge : edges[i]) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}


