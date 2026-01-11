import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static boolean visitNode[];
    static boolean visitTube[];
    static List<Integer> tube[];
    static List<Integer> node[];

    static int solve(int n, int k, int m) {
        int ans = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});
        visitNode[1] = true;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            if (cur[0] == n) {
                ans = cur[1];
                break;
            }
            for (int i : node[cur[0]]) {
                if (!visitTube[i]) {
                    visitTube[i] = true;
                    for (int j : tube[i]) {
                        if (!visitNode[j]) {
                            q.add(new int[]{j, cur[1] + 1});
                            visitNode[j] = true;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);

        tube = new ArrayList[m];
        node = new ArrayList[n + 1];
        visitTube = new boolean[m];
        visitNode = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            tube[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int num[] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < k; j++) {
                tube[i].add(num[j]);
                node[num[j]].add(i);
            }
        }
        int ans = solve(n, k, m);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
