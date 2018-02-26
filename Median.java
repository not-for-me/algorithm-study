import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    private static final int remnant = 20090711;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pCount = Integer.parseInt(br.readLine());

        while (pCount-- > 0) {
            String[] splitted = br.readLine().split(" ");
            int arrCount = Integer.parseInt(splitted[0]);
            int a = Integer.parseInt(splitted[1]);
            int b = Integer.parseInt(splitted[2]);

            final int a0 = 1983;
            final int a1 = (int) (a0 * (long) a + b) % remnant;

            if (arrCount == 1) {
                System.out.println(a0);
                return;
            }

            if (arrCount == 2) {
                System.out.println(a0 <= a1 ? a0 : a1);
                return;
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            long summed = 0;

            // first
            summed += a0;

            // second
            if (a0 < a1) {
                maxHeap.add(a0);
                minHeap.add(a1);
            } else {
                maxHeap.add(a1);
                minHeap.add(a0);
            }
            summed += maxHeap.peek();

            int prev = a1;
            for (int i = 2; i < arrCount; i++) {
                int culVal = (int) (prev * (long) a + b) % remnant;

                if ((i + 1) % 2 == 0) { // before odd
                    if (culVal <= maxHeap.peek()) {
                        maxHeap.add(culVal);
                        minHeap.add(maxHeap.poll());
                    } else {
                        minHeap.add(culVal);
                    }
                } else { // before even
                    if (culVal <= minHeap.peek()) {
                        maxHeap.add(culVal);
                    } else if (minHeap.peek() < culVal) {
                        minHeap.add(culVal);
                        maxHeap.add(minHeap.poll());
                    }
                }
                int median = maxHeap.peek();
                summed += median;
                prev = culVal;
            }

            System.out.println((int) (summed % remnant));
        }
    }
}
