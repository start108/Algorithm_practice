package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_1260 {

	static int[][] dMap = new int[ 1001 ][ 1001 ];
	static int[][] bMap = new int[ 1001 ][ 1001 ];
	static boolean[] dvisited = new boolean[ 10001 ];
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );
		int m = Integer.parseInt( st.nextToken() );
		int v = Integer.parseInt( st.nextToken() );
		
		for ( int i = 0; i < m; i++ ) {
			
			st = new StringTokenizer( br.readLine() );
			int x = Integer.parseInt( st.nextToken() );
			int y = Integer.parseInt( st.nextToken() );
			
			dMap[x][y] = dMap[y][x] = 1;
			bMap[x][y] = bMap[y][x] = 1;
		}
		
		dfs( v );
		System.out.println();
		bfs( v );
	}
	
	private static void dfs ( int node ) {
		
		dvisited[ node ] = true;
		
		System.out.print( node + " " );
		
		for ( int i = 1; i <= n; i++ ) {
			if ( !dvisited[i] && dMap[ node ][ i ] == 1 ) {
				dfs( i );
			}
		}
	}
	
	private static void bfs ( int node ) {
		
		boolean[] bvisited = new boolean[ 10001 ];
		bvisited[ node ] = true;
		
		Queue< Integer > q = new LinkedList< Integer >();
		
		q.offer( node );
		
		while( !q.isEmpty() ) {
			
			int value = q.poll();
			
			System.out.print( value + " " );
			
			for ( int i = 0; i <= n; i++ ) {
				if ( !bvisited[i] && bMap[value][i] == 1 ) {
					q.offer( i );
					bvisited[i] = true;
				}
			}
		}
	}
}
