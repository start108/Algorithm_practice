package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 1. 아이디어 : 시작점을 기준으로 Vertex 찾기
 * - 2중 for문을 돌면서 방문 X => BFS
 * 
 * 2. 자료구조
 * - 그래프 : int[][]
 * - 방문여부 : boolean[1001]
 * - Queue(BFS)
 * 
 * */
public class Bfs_1260 {

	static int n, m, v;
	static int[][] map;
	static boolean[] visited = new boolean[ 1001 ];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer( br.readLine(), " " );
	
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
		v = Integer.parseInt( st.nextToken() );
		
		map = new int[ n + 1 ][ n + 1 ];
		visited = new boolean[ n + 1 ];
		
		for ( int i = 0; i < n + 1; i++ ) {
			Arrays.fill( map[i], 0 ); // 배열 초기화 
		}
		
		Arrays.fill( visited, false );
		
		for ( int j = 0; j < m; j++ ) {

			st = new StringTokenizer( br.readLine(), " " );
			
			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );
			
			map[x][y] = 1;
			map[y][x] = 1;
		}

		bfs( v );
	}

	private static void bfs( int vertex ) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add( vertex );
		visited[ vertex ] = true;

		while( !q.isEmpty() ) {
			
			int tmp = q.poll();
			
			System.out.print(tmp + " ");
			
			for ( int k = 0; k <= n; k++ ) {
				if ( map[tmp][k] == 1 && !visited[k] ) {
					q.add( k );
					visited[ k ] = true;
				}
			}
		}
	}
}