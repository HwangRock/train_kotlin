import java.io.*;
import java.util.*;

public class Main {

    static String chanel[];

    final static String kbs1 = "KBS1";
    final static String kbs2 = "KBS2";

    static void changeChanel(int bef, int aft) {
        String tmp = chanel[aft];
        chanel[aft] = chanel[bef];
        chanel[bef] = tmp;
    }

    static String solve(int n) {
        StringBuilder sb = new StringBuilder();

        int target1 = 0;
        int target2 = 0;
        for (int i = 0; i < n; i++) {
            if (chanel[i].equals(kbs1)) {
                target1 = i;
            }
            if (chanel[i].equals(kbs2)) {
                target2 = i;
            }
        }

        int i = 0;
        while (!chanel[0].equals(kbs1)) {
            if (i == target1) {
                sb.append("4");
                if (chanel[i - 1].equals(kbs2)) {
                    target2++;
                }
                changeChanel(i, i - 1);
                i--;
                target1--;
            } else if (i < n - 1 && chanel[i + 1].equals(kbs2)) {
                sb.append("3");
                changeChanel(i, i + 1);
                i++;
                target2--;
            } else if (i == 0 && chanel[i + 1].equals(kbs1)) {
                sb.append("3");
                changeChanel(i, i + 1);
                i++;
                target1--;
            } else {
                sb.append("1");
                i++;
            }
        }

        while (!chanel[1].equals(kbs2)) {
            if (i == target2) {
                sb.append("4");
                changeChanel(i, i - 1);
                i--;
                target2--;
            } else if (i > target2) {
                sb.append("2");
                i--;
            } else if (i == 1 && chanel[i + 1].equals(kbs2)) {
                sb.append("3");
                changeChanel(i, i + 1);
                i++;
                target2--;
            } else {
                sb.append("1");
                i++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        chanel = new String[n];
        for (int i = 0; i < n; i++) {
            chanel[i] = br.readLine();
        }
        bw.write(solve(n));
        bw.flush();
    }
}
