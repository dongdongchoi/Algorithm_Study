import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 게임횟수
        int b = Integer.parseInt(st.nextToken()); // 이긴게임
        
        if (a == 0 || a == b) {
            System.out.println(-1);
            return;
        }        
        
        int current = (int) ((double) b * 100 / a);
        
        int left = 0;
        int right = 1000000000;
        int answer = -1;//애초에 승률이 1보다 크면 더이상 오를게 없기에 초기 설정값을 -1로 책정
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int newWin = (int) (((double) (b + mid) * 100) / (a + mid));
            
            if (newWin > current) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
}
