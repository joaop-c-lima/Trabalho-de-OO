package trabalho_oo;
import java.util.Calendar;

public class Reuniao extends Compromisso {

    private String assunto;

    public Reuniao(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String assunto, boolean adiavel) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao, 5);
        this.assunto = assunto;
        this.setAdiavel(adiavel);

        if (this.isAdiavel()) {
            this.setFatorMultiplicador(4);
        } else {
            this.setFatorMultiplicador(5);
        }
        this.getFim().add(Calendar.MINUTE, duracao);

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
        System.out.println(this.getIdentificador() + ": " + getAssunto());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getInicio().getTime());
        System.out.printf("Fim: ");
        imprimeDataHora(this.getFim().getTime());
        System.out.println("Prioridade: " + this.getGrauPrioridade());
        System.out.println("Assunto: " + this.getAssunto());
        System.out.println("\n");

    }
    
    @Override
    public String getDescricao(){
        return "Reunião";
    }
    
    @Override
    public String getDadosEspecificos(){
        return this.assunto;
    }

}
