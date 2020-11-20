package trabalho_oo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Aula extends Compromisso {

    private String nomeDaDisciplina;
    private String tipo;

    public Aula(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String nomeDaDisciplina, String tipo) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao);
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tipo = tipo;
        this.setAdiavel(false);
        this.setFatorMultiplicador(2);
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
        imprimeDataHora(this.getData(), this.getHora());
        System.out.println("Prioridade: " + this.getGrauPrioridade());
        System.out.println("\n");

    }

}
