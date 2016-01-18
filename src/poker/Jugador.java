/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 *
 * @author Jordi
 */
public class Jugador {
   private int id;
   private Carta cartaDescarte;
   private ArrayList<Carta> mano = new ArrayList<Carta>();
   private ArrayList<Carta> manoDescartes = new ArrayList<Carta>();
   private ArrayList<Carta> manoJugada = new ArrayList<Carta>();
   private int puntos = 0;
   private String jugada;

    public Jugador(int id) {
        this.id = id;
    }

    public String getJugada() {
        return jugada;
    }

    public void setJugada(String jugada) {
        this.jugada = jugada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
    
    public ArrayList<Carta> getManoDescartes() {
        return manoDescartes;
    }

    public void setManoDescartes(ArrayList<Carta> manoDescartes) {
        this.manoDescartes = manoDescartes;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    } 

    public ArrayList<Carta> getManoJugada() {
        return manoJugada;
    }

    public void setManoJugada(ArrayList<Carta> manoJugada) {
        this.manoJugada = manoJugada;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
       
    public void mostrarMano(){
       System.out.println("Cartas para jugador "+this.getId()+"\n"+this.mano);
    }
    
    public void compararCartas(){//Agrupar las cartas que se descartaran y las de jugada
        int cont=0;
        
        for(int i=0; i<mano.size(); i++){
            for(int j=0; j<mano.size(); j++){
                if(this.mano.get(i).getNumero() == this.mano.get(j).getNumero()){
                    cont++;
                }
            }
            if(cont < 2){
                manoDescartes.add(mano.get(i));
            }
            else {
                manoJugada.add(mano.get(i));
            }
            cont=0;
        }
         //System.out.println("Cartas a descartar "+manoDescartes);
          //System.out.println("Cartas para jugada "+manoJugada);
    }
    
    public void prepararJugada(Carta card){
        if(manoJugada.size() == 0){//En caso de que no haya ninguna combinacion de cartas ganadoras
            mano.clear();//elimina todas las cartas de la mano
            descartarCarta();
            cogerCarta(card);
        }
        else {
            mostrarJugada();
            this.calcularPuntuacion();
        }
    }
    //Metodo que descarta una carta y la retorna para añadir a baraja
    public Carta descartarCarta(){
        int numCarta =(int)(Math.random()*4+1);//Descarta aleatoriamente una carta no repetida
        System.out.println("Jugador "+this.getId()+" descartara la carta: "+manoDescartes.get(numCarta));
        cartaDescarte = manoDescartes.get(numCarta);
        manoDescartes.remove(numCarta);
        return cartaDescarte;
    }
    
    public void cogerCarta(Carta card){
        //Actualiza el ArrayList de mano y añade una carta
        for(int i=0; i<manoDescartes.size(); i++){
            mano.add(manoDescartes.get(i));
        }
        mano.add(card);
        this.manoDescartes.clear();//Elimina todas las cartas del ArrayList manoDescartes
        System.out.println("Jugador "+this.getId()+" cogerá la carta:"+card+"\nCartas de la mano actualizadas: "+mano);
    }
    
    public void mostrarJugada(){
        System.out.println("Combinacion de cartas ganadora del jugador "+this.getId()+": "+this.manoJugada);
    }   
    
    //Dependiedo de la jugada multiplicara la puntucion por un valor
    //valores: pareja->*1 | doble pareja->*10 | trío->*100 | full->*1000 | poker->*10000
     public int calcularPuntuacion(){
        switch(this.manoJugada.size()){
            case 2: this.puntos = this.manoJugada.get(0).getNumero()*2*1; this.jugada = "Pareja";
            break;
            case 3: this.puntos = this.manoJugada.get(0).getNumero()*3*100; this.jugada = "Trio";
            break;
            case 4: int cont=0;
                    for(int i=0; i<manoJugada.size(); i++){
                        if(this.manoJugada.get(0).getNumero() == this.manoJugada.get(i).getNumero()){
                            cont++;
                        }
                    }
                    if(cont == 4){
                        this.puntos = this.recorrerManoJugada()*10000; this.jugada = "Doble pareja";
                    }
                    else this.puntos = this.recorrerManoJugada()*10; this.jugada = "Full";
            break;
            case 5: this.puntos = this.recorrerManoJugada()*1000; this.jugada = "Poker";
            break;
        }
        return this.puntos;
    }
     
     //Recorre las cartas del ArrayList manoJugada para obtener una puntuacion de las cartas iguales
     public int recorrerManoJugada(){
        int sum1 = 0; int sum2 = 0;
        for(int i=0; i<this.manoJugada.size(); i++){
            if(this.manoJugada.get(0).getNumero() == this.manoJugada.get(i).getNumero()){
                sum1 = sum1+this.manoJugada.get(i).getNumero();
            }
            else sum2 = sum2+this.manoJugada.get(i).getNumero();
        }
        return sum1+sum2;
     }
}
