import java.util.GregorianCalendar;

public class PrePago extends Assinante {

    private int numRecargas;
    private float creditos;
    private Recarga[] recargas;
    
    public PrePago(long cpf, String nome,int numero) {
    	 super(cpf, nome, numero);
         this.numRecargas = 0;
         this.creditos = 0.0f;
         this.recargas = new Recarga[5];
   }
   
   public float fazerChamada(GregorianCalendar data, int duracao) {
	if (numChamadas < chamadas.length) {
		if (creditos >= 1.45*duracao) {
			Chamada novaChamada = new Chamada(data, duracao);
    		chamadas[numChamadas] = novaChamada;
    		
    		numChamadas++;
    		
    		float creditoGasto = (float) (duracao*1.45);
    		
    		creditos = creditos - creditoGasto;
    		
		}
		else {
			
		 System.out.println("Impossivel relizar chamada");
		}
	}
	return duracao;
	
}

   public void recarregar(GregorianCalendar data, float valor) {
    	if (numRecargas < recargas.length) {
            
    	 Recarga recarga = new Recarga(data, valor);
    		recargas[numRecargas] = recarga;
            numRecargas++;
            creditos += valor;
           
            System.out.println("Recarga registrada com sucesso");
        }
    	else {
            System.out.println("Não é possível realizar mais recargas, limite alcançado.");
    	}
    }
 

  
