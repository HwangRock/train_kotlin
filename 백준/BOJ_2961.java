import java.io.*;
import java.util.*;

public class Main {

    static int ans = Integer.MAX_VALUE;

    static void track(int i, int n, int sin[], int ssen[], int gop, int hap, boolean used) {
        if (i == n) {
            if (used) {
                int cur = Math.abs(gop - hap);
                ans = Math.min(ans, cur);
            }
            return;
        }

        track(i + 1, n, sin, ssen, gop * sin[i], hap + ssen[i], true);
        track(i + 1, n, sin, ssen, gop, hap, used);
    }

    static int solve(int n, int sin[], int ssen[]) {

        track(0, n, sin, ssen, 1, 0, false);

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sin[] = new int[n];
        int ssen[] = new int[n];
        for (int i = 0; i < n; i++) {
            String s[] = br.readLine().split(" ");
            sin[i] = Integer.parseInt(s[0]);
            ssen[i] = Integer.parseInt(s[1]);
        }
        bw.write(String.valueOf(solve(n, sin, ssen)));
        bw.flush();
    }
}
