import java.io.Serializable;
import java.math.BigDecimal;

public class Conta implements Serializable { 
     // Os dados da conta
    private String id; 
    private String tipo; 
    private BigDecimal saldo; 
 
    public Conta() { super(); }
 
    public Conta(String contaid) { 
        setId(contaid); 
        setSaldo( new BigDecimal(0.00)); 
    } 
 
    // getters 
    public String getId() { return id; } 
    public String getTipo() { return tipo; } 
    public java.math.BigDecimal getSaldo() { return saldo; } 
 
    // setters 
    public void setId(String id) { this.id = id; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setSaldo(java.math.BigDecimal saldo) { this.saldo = saldo; } 
 
    // business methods 
    public BigDecimal depositar(BigDecimal montante) { 
        setSaldo(getSaldo().add(montante)); 
        return getSaldo();
    } 
 
    public BigDecimal sacar(BigDecimal montante) throws SaldoInsuficienteException { 
        if (new BigDecimal(getSaldo().doubleValue()){
	        	@Override
	        	public int compareTo(BigDecimal valor) {
	        		if(getSaldo().doubleValue() == valor.doubleValue()){
	        			return 0;
	        		}else if (getSaldo().doubleValue() >= valor.doubleValue()){
	        			return 1;
	        		}else{
	        			return -1;
	        		}
	        		
	        	}
        	}.compareTo(montante) == -1)  
            throw new SaldoInsuficienteException ("Saldo insuficiente para sacar"); 
        	setSaldo(getSaldo().subtract(montante) );
        	return getSaldo(); 
    }

 
}
