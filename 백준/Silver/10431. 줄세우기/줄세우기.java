import java.io.*;
import java.util.*;

public class Main {

    static int[] solve(int n, int num[][]) {
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int cur[] = new int[20];
            int seq = 0;

            for (int j = 0; j < 20; j++) {
                int nn = num[i][j];
                int bg = -1;

                for (int k = 0; k < j; k++) {
                    if (bg == -1 && cur[k] > nn) {
                        bg = k;
                        break;
                    }
                }
                if (bg == -1) {
                    cur[j] = nn;
                } else {
                    for (int k = j - 1; k >= bg; k--) {
                        seq++;
                        cur[k + 1] = cur[k];
                    }
                    cur[bg] = nn;
                }
            }
            ans[i] = seq;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num[][] = new int[n][20];
        int id[] = new int[n];
        for (int i = 0; i < n; i++) {
            String s[] = br.readLine().split(" ");
            id[i] = Integer.parseInt(s[0]);
            for (int j = 1; j <= 20; j++) {
                num[i][j - 1] = Integer.parseInt(s[j]);
            }
        }
        int ans[] = solve(n, num);
        for (int i = 0; i < n; i++) {
            bw.write(id[i] + " " + ans[i] + "\n");
        }
        bw.flush();
    }
}
