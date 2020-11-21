package trabalho_oo;

import java.util.Calendar;

/**
 *
 * @author Beatriz
 */
public class Particular extends Compromisso {

    private String motivo;
    private String local;

    public Particular(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, boolean adiavel, String motivo, String local) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao, 2);
        int aux = adiavel ? 0 : 1;
        if (aux == 1) {
            this.setMudancaAdiavel(true);
        }
        this.setFatorMultiplicador(2 + aux);
        this.motivo = motivo;
        this.local = local;
        this.setAdiavel(adiavel);
        this.getFim().add(Calendar.MINUTE, duracao);

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

    public void imprimeDados() {
        System.out.printf("%d: %s\n", this.getIdentificador(), this.getMotivo());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getInicio().getTime());
        System.out.printf("Fim: ");
        imprimeDataHora(this.getFim().getTime());
        System.out.printf("Prioridade: %d\n", this.getGrauPrioridade());
        System.out.printf("Local: %s\n\n", this.getLocal());

    }
    
    @Override
    public String getDescricao(){
        return this.getMotivo();
    }
    
    @Override
    public String getDadosEspecificos(){
        return this.local;
    }
}
