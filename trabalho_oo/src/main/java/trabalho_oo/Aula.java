package trabalho_oo;

import java.util.Date;
import java.util.Calendar;

public class Aula extends Compromisso {

    private String nomeDaDisciplina;
    private String tipo;

    public Aula(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String nomeDaDisciplina, String tipo) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao, 3);
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tipo = tipo;
        this.setAdiavel(false);
        this.setFatorMultiplicador(2);
        this.getFim().add(Calendar.MINUTE, duracao);

    }

    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void imprimeDados() {

        System.out.println(this.getIdentificador() + "  Aula de " + getNomeDaDisciplina());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getInicio().getTime());
        System.out.printf("Fim: ");
        imprimeDataHora(this.getFim().getTime());
        System.out.println("Prioridade: " + this.getGrauPrioridade());
        System.out.println("Nível: " + this.getTipo());
        System.out.println("\n");

    }
    
    @Override
    public String getDescricao(){
        return "Aula de " + this.nomeDaDisciplina;
    }
    
    @Override
    public String getDadosEspecificos(){
        return this.tipo;
    }

}
