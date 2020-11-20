package trabalho_oo;


public class Orientacao extends Compromisso {

    private String nomeDoOrientado;
    private String tipo;
    private String assunto;

    public Orientacao(int identificador, int grauPrioridade, String dataStr, String horaStr, int duracao, String nomeDoOrientado, String tipo, String assunto, boolean adiavel) {
        super(identificador, grauPrioridade, dataStr, horaStr, duracao);
        this.nomeDoOrientado = nomeDoOrientado;
        this.tipo = tipo;
        this.assunto = assunto;
        this.setAdiavel(adiavel);

        if (this.isAdiavel()) {
            this.setFatorMultiplicador(1);
        } else {
            this.setFatorMultiplicador(2);
        }

    }

    public String getNomeDoOrientado() {
        return nomeDoOrientado;
    }

    public void setNomeDoOrientado(String nomeDoOrientado) {
        this.nomeDoOrientado = nomeDoOrientado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public void imprimeDados() {
        // TODO Auto-generated method stub
        System.out.println(this.getIdentificador() + ": Orientacção de " + getNomeDoOrientado());
        System.out.printf("Inicio: ");
        imprimeDataHora(this.getData(), this.getHora());
        System.out.println("Prioridade: " + this.getGrauPrioridade());
        System.out.println("\n");

    }

}
