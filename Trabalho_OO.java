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
     

       Evento e = new Evento(1, 1, "29/11/2020", "00:06", 2, true, "Evento1", "Local x");
       
       Particular p = new Particular(2,2, "20/11/2020", "02:00", 60, false, "BE Lançamento", "Youtube");
       
       e.imprimeDados();
       p.imprimeDados();
        
    }
    
}
