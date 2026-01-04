import java.io.*;
import java.util.*;

public class Main {

    static int solve(int n, int num[]) {
        int ans = 0;

        if (n == 1) {
            return 1;
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        int l = 0, r = 1;
        m.merge(num[l], 1, Integer::sum);
        while (r < n) {
            m.merge(num[r], 1, Integer::sum);
            while (m.size() == 3) {
                m.put(num[l], m.get(num[l]) - 1);
                if (m.get(num[l]) == 0) {
                    m.remove(num[l]);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num[] = new int[n];
        String s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        bw.write(String.valueOf(solve(n, num)));
        bw.flush();
    }
}
