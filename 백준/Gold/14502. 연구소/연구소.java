import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int N;
    static int M;
    static int map[][];
    static Queue<int[]> virus = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    virus.add(new int[]{i, j});
            }

        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int wallCnt){
        if(wallCnt == 3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> virus_clone = new LinkedList<>(virus);
        int[][] map_clone = new int[N][M];
        for (int i=0; i<N; i++){
            map_clone[i] = Arrays.copyOf(map[i], M);
        }

        while(virus_clone.size() > 0){
            int[] arr = virus_clone.poll();
            int y = arr[0];
            int x = arr[1];

            if(x-1 >= 0 && map_clone[y][x-1] == 0){
                map_clone[y][x-1] = 2;
                virus_clone.add(new int[]{y, x-1});
            }
            if(x+1 < M && map_clone[y][x+1] == 0){
                map_clone[y][x+1] = 2;
                virus_clone.add(new int[]{y, x+1});
            }
            if(y-1 >= 0 && map_clone[y-1][x] == 0){
                map_clone[y-1][x] = 2;
                virus_clone.add(new int[]{y-1, x});
            }
            if(y+1 < N && map_clone[y+1][x] == 0){
                map_clone[y+1][x] = 2;
                virus_clone.add(new int[]{y+1, x});
            }
        }
        countVirus(map_clone);
    }

    static void countVirus(int[][] map_clone){
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map_clone[i][j] == 0)
                    cnt++;
            }
        }
        if(cnt > max)
            max = cnt;
    }
}
