package trabalho_oo;
import java.util.Calendar;

/**
 *
 * @author Beatriz
 */
public class Evento extends Compromisso {
    
    private String nome;
    private String local;
    private boolean adiavel;
 
    
    public Evento(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String nome, String local)
    {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao,4);
        this.setFatorMultiplicador(3);
        this.nome = nome;
        this.local = local;
        this.adiavel = false;
            
        //Como a data de fim do evento não é passada nos arquivos de entrada temos
        //que gerá-la automaticamente a partir da data de inicio, em função
        //da duração do evento que é em dias
               
        //Adicionando os dias de duração do evento à data inicial para obter a final
        this.getFim().add(Calendar.DAY_OF_MONTH, duracao);
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    } 
    
    @Override
    public void imprimeDados()
    {
        System.out.printf("%d: %s\n", this.getIdentificador(),this.getNome());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getInicio().getTime());
        System.out.printf("Fim: ");
        imprimeDataHora(this.getFim().getTime());
        System.out.printf("Prioridade: %d\n", this.getGrauPrioridade());
        System.out.printf("Local: %s\n\n", this.getLocal());
        
    }
    
    @Override
    public String getDescricao(){
        return this.nome;
    }
    
    @Override
    public String getDadosEspecificos(){
        return this.local;
    }
}
