package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_15649 {

	static int n, m;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	private static void recursion( int depth ) {
		
		if ( depth == m ) {
			for ( int value : arr ) {
				sb.append( value ).append( " " );
			}
			sb.append( "\n" );
			return;
		}
		
		for ( int i = 0; i < n; i++ ) {
			if ( !visited[i] ) {
				visited[i] = true;
				arr[ depth ] = i + 1;
				recursion( depth + 1 );
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st = new StringTokenizer( br.readLine() );
		
		n = Integer.parseInt( st.nextToken() );
		m = Integer.parseInt( st.nextToken() );
	
		visited = new boolean[ n ];
		arr = new int[ m ];
		
		recursion( 0 );
		
		System.out.println( sb );
	}
}
