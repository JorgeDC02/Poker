/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jordi
 */
public class Baraja {
    private ArrayList<Carta> card =new ArrayList<Carta>();
   // private int idCarta=0;
    
    public ArrayList<Carta> getCard() {
        return card;
    }

    public void setCard(ArrayList<Carta> card) {
        this.card = card;
    }
    
    //Crea las cartas de tipo poquer pasando el numero de tipos de cartas, numero de cartas por tipo y el nombre
    public void crearCarta(int Ndibujos, int Ncartas, String[] dibujos){
        for(int p=0; p<Ndibujos; p++){
            for(int c=2; c<=Ncartas; c++){
                 this.card.add(new Carta(dibujos[p],c));
            }
        }
    }
    
    public void mostrar(){//Metodo creado para ver el listado de cartas
       System.out.println("Listado de cartas");
        for(int c=0; c<this.card.size(); c++){
            System.out.println("Valores de carta: "+this.card.get(c).getNumero()+" "+this.card.get(c).getPalo());
        }
    }
    
    public void barajar(){
        System.out.println("--Se han barajado las cartas--");
        Collections.shuffle(this.card);
    }
    
    public ArrayList<Carta> repartir(int numCartas){
        ArrayList<Carta> cards = new ArrayList<Carta>();
        for(int i=0; i<numCartas; i++){
            cards.add(i, this.card.get(0));
            this.card.remove(0);
        }
        return cards;
    }      
    
}