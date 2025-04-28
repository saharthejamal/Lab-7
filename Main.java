import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of vertices
        List<String> vertices = Arrays.asList(
            "Liberal Arts",
            "Student Services",
            "Health Careers & Sciences",
            "Health Technologies Center",
            "Recreation Center",
            "Technology Learning Center",
            "Business & Technology",
            "Theatre"
        );

        // Create a list of edges
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1), // Liberal Arts -> Student Services
            new Edge(1, 2), // Student Services -> Health Careers & Sciences
            new Edge(2, 3), // Health Careers & Sciences -> Health Technologies Center
            new Edge(1, 4), // Student Services -> Recreation Center
            new Edge(1, 5), // Student Services -> Technology Learning Center
            new Edge(5, 6), // Technology Learning Center -> Business & Technology
            new Edge(6, 7)  // Business & Technology -> Theatre
        );

        // Create the graph
        UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

        // Set starting vertex to Business & Technology (index 6)
        UnweightedGraph<String>.SearchTree tree = graph.bfs(vertices.indexOf("Business & Technology"));

        // Print paths
        System.out.println("Path from Business & Technology to Health Technologies Center:");
        tree.printPath(vertices.indexOf("Health Technologies Center"));
        System.out.println();

        System.out.println("\nPath from Business & Technology to Student Services:");
        tree.printPath(vertices.indexOf("Student Services"));
        System.out.println();

        System.out.println("\nPath from Business & Technology to Recreation Center:");
        tree.printPath(vertices.indexOf("Recreation Center"));
        System.out.println();

        // Print the entire tree
        System.out.println("\nThe BFS tree is:");
        tree.printTree();
    }
}