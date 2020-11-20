package trabalho_oo;


/**
 *
 * @author Beatriz
 */
public class Trabalho_OO {


    public static void main(String[] args) {
     
        //Parametros: identificador, prioridade, data(string), hora(string), duração (dias), nome do evento, local
       Evento e = new Evento(1, 1, "29/11/2020", "23:06", 4, "Evento1", "Local x");
       
       //Parametros: identificador, prioridade, data(string), hora(string), duração (minutos), motivo, local
       Particular p = new Particular(2,2, "20/11/2020", "02:00", 60, false, "Motivo particular1", "Local y");
       
       e.imprimeDados();
       p.imprimeDados();
       
       



        
    }
    
}
