package trabalho_oo;

import java.util.ArrayList;
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
        for (Compromisso confirmado : compromissosConfirmados) {
            if(confirmado.estaEmConflitoCom(compromisso)){
                if(confirmado.maisImportanteQue(compromisso)){
                    if(compromisso.isAdiavel()){
                        this.adicionarNaListaDeCompromissosAdiados(compromisso);
                        return;
                    } else {
                        this.adicionarNaListaDeCompromissosCancelados(compromisso);
                        return;
                    }
                } else {
                    if(confirmado.isAdiavel()){
                        this.adicionarNaListaDeCompromissosAdiados(confirmado);
                    } else {
                        this.adicionarNaListaDeCompromissosCancelados(confirmado);
                    }
                    molde.remove(confirmado);
                }
            }
        }
        this.compromissosConfirmados = molde;
        this.adicionarNaListaDeCompromissosConfirmados(compromisso);
    }
    
    private void adicionarNaListaDeCompromissos(Compromisso compromisso){
        for (int i = 0; i < this.compromissos.size(); i++) {
            if(compromissos.get(i).getInicio().compareTo(compromisso.getInicio()) < 0){
                this.compromissos.add(i, compromisso);
                break;
            }
            if(i == this.compromissos.size() - 1){
                this.compromissos.add(compromisso);
            }
        }
    }
    private void adicionarNaListaDeCompromissosAdiados(Compromisso compromisso){
        for (int i = 0; i < this.compromissosAdiados.size(); i++) {
            if(compromissosAdiados.get(i).getInicio().compareTo(compromisso.getInicio()) < 0){
                this.compromissos.add(i, compromisso);
                break;
            }
            if(i == this.compromissosAdiados.size() - 1){
                this.compromissosAdiados.add(compromisso);
            }
        }
    }
    private void adicionarNaListaDeCompromissosCancelados(Compromisso compromisso){
        for (int i = 0; i < this.compromissosCancelados.size(); i++) {
            if(compromissosCancelados.get(i).getInicio().compareTo(compromisso.getInicio()) < 0){
                this.compromissosCancelados.add(i, compromisso);
                break;
            }
            if(i == this.compromissosCancelados.size() - 1){
                this.compromissosCancelados.add(compromisso);
            }
        }
    }
    private void adicionarNaListaDeCompromissosConfirmados(Compromisso compromisso){
        for (int i = 0; i < this.compromissosConfirmados.size(); i++) {
            if(compromissosConfirmados.get(i).getInicio().compareTo(compromisso.getInicio()) < 0){
                this.compromissosConfirmados.add(i, compromisso);
                break;
            }
            if(i == this.compromissosConfirmados.size() - 1){
                this.compromissosConfirmados.add(compromisso);
            }
        }
    }
}
