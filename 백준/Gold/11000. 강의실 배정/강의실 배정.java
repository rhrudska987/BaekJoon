import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        Lecture[] lectures = new Lecture[N];
        for (int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures, (l1, l2) -> l1.s == l2.s ? l1.t - l2.t : l1.s - l2.s);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].t);
        
        for (int i=1; i<N; i++){
            if(pq.peek() <= lectures[i].s)
                pq.poll();
            pq.offer(lectures[i].t);
        }
        System.out.println(pq.size());
    }

    static class Lecture {
        int s, t;

        public Lecture(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

}