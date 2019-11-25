import java.math.BigDecimal;


public class TesteBigDecimal implements Comparable<BigDecimal>{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal saldo = new BigDecimal(1);
		saldo.compareTo(new BigDecimal(args[0])){
			public int compareTo(Object obj){
				
				
			}
		};

	}

	@Override
	public int compareTo(BigDecimal arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
