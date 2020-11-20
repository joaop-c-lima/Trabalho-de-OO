package trabalho_oo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 *
 * @author Beatriz
 */
public class Evento extends Compromisso {

    private String nome;
    private String local;
    private boolean adiavel;
    private Date data_fim;
    private Date hora_fim;

    public Evento(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String nome, String local) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao);
        this.setFatorMultiplicador(3);
        this.nome = nome;
        this.local = local;
        this.adiavel = false;

        //Como a data de fim do evento não é passada nos arquivos de entrada temos
        //que gerá-la automaticamente a partir da data de inicio, em função
        //da duração do evento que é em dias
        //Então pra isso fazemos uso da classe Calendar que possui funções
        //envolvendo aritmética de dias e essa função retorna a data depois
        //de alterada então podemos guardar essa informação no atributo
        //do ohbjeto
        SimpleDateFormat FastFor = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(FastFor.parse(dataStr));
            //Adicionando os dias de duração do evento à data inicial para obter a final
            c.add(Calendar.DATE, duracao);
            this.data_fim = c.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.hora_fim = this.getHora();

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

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Date getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(Date hora_fim) {
        this.hora_fim = hora_fim;
    }

    public void imprimeDados() {
        System.out.printf("%d: %s\n", this.getIdentificador(), this.getNome());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getData(), this.getHora());
        System.out.printf("Fim: ");
        imprimeDataHora(this.getData_fim(), this.getHora_fim());
        System.out.printf("Prioridade: %d\n", this.getGrauPrioridade());
        System.out.printf("Local: %s\n\n", this.getLocal());

    }
}
