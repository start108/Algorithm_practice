package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bfs_2667_PriorityQueue {

	static int n;
	static int map[][];
	static boolean visited[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static PriorityQueue<Integer> pq;
	
	static void inputProcessing() throws IOException {/////sadasdas
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
		n = Integer.parseInt( br.readLine() );
		
		map = new int[ n + 1 ][ n + 1];
		visited = new boolean[ n + 1 ][ n + 1];
		
		pq = new PriorityQueue<>();
		
		for ( int i = 0; i < n; i++ ) {
			
			String str = br.readLine();
			
			for ( int j = 0; j < n; j++ ) {
				map[i][j] = str.charAt(j) - '0'; // 띄어쓰기 없음
			}
		}
	}
	
	static void outputProcessing() {
		
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < n; j++ ) {
				if ( map[i][j] == 1 && !visited[i][j] ) {
					bfs( i, j );
				}
			}
		}
		
		System.out.println( pq.size() ); // 단지 수 출력
		
		while( !pq.isEmpty() ) { // 오름차순으로 출력
			System.out.println( pq.poll() );
		}
	}
	
	static void bfs( int x, int y ) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer( new int[] {x, y} );
		
		int cnt = 0;
		
		while( !q.isEmpty() ) {
			
			int px = q.peek()[0];
            int py = q.peek()[1];
            q.poll();
	
            if( px < 0 || py < 0 || px >= n || py >= n ) continue; // map 범위 초과 체크

            if( map[px][py] == 0 ) continue;
 
            if( visited[px][py] ) continue; // 방문 여부 체크

            visited[px][py] = true;
            
            q.offer( new int[] {px+1, py} );
            q.offer( new int[] {px-1, py} );
            q.offer( new int[] {px, py+1} );
            q.offer( new int[] {px, py-1} );
            
            cnt++;
		}
		
		pq.offer( cnt ); // 단지 수 삽입
	}
	
	public static void main(String[] args) throws IOException {
		
		inputProcessing();
		
		outputProcessing();
	}
}
