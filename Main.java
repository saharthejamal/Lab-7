public static void main(String[] args) {
  // Create a list for vertices
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

  // Create a list for edges
  List<Edge> edges = Arrays.asList(
      new Edge(0, 1), // Liberal Arts -> Student Services
      new Edge(1, 2), // Student Services -> Health Careers & Sciences
      new Edge(2, 3), // Health Careers & Sciences -> Health Technologies Center
      new Edge(1, 4), // Student Services -> Recreation Center
      new Edge(1, 5), // Student Services -> Technology Learning Center
      new Edge(5, 6), // Technology Learning Center -> Business & Technology
      new Edge(6, 7), // Business & Technology -> Theatre
      new Edge(5, 7)  // Technology Learning Center -> Theatre (optional based on map; otherwise, remove)
  );

  // Create the graph
  UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

  // Set the starting vertex to Business & Technology
  int startIndex = vertices.indexOf("Business & Technology");
  UnweightedGraph<String>.Tree tree = graph.bfs(startIndex);

  // Print paths
  System.out.println("Path from Business & Technology to Health Technologies Center:");
  tree.printPath(vertices.indexOf("Health Technologies Center"));
  
  System.out.println("\nPath from Business & Technology to Student Services:");
  tree.printPath(vertices.indexOf("Student Services"));
  
  System.out.println("\nPath from Business & Technology to Recreation Center:");
  tree.printPath(vertices.indexOf("Recreation Center"));

  // Print the entire tree
  System.out.println("\nThe BFS tree is:");
  tree.printTree();
}