package trabalho_oo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author João Pedro Lima
 */
public class Agenda {

    List<Compromisso> compromissos;
    List<Compromisso> compromissosConfirmados;
    List<Compromisso> compromissosCancelados;
    List<Compromisso> compromissosAdiados;

    public Agenda() {
        this.compromissos = new ArrayList<>();
        this.compromissosConfirmados = new ArrayList<>();
        this.compromissosCancelados = new ArrayList<>();
        this.compromissosAdiados = new ArrayList<>();
    }

    public Agenda(List<Compromisso> compromissosConfirmados, List<Compromisso> compromissosCancelados, List<Compromisso> compromissosAdiados, List<Compromisso> compromissos) {
        this.compromissos = compromissos;
        this.compromissosConfirmados = compromissosConfirmados;
        this.compromissosCancelados = compromissosCancelados;
        this.compromissosAdiados = compromissosAdiados;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }

    public List<Compromisso> getCompromissosConfirmados() {
        return compromissosConfirmados;
    }

    public void setCompromissosConfirmados(List<Compromisso> compromissosConfirmados) {
        this.compromissosConfirmados = compromissosConfirmados;
    }

    public List<Compromisso> getCompromissosCancelados() {
        return compromissosCancelados;
    }

    public void setCompromissosCancelados(List<Compromisso> compromissosCancelados) {
        this.compromissosCancelados = compromissosCancelados;
    }

    public List<Compromisso> getCompromissosAdiados() {
        return compromissosAdiados;
    }

    public void setCompromissosAdiados(List<Compromisso> compromissosAdiados) {
        this.compromissosAdiados = compromissosAdiados;
    }

    public void addCompromisso(Compromisso compromisso) {
        
        this.adicionarNaListaDeCompromissos(compromisso);
        
        List<Compromisso> molde = this.compromissosConfirmados;
        
        int size = this.compromissosConfirmados.size();
        
        boolean estaEmConflito = false;
        
        for (Compromisso confirmado : compromissosConfirmados) {
           
            if (confirmado.estaEmConflitoCom(compromisso)) {
                estaEmConflito = true;
                if (confirmado.maisImportanteQue(compromisso)) {
                    
                    if (compromisso.isAdiavel()) {
                        
                        this.adicionarNaListaDeCompromissosAdiados(compromisso, confirmado);
                        
                        break;
                        
                    } else {
                        
                        this.adicionarNaListaDeCompromissosCancelados(compromisso, confirmado);
                        
                        break;
                    }
                    
                } else {
                    
                    if (confirmado.isAdiavel()) {
                        
                        this.adicionarNaListaDeCompromissosAdiados(confirmado, compromisso);
                        
                    } else {
                        
                        this.adicionarNaListaDeCompromissosCancelados(confirmado, compromisso);
                        
                    }
                    
                    this.adicionarNaListaDeCompromissosConfirmados(compromisso);
                    molde.remove(confirmado);
                    break;
                }
            }
        }
        
        if(size == 0 || !estaEmConflito){
            this.adicionarNaListaDeCompromissosConfirmados(compromisso);
        }
        this.compromissosConfirmados = molde;
        
    }

    public String getRelatorioConfirmados() {
        String result = "";
        for (Compromisso compromisso : compromissosConfirmados) {
            result = result + "\n\n" + this.getDataHoraString(compromisso.getInicio())
                    + "\n" + compromisso.getIdentificadorString()
                    + "\n" + compromisso.getDescricao();
        }
        return result.replaceFirst("\n\n", "");
    }

    public String getRelatorioAdiados() {
        String result = "";
        for (Compromisso compromisso : compromissosAdiados) {
            result = result + "\n\n" + compromisso.getIdentificadorString()
                    + "\n" + compromisso.getDescricao()
                    + "\n" + compromisso.getGrauPrioridade()
                    + "\n" + compromisso.getMotivoDeExclusao().getIdentificadorString();
        }
        return result.replaceFirst("\n\n", "");
    }

    public String getRelatorioCancelados() {
        String result = "";
        for (Compromisso compromisso : compromissosCancelados) {
            result = result + "\n\n" + compromisso.getIdentificadorString()
                    + "\n" + compromisso.getDescricao()
                    + "\n" + compromisso.getGrauPrioridade()
                    + "\n" + compromisso.getMotivoDeExclusao().getIdentificadorString();
        }
        return result.replaceFirst("\n\n", "");
    }

    public String getRelatorioCompleto() {
        String result = "";
        for (Compromisso compromisso : compromissos) {
            result = result + "\n\n" + compromisso.getIdentificadorString() + ": " + compromisso.getDescricao()
                    + "\nInicio: " + this.getDataHoraString(compromisso.getInicio())
                    + "\nFim: " + this.getDataHoraString(compromisso.getFim())
                    + "\nPrioridade: " + compromisso.getGrauPrioridade()
                    + "\n" + compromisso.getDadosEspecificos();

        }
        return result.replaceFirst("\n\n", "");
    }

    private void adicionarNaListaDeCompromissos(Compromisso compromisso) {

        int size = this.compromissos.size();
        if (size == 0) {
            this.compromissos.add(compromisso);
        } else {
            for (int i = 0; i < size; i++) {

                if (compromissos.get(i).getInicio().compareTo(compromisso.getInicio()) > 0) {
                    this.compromissos.add(i, compromisso);

                    break;
                }
                if (i == size - 1) {
                    this.compromissos.add(compromisso);

                }
            }
        }

    }

    private void adicionarNaListaDeCompromissosAdiados(Compromisso compromisso, Compromisso motivo) {
        compromisso.setMotivoDeExclusao(motivo);
        int size = this.compromissosAdiados.size();
        if (size == 0) {
            this.compromissosAdiados.add(compromisso);
           
        } else {
            
            for (int i = 0; i < size; i++) {
                if (compromissosAdiados.get(i).getInicio().compareTo(compromisso.getInicio()) < 0) {
                    this.compromissos.add(i, compromisso);
                    
                    break;
                }
                if (i == size - 1) {
                    this.compromissosAdiados.add(compromisso);
                    
                }
            }
        }
    }

    private void adicionarNaListaDeCompromissosCancelados(Compromisso compromisso, Compromisso motivo) {
        compromisso.setMotivoDeExclusao(motivo);
        int size = this.compromissosCancelados.size();
        if (size == 0) {
            this.compromissosCancelados.add(compromisso);
        } else {
            for (int i = 0; i < size; i++) {
                if (compromissosCancelados.get(i).getInicio().compareTo(compromisso.getInicio()) > 0) {
                    this.compromissosCancelados.add(i, compromisso);
                    break;
                }
                if (i == size - 1) {
                    this.compromissosCancelados.add(compromisso);
                }
            }
        }
    }

    private void adicionarNaListaDeCompromissosConfirmados(Compromisso compromisso) {
        int size = this.compromissosConfirmados.size();
        if (size == 0) {
            this.compromissosConfirmados.add(compromisso);
        } else {
            for (int i = 0; i < size; i++) {
                if (compromissosConfirmados.get(i).getInicio().compareTo(compromisso.getInicio()) > 0) {
                    this.compromissosConfirmados.add(i, compromisso);
                    break;
                }
                if (i == size - 1) {
                    this.compromissosConfirmados.add(compromisso);
                }
            }
        }
    }

    private String getDataHoraString(Calendar calendar) {
        Date datetime = calendar.getTime();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm");
        String dateStr = DateFor.format(datetime);
        String hourStr = TimeFor.format(datetime);
        return dateStr + " " + hourStr;
    }
}
