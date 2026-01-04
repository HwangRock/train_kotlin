import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String[] solve(int n, String s[]) {
        String ans[] = new String[2];

        // 문자열의 인덱스 저장 후 길이순서대로 정렬
        HashMap<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(s[i], i);
        }
        String ss[] = Arrays.stream(s)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);

        // 앞에서부터 문장을 뽑고 0~i까지 부분문자열을 map에 키로 넣고 값은 현재 문자열
        // 이미 map에 key가 있는데 현재가 인덱스가 더 빠르면 갱신
        int len = 0;
        HashMap<String, String> sub = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = ss[i];
            StringBuilder sb = new StringBuilder();
            int fin = cur.length();
            for (int j = 0; j < fin; j++) {
                char c = cur.charAt(j);
                sb.append(c);
                if (!sub.containsKey(sb.toString())) {
                    sub.put(sb.toString(), cur);
                } else {
                    int pi = idx.get(sub.get(sb.toString()));
                    int ci = idx.get(cur);
                    if (sb.length() == len) {
                        // ans[0]과 더 빠른 새로운 것 사이의 인덱스 비교
                        int min = Math.min(pi, ci);
                        if (min < idx.get(ans[0])) {
                            if (pi > ci) {
                                ans[0] = cur;
                                ans[1] = sub.get(sb.toString());
                            } else {
                                ans[0] = sub.get(sb.toString());
                                ans[1] = cur;
                            }
                        }
                    } else if (sb.length() > len) {
                        // 새로 나온 것끼리 인덱스 비교 후 길이 갱신
                        len = sb.length();
                        if (pi > ci) {
                            ans[0] = cur;
                            ans[1] = sub.get(sb.toString());
                        } else {
                            ans[0] = sub.get(sb.toString());
                            ans[1] = cur;
                        }
                    }
                    // 현재 문자의 인덱스가 더 빠르다면 갱신해줘야함.
                    if (ci < pi) {
                        sub.put(sb.toString(), cur);
                    }
                }
            }
        }
        if (len == 0) {
            ans[0] = s[0];
            ans[1] = s[1];
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
        bw.write(ans[0] + "\n" + ans[1]);
        bw.flush();
    }
}
