package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913_S3_������ {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int target = Integer.parseInt(in.readLine());
		
		int map[][] = new int[N][N]; //NxN 2���� �迭 ����
		int targetPos[] = new int[2]; //target ��ġ ���� �迭
		
		//Ž���� ���� delta �迭 ����
		int[] dr = {-1,0,1,0}; //�� �� �� ��
		int[] dc = {0,1,0,-1};
		int dirIdx = 0; //���� ���� �ε���
		
		//������ �迭 ����� ���� ���� ����
		int curR = (int)N/2;
		int curC = (int)N/2;
		int len = 1;
		int cnt = 0;
		int dirChangeCnt = 0;
		
		for(int i = 1;i<=N*N;i++) {
			if(i == target) {
				targetPos[0] = curR+1;
				targetPos[1] = curC+1;
			}
			map[curR][curC] = i;
			
			curR += dr[dirIdx];
			curC += dc[dirIdx];
			cnt++;
			
			if(cnt == len) {
				dirIdx = (dirIdx+1)%4;
				cnt = 0;
				dirChangeCnt++;
			}
			if(dirChangeCnt==2) {
				len++;
				dirChangeCnt=0;
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		
		sb.append(targetPos[0]).append(" ").append(targetPos[1]);
		System.out.println(sb);
	}
	
}
