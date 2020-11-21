/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_oo;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author Beatriz
 */
public abstract class Compromisso {
    private int identificador;
    private int grauPrioridade;
    private int fatorMultiplicador;
    private Calendar inicio = Calendar.getInstance();
    private Calendar fim = Calendar.getInstance();
    private int duracao;
    private boolean adiavel;
    private boolean mudancaAdiavel = false;

    public abstract void imprimeDados();


    public Compromisso(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao){
       this.setIdentificador(identificador);
       this.setGrauPrioridade(grauPrioridade);
       this.setDuracao(duracao);
       
        //Salvando data e hora de inicio no calendario
        
        String[] data = dataStr.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        
        String[] hora = horaStr.split(":");
        int h = Integer.parseInt(hora[0]);
        int m = Integer.parseInt(hora[1]);
        int s = 0;
       
        inicio.set(ano, mes-1, dia, h, m,s);
        fim.set(ano, mes-1, dia, h, m, s);
        
    }

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFim() {
        return fim;
    }

    public void setFim(Calendar fim) {
        this.fim = fim;
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
         
        if(!(adiavel) && this.isAdiavel())
        {
               this.setFatorMultiplicador(this.getFatorMultiplicador()+1);
               this.setMudancaAdiavel(true);

        }
        else if(adiavel && (this.isAdiavel() == false))
        {
            if(houveMudancaAdiavel())
            {
                this.setFatorMultiplicador(this.getFatorMultiplicador()-1);
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
    public void imprimeDataHora(Date datetime)
    {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm");
        String dateStr= DateFor.format(datetime);
        String hourStr = TimeFor.format(datetime);
        System.out.println(dateStr + " " + hourStr);
    }
     
    
}
