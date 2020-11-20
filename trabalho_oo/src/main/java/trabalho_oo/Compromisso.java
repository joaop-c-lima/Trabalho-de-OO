package trabalho_oo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author Beatriz
 */
public abstract class Compromisso {

    private int identificador;
    private int grauPrioridade;
    private int fatorMultiplicador;
    private Date data;
    private Date hora;
    private int duracao;
    private boolean adiavel;
    private boolean mudancaAdiavel = false;

    public abstract void imprimeDados();

    public Compromisso(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao) {
        this.setIdentificador(identificador);
        this.setGrauPrioridade(grauPrioridade);
        this.setData(dataStr);
        this.setHora(horaStr);
        this.setDuracao(duracao);
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        this.grauPrioridade = grauPrioridade;
    }

    public Date getData() {
        return data;
    }

    //As funções pra setar data e hora recebem uma string e transforam em data para armazená-la
    //no atributo do objeto, a data e hora tem seu respectivo formato próprio
    public void setData(String dataStr) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = DateFor.parse(dataStr);
            this.data = data;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(String horaStr) {

        SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm");
        try {
            Date hora = DateFor.parse(horaStr);
            this.hora = hora;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    //fim explicação data/hora

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public boolean isAdiavel() {
        return adiavel;
    }

    public void setAdiavel(boolean adiavel) {

        //Mudando fator multiplicador de acordo com o fato do evento ser
        //adiável ou não
        if (!(adiavel) && this.isAdiavel()) {
            this.setFatorMultiplicador(this.getFatorMultiplicador() + 1);
            this.setMudancaAdiavel(true);

        } else if (adiavel && (this.isAdiavel() == false)) {
            if (houveMudancaAdiavel()) {
                this.setFatorMultiplicador(this.getFatorMultiplicador() - 1);
                this.setMudancaAdiavel(true);
            }

        }

        this.adiavel = adiavel;

    }

    public int getFatorMultiplicador() {
        return fatorMultiplicador;
    }

    public void setFatorMultiplicador(int fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }

    public boolean houveMudancaAdiavel() {
        return mudancaAdiavel;
    }

    public void setMudancaAdiavel(boolean mudancaAdiavel) {
        this.mudancaAdiavel = mudancaAdiavel;
    }

    //Para impressão da data convertemos o objeto do tipo Date em uma string
    //no respectivo formato
    public void imprimeDataHora(Date data, Date hora) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm");
        String dateStr = DateFor.format(data);
        String hourStr = TimeFor.format(hora);
        System.out.println(dateStr + " " + hourStr);
    }

}
