/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_oo;
import java.util.*;



/**
 *
 * @author Beatriz
 */
public class Trabalho_OO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        //Parametros: identificador, prioridade, data(string), hora(string), duração (dias), nome do evento, local
       Evento e = new Evento(1, 1, "29/11/2020", "23:06", 4, "Evento1", "Local x");
       
       //Parametros: identificador, prioridade, data(string), hora(string), duração (minutos), motivo, local
       Particular p = new Particular(2,2, "20/11/2020", "02:00", 60, false, "Motivo particular1", "Local y");
       
       e.imprimeDados();
       p.imprimeDados();
       
       



        
    }
    
}
