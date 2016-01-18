/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
/**
 *
 * @author Jordi
 */
public class Pruebas {
    public static void main(String[] args){
        
        Baraja baraja = new Baraja();
        
        Poker poker = new Poker(baraja,2);
        poker.crearCartaPoker();
        poker.jugar();  
        
    }
}
