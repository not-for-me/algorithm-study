import java.io.*;
import java.util.*;

/**
 *
 **/
public class BFS {
    private Enum VertexStatusEnum {
        WHITE, GREY, BLACK
    }

    private class Vertex {
        private int id;
        private VertexStatusEnum status;
        private int distance;
        private Vertex predecessor;

        public Vertex(int id) {
            this.id = id;
            this.status = VertexStatusEnum.WHITE;
            this.distance = -1;
            this.predecessor = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        
        public int getDistance() {
            return distance;
        }
        
        public void setDistance(int distance) {
            this.distance = distance;
        }
        
        public Vertex getVertex() {
            return predecessor;
        }
        
        public void setVertex(Vertext predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() != obj.getClass())
                return false;

            Vertex other = (Vertext) obj;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    public static void main(String[] args) {
        new BFS().solve();
    }

    private void solve() {
    	Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while ( cases-- ) {
            final int[] params = sc.nextLine().split(" ");
            final int vertexCnt = params[0];
            final int edgeCnt = params[1];

            // 1. Create Vertex Objects.
            int vertexId = 0;
            List<Vertex> vertexes = new ArrayList<>();
            while ( vertexId < vertexCnt ) {
                vertexes.add( vertexId++, new Vertex(vertexId) );
            }

            // 2. Create a set for store adjacent vertexes of a specific vertex.
            List<Set<Vertex>> vertexList = new ArrayList<>();
            int vertexPos = 0;
            while (vertexPos < vertexCnt) {
                vertexList.add(vertexPos++, new HashSet<Vertex>());
            }

            // 3. Read and store edge information.
            int inputEdgeNum = 0;
            while ( inputEdgeNum++ < edgeCnt ) {
                final int[] edgeInfo = sc.nextLine().split(" ");
                final int fromVertex = edgeInfo[0];
                final int toVertex = edgeInfo[1];
                vertexList.get(fromVertex).add(vertexes.get(toVertex));
                vertexList.get(toVertex).add(vertexes.get(fromVertext));
            }

            // 4. Read Source vertex.
            final int sourceVertexId = sc.nextInt();

            // 5. Explore all vertexes with BFS.
            Queue<Vertex> queue = new LinkedList<>();
            vertexPos = 0;
            queue.add(vertexList.get(vertexPos));

            while ( vertexPos < vertexCnt ) {
                Vertex vertex = queue.poll();
                Set<Vertex> connectedVertexes = vertexList.get(vertex.getId());
                if ( connectedVertexes.size() > 0 ) {
                    for (Vertex vertex : connectedVertexes. )
                }

                vertexPos++;
            }
        }
    }
}