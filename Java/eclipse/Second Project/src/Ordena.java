
class Ordena
{
    public static void main( String args [ ] )
    {
	int [ ] vetor = { 30, 20, 40, 10, 50 };
	
	for ( int i = 0; i < vetor.length; i++ ){
	    for ( int j = i; j < vetor.length; j++ ){
			if ( vetor[ i ] > vetor[ j ] )
			    {
				// inverte v[i] e v[j]
				int k = vetor[ i ];
				vetor[ i ] = vetor[ j ];
				vetor[ j ] = k;
			}
	    }
	}
	for ( int i = 0; i < vetor.length; i++ )
	    System.out.print( vetor[ i ] + " " );
		System.out.println( );
    }
}
