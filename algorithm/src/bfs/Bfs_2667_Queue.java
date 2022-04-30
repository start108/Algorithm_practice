package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs_2667_Queue {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> homeCnt; // 각 단지 내 집의 수
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		n = Integer.parseInt( br.readLine() );

		map = new int[ n + 1 ][ n + 1 ];
		visited = new boolean[ n + 1 ][ n + 1 ];
		
		for ( int i = 0; i < n; i++ ) {
			
			String str = br.readLine();
			
			for ( int j = 0; j < n; j++ ) {
				map[i][j] = str.charAt(j) - '0'; // 띄어쓰기 없음 > chartAt()
			}
		}
		
		int areaCnt = 0; // 총 단지수
		homeCnt = new ArrayList<>();
		
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < n; j++ ) {
				if ( map[i][j] == 1 && !visited[i][j] ) {
					areaCnt++;
					bfs( i, j );			
				}
			}
		}
		
		System.out.println( areaCnt );
		Collections.sort( homeCnt );
		
		for ( int i = 0; i < homeCnt.size(); i++ ) {
			System.out.println( homeCnt.get(i) );
		}
	}
	
	static void bfs( int i, int j ) {
		
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		
		q.add( new int[] {i, j} );
		visited[i][j] = true;
		
		while( !q.isEmpty() ) {
			
			int[] node = q.poll();
			int px = node[0];
			int py = node[1];
			cnt++;
			for ( int k = 0; k < 4; k++ ) {
				
				int nx = px + dx[k];
				int ny = py + dy[k];
				
				if ( nx < n && ny < n && nx >= 0 && ny >= 0 ) {
					if ( map[nx][ny] == 1 && !visited[nx][ny] ) {
						visited[nx][ny] = true;
						q.add( new int[] {nx, ny} );
					}
				}
			}
		}
		
		homeCnt.add( cnt );
	}
}