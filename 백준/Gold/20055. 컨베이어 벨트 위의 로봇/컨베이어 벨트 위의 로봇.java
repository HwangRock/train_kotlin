import java.io.*;
import java.util.*;

public class Main {

    static int solve(int n, int k, int belt[]) {
        int ans = 0;

        boolean exist[] = new boolean[2 * n];

        while (k > 0) {
            // 컨베이어 벨트 회전
            int tmpNum = 0;
            tmpNum = belt[2 * n - 1];
            for (int i = 2 * n - 1; i >= 1; i--) {
                belt[i] = belt[i - 1];
                exist[i] = exist[i - 1];
                if (i == n-1 && exist[i]) {
                    exist[i] = false;
                }
            }
            belt[0] = tmpNum;
            exist[0]=false;

            //로봇 이동
            for (int i = n - 2; i >= 0; i--) {
                if (!exist[i + 1] && belt[i + 1] > 0 && exist[i]) {
                    exist[i] = false;
                    belt[i + 1]--;
                    exist[i + 1] = true;
                    if (belt[i + 1] == 0) {
                        k--;
                    }
                }
            }
            exist[n-1]=false;

            //로봇 배치
            if (!exist[0] && belt[0] > 0) {
                exist[0] = true;
                belt[0]--;
                if (belt[0] == 0) {
                    k--;
                }
            }
            ans++;
        }

        return ans;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int belt[] = new int[2 * n];
        String inp[] = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(inp[i]);
        }
        bw.write(String.valueOf(solve(n, k, belt)));
        bw.flush();
    }
}
