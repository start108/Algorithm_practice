package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 1. 아이디어 : 시작점에 연결된 Vertex 찾기
 * - 2중 for => 값 1 && 방문 X => BFS
 * - BFS 돌면서 그림 개수 + 1, 최대값을 갱신
 * 
 * 2. 시간복잡도
 * - BFS : O(V+E)
 * - V : 500 * 500
 * - E : 4 * 500 * 500
 * - V + E : 5 * 250000 = 100만 
 * 
 * 3. 자료구조
 * - 그래프 전체 지도 : int[][]
 * - 방문 : bool[][]
 * - Queue(BFS)
 * 
 * */

public class Bfs_1926 {

	static int n, m;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() ); // 열
		m = Integer.parseInt( st.nextToken() ); // 행

		map = new int[n][m];
		
		for ( int i = 0; i < n; i++ ) {
			st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < m; j++ ) {
				map[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
		
		check = new boolean[n][m];
		int cnt = 0;
		int max = 0;
		
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m; j++ ) {
				if ( map[i][j] == 1 && !check[i][j] ) {
					max = Math.max( max, bfs(j, i) );
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	static int bfs( int x, int y ) {
		
		Queue<int[]> q = new LinkedList<>();

		q.add( new int[]{x, y} );
		check[y][x] = true;
		int size = 1;
		
		while( !q.isEmpty() ) {
			
			int[] p = q.poll();
			int px = p[0];
			int py = p[1];
			
			for ( int k = 0; k < 4; k++ ) {
				
				int nx = px + dx[k];
				int ny = py + dx[k];
				
				if ( nx < 0 || ny < 0 || nx > m-1 || ny > n-1 ) continue;
				if ( map[ny][nx] == 1 ) continue;
				
				if ( map[ny][nx] == 1 ) {
					size++;
					check[ny][nx] = true;
					q.add(new int[] {nx, ny} );
				}
			}
		}
		
		return size;
	}
}