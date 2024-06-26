import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int V;
    static int line[][];
    static int checkDFS[];
    static int check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        line = new int[N+1][N+1];
        check = new int[N+1];
        check[V] = 1;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            line[start][end] = line[end][start] = 1;
        }

        //DFS
        System.out.print(V + " ");
        int end = 0;
        for(int i=1; i<=N; i++){
            if(line[V][i] == 1){
                end = i;
                DFS(V, end);
                continue;
            }
        }
        System.out.println();

        //BFS
        System.out.print(V + " ");
        checkDFS = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        checkDFS[V] = 1;
        while(queue.size() != 0){
            for(int i=1; i<=N; i++){
                int start = queue.peek();
                if(line[start][i] == 1 && checkDFS[i] != 1){
                    System.out.print(i + " ");
                    checkDFS[i] = 1;
                    queue.add(i);
                }
            }
            queue.poll();
        }
    }

    static void DFS(int start, int end){
        if(start == V && check[end] == 1)
            return;
        if(start != V && check[end] == 1 || end == 0)
            return;
        check[end] = 1;
        System.out.print(end + " ");
        for(int i=1; i<=N; i++){
            if(line[end][i] == 1 && check[i] == 0){
                DFS(end, i);
            }
        }
    }
}