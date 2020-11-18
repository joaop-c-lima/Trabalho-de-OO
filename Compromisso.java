/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public abstract void imprimeDados();


    public Compromisso(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, boolean adiavel){
       this.setIdentificador(identificador);
       this.setGrauPrioridade(grauPrioridade);
       this.setData(dataStr);
       this.setHora(horaStr);
       this.setDuracao(duracao);
       this.setAdiavel(adiavel);
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

    public void setData(String dataStr) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date data = DateFor.parse(dataStr);
            this.data = data;   
            
        }catch (ParseException e) {e.printStackTrace();}
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(String horaStr) {
        
          SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm");
        try{
            Date hora = DateFor.parse(horaStr);
            this.hora = hora;
           
        }catch (ParseException e) {e.printStackTrace();}
    }

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
        this.adiavel = adiavel;
    }
    
     public int getFatorMultiplicador() {
        return fatorMultiplicador;
    }

    public void setFatorMultiplicador(int fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }
    
    public void imprimeDataHora(Date data, Date hora)
    {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm");
        String dateStr= DateFor.format(data);
        String hourStr = TimeFor.format(hora);
        System.out.println(dateStr + " " + hourStr);
    }
    
    
    
    
    
}
