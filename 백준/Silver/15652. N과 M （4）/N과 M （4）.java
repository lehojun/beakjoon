import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int last) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(seq[i]);
            }
            sb.append('\n');
            return;
        }
        for (int x = last; x <= N; x++) {
            seq[depth] = x;
            dfs(depth + 1, x); 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[M];
        dfs(0, 1);
        System.out.print(sb.toString());
    }
}