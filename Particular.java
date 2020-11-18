/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_oo;

/**
 *
 * @author Beatriz
 */
public class Particular extends Compromisso{
    
    private String motivo;
    private String local;
    
    
     public Particular(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, boolean adiavel, String motivo, String local)
    {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao, adiavel);
        this.setFatorMultiplicador(2);
        this.motivo = motivo;
        this.local = local;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
     
      public void imprimeDados()
    {
        System.out.printf("\n %d: %s\n", this.getIdentificador(),this.getMotivo());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getData(), this.getHora());
        System.out.printf("Prioridade: %d\n", this.getGrauPrioridade());
        System.out.printf("Duracao: %d minutos\n", this.getDuracao());
        System.out.printf("Local: %s\n", this.getLocal());
        if(this.isAdiavel())
        System.out.println("Adiavel: sim");
        else
        System.out.println("Adiavel: não");  
    }
}
