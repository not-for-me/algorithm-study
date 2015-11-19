import java.util.stream.IntStream;

/**
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * Data Structure
 * int[][] adjacency matrix
 **/
public class Dijkstra {
	public static void main(String... args) {
		Dijkstra mock = new Dijkstra();
		int graph[][] = new int[][] {
		        { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		        { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
		        { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
		        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		        { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
		};
		mock.useDijkstra(9, 0, graph);

		/**
		 * Expected Output
		 * Vertex Distance from Source
		 * 0 0
		 * 1 4
		 * 2 12
		 * 3 19
		 * 4 21
		 * 5 11
		 * 6 9
		 * 7 8
		 * 8 14
		 */
	}

	private void useDijkstra(int vertexNum, int sourceVertex, int[][] graph) {
		// 1. Initialized shortest path set and distance array with INFINITE
		boolean spSet[] = new boolean[vertexNum];
		int distance[] = new int[vertexNum];
		for (int i = 0; i < vertexNum; i++) {
			spSet[i] = false;
			distance[i] = Integer.MAX_VALUE;
		}

		distance[sourceVertex] = 0;
		for(int i = 0; i < vertexNum; i++) {
			int minDistance = Integer.MAX_VALUE;
			int minIndex = -1;
			// 2. Pickup the minimum distance vertex size
			for (int v = 0; v < vertexNum; v++) {
				if (!spSet[v] && distance[v] < minDistance) {
					minDistance = distance[v];
					minIndex = v;
				}
			}
			spSet[minIndex] = true;

			for (int v = 0; v < vertexNum; v++) {
				boolean isNotSelf = v != minIndex;
				boolean isConnected = graph[minIndex][v] != 0;
				boolean islessThanDistance =  distance[minIndex] + graph[minIndex][v] <
						distance[v];
				if ( !spSet[v] && isNotSelf && isConnected && islessThanDistance) {
					distance[v] = distance[minIndex] + graph[minIndex][v];
				}
			}
		}

		IntStream.range(0, vertexNum).forEach(i -> System.out.println(i + " " + distance[i]));
	}
}
