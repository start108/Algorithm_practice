package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs_2606 {

	static int n, m;
	static int[][] map;
	static boolean[] visited = new boolean[ 101 ];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		n = Integer.parseInt( br.readLine() ); // 컴퓨터의 수 
		m = Integer.parseInt( br.readLine() ); // 컴퓨터 간 간선 수
		
		map = new int[ n + 1 ][ n + 1 ];
		visited = new boolean [ n + 1 ];
		
		for ( int i = 0; i < n; i++ ) {
			Arrays.fill( map[i], 0 ); // 배열 초기화 
		}
		
		Arrays.fill( visited, false );
		
		for ( int j = 0; j < m; j++ ) {
			
			StringTokenizer st = new StringTokenizer( br.readLine() );
			
			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );
			
			// ( 1, 2 ) = ( 2, 1 )
			map[x][y] = 1;
			map[y][x] = 1;
			
		}
		
		bfs();
	}
	
	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add( 1 );
		visited[ 1 ] = true;
		
		int answer = 0;
		
		while( !q.isEmpty() ) {
			
			int tmp = q.poll(); // 노드를 하나 꺼낸다.
			
			for ( int k = 0; k <= n; k++ ) {
				if ( map[tmp][k] == 1 && !visited[k] ) {
					q.add( k );
					visited[ k ] = true;
					answer++;
				}
			}
		}
		
		System.out.println( answer );
	}
}
