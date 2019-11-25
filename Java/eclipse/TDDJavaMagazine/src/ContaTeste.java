import java.math.BigDecimal;

import junit.framework.TestCase;

  public class ContaTeste extends TestCase {  
    
      private Conta a1;  
    
      public ContaTeste(String arg0) {  
          super(arg0);  
      }   
     
      protected void setUp() {   
          a1 = new Conta("101-1001");   
          a1.setTipo("Corrente");   
          a1.setSaldo(new BigDecimal("100.25"));   
      }  
     
      public void testaGetters() {   
          assertTrue(!a1.equals(null));    
          BigDecimal  saldo  = new BigDecimal("100.25");   
          assertEquals(a1.getId(), "101-1001");   
          assertEquals(a1.getTipo(), "Corrente");   
          assertEquals(a1.getSaldo(), saldo);   
          a1.setId("101-1002");   
          assertEquals(a1.getId(), "101-1002");   
      }   
     
      public void testaDeposito() {   
          BigDecimal saldo = new BigDecimal("150.50");   
          assertEquals(a1.depositar(new BigDecimal("50.25")), saldo);  
      }  
    
      public void testaSaque() {   
          BigDecimal saldo = new BigDecimal("70.01");   
          try {   
              assertEquals(a1.sacar(new BigDecimal("30.24")), saldo);   
          } catch (SaldoInsuficienteException ex) {   
              ex.printStackTrace();   
          }   
          try {   
              // muito saldo   
              a1.sacar(new BigDecimal("10000.00"));   
              fail("sacar não casou uma excessão quando deveria");   
          }   
          catch (SaldoInsuficienteException ex) { }   
      }  
     
  }  
