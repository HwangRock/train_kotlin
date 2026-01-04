import java.io.*;
import java.util.*;

public class Main {

    static int solve(int n, int num[]) {
        int ans = 0;

        int sum[] = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + num[i - 1];
        }
        int bee1 = 0;
        int bee2 = 0;
        int honey = 0;
        int maxi = 0;
        int cur = 0;

        bee1 = 0;
        honey = n - 1;
        maxi = 0;
        for (int i = 1; i < n - 1; i++) {
            cur = sum[honey + 1] - sum[bee1] - num[bee1] - num[i];
            cur = cur + (sum[honey + 1] - sum[i] - num[i]);
            maxi = Math.max(maxi, cur);
        }
        ans = Math.max(ans, maxi);

        bee1 = n - 1;
        honey = 0;
        maxi = 0;
        for (int i = 1; i < n - 1; i++) {
            cur = sum[bee1 + 1] - sum[honey] - num[bee1] - num[i];
            cur = cur + (sum[i + 1] - sum[honey] - num[i]);
            maxi = Math.max(maxi, cur);
        }
        ans = Math.max(ans, maxi);

        bee1 = 0;
        bee2 = n - 1;
        maxi = 0;
        for (int i = 1; i < n - 1; i++) {
            cur = sum[i + 1] - sum[bee1] - num[bee1];
            cur = cur + (sum[bee2 + 1] - sum[i] - num[bee2]);
            maxi = Math.max(maxi, cur);
        }
        ans = Math.max(ans, maxi);

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
