import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;
    static final int MOD = 1_000_000_007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        size = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        
        long answer = 1;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                answer = (answer * size[i]) % MOD;
            }
        }
        
        System.out.println(answer);
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            } else {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }
    }
}
