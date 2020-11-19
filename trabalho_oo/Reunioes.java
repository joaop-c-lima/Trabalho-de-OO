
package trabalho_oo;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Reunioes extends Compromisso{

	private String assunto;
	
	
	public Reunioes(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String assunto, boolean adiavel) {
		super(identificador, grauPrioridade, dataStr, horaStr, duracao);
		this.assunto = assunto;
		this.setAdiavel(adiavel);
		
		
		if(this.isAdiavel())
		{
			this.setFatorMultiplicador(4);
		}
		else
			this.setFatorMultiplicador(5);
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	@Override
	public void imprimeDados() {
		// TODO Auto-generated method stub
		System.out.println(this.getIdentificador()+": "+getAssunto());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getData(), this.getHora());
        System.out.println("Prioridade: "+this.getGrauPrioridade());
        System.out.println("\n");
        
		
		
	}
	
	
	
	
}
