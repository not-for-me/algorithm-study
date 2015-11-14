import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem Ref.: https://www.hackerrank.com/challenges/bfsshortreach/copy-from/15190166
 * Data Structure
 *  @List<Vertex> vertexes: Total vertex list
 *  @Map<Integer, Set<Vertex>> vertexMap: Adjacency information of each vertex
 **/
public class BFS {
    public static void main(String[] args) {
        new BFS().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        while (cases-- > 0) {
            final String[] params = sc.nextLine().split(" ");
            final int vertexCnt = Integer.parseInt(params[0]);
            final int edgeCnt = Integer.parseInt(params[1]);

            // 1. Create Graph Data Structure with HashMap
            List<Vertex> vertexes = new ArrayList<>();
            Map<Integer, Set<Vertex>> vertexMap = new HashMap<>();

            vertexes.add(new Vertex(0)); // dummy Vertex
            IntStream.range(0, vertexCnt).forEach(id -> {
                vertexes.add(new Vertex(id + 1));
                vertexMap.put(id + 1, new HashSet<>());
            });

            // 2. Read and store edge information.
            IntStream.range(0, edgeCnt).forEach(x -> {
                final String[] edgeInfo = sc.nextLine().split(" ");
                final int fromVertex = Integer.parseInt(edgeInfo[0]);
                final int toVertex = Integer.parseInt(edgeInfo[1]);
                Set<Vertex> connectedSet = vertexMap.get(fromVertex);
                connectedSet.add(vertexes.get(toVertex));
                vertexMap.put(fromVertex, connectedSet);

                connectedSet = vertexMap.get(toVertex);
                connectedSet.add(vertexes.get(fromVertex));
                vertexMap.put(toVertex, connectedSet);
            });

            // 3. Read Source vertex and Explore all vertexes with BFS.
            final int sourceVertexId = Integer.parseInt(sc.nextLine());
            Vertex sourceVertex = vertexes.get(sourceVertexId);
            sourceVertex.setStatus(VertexStatusEnum.GREY);
            sourceVertex.setDistance(0);
            sourceVertex.setPredecessor(null);

            Queue<Vertex> queue = new LinkedList<>();
            queue.add(sourceVertex);
            while (queue.size() > 0) {
                Vertex vertex = queue.poll();
                Set<Vertex> connectedVertexes = vertexMap.get(vertex.getId());
                connectedVertexes.forEach(v -> {
                    if (v.getStatus() == VertexStatusEnum.WHITE) {
                        v.setStatus(VertexStatusEnum.GREY);
                        v.setDistance(vertex.getDistance() + 6);
                        v.setPredecessor(vertex);
                        queue.add(v);
                    }
                });

                vertex.setStatus(VertexStatusEnum.BLACK);
            }

            for(int i = 1; i <= vertexCnt; i++ ) {
                Vertex vertex =  vertexes.get(i);
                if( vertex.getDistance() != 0) {
                    System.out.print(vertex.getDistance() + " ");
                }
            }
            System.out.println();
        }
    }

    private enum VertexStatusEnum {
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

        public VertexStatusEnum getStatus() {
            return status;
        }

        public void setStatus(VertexStatusEnum status) {
            this.status = status;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Vertex getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(Vertex predecessor) {
            this.predecessor = predecessor;
        }

        @Override
        public boolean equals(Object obj) {
            if (getClass() != obj.getClass())
                return false;

            Vertex other = (Vertex) obj;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }
}