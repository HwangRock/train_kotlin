import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String[] solve(int n, String s[]) {
        String ans[] = new String[n];

        HashSet<Character> set = new HashSet<>();
        List<String[]> command = Arrays.stream(s).
                map(str -> str.split(" ")).collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int sen = -1;
            int chr = -1;

            String cur[] = command.get(i);
            int fin = cur.length;

            // 1번째 글자들만 확인
            boolean done = false;
            for (int j = 0; j < fin; j++) {
                if (!set.contains(Character.toLowerCase(cur[j].charAt(0)))) {
                    set.add(Character.toLowerCase(cur[j].charAt(0)));
                    sen = j;
                    chr = 0;
                    done = true;
                    break;
                }
            }

            // 1번째가 안되면 이외의 글자들도 확인
            boolean able = false;
            if (!done) {
                for (int j = 0; j < fin; j++) {
                    int len = cur[j].length();
                    for (int k = 1; k < len; k++) {
                        if (!set.contains(Character.toLowerCase(cur[j].charAt(k)))) {
                            set.add(Character.toLowerCase(cur[j].charAt(k)));
                            sen = j;
                            chr = k;
                            able = true;
                            break;
                        }
                    }
                    if (able) {
                        break;
                    }
                }
            }

            // 단축키 하이라이트해서 저장
            for (int j = 0; j < fin; j++) {
                if (j > 0) {
                    sb.append(" ");
                }
                int len = cur[j].length();
                for (int k = 0; k < len; k++) {
                    if (sen == j && chr == k) {
                        sb.append("[");
                    }
                    sb.append(cur[j].charAt(k));
                    if (sen == j && chr == k) {
                        sb.append("]");
                    }
                }
            }
            ans[i] = sb.toString();
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        String ans[] = solve(n, str);
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
    }
}
