package alg.java.drill.BFS;

/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * Data Structure
 * int[][] adjacency matrix
 **/
public class Dijkstra {
	public static void main(String... args) {
		Dijkstra mock = new Dijkstra();
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		        { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
		        { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
		        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		        { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
		};
		mock.useDijkstra(graph);

		/**
		 * Expected Output
		 * Vertex Distance from Source
		 *      0        0
		 *      1        4
		 *      2       12
		 *      3       19
		 *      4       21
		 *      5       11
		 *      6       9
		 *      7       8
		 *      8       14
		 */
	}

	private void useDijkstra(int[][] graph) {
	}

}
