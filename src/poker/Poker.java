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
public class Poker {
    private Baraja poquer;
    private String[] dibujo = {"Corazones", "Diamantes", "Picas", "Treboles"};
    private Jugador[] jugador;
    private int nCartas= 5 ;//Numero de cartas a repartir
    private int ganador = 0;

    public Poker(Baraja BarajaPoquer, int nJugadores) {
        this.poquer = BarajaPoquer;
        this.jugador = new Jugador[nJugadores];
        for(int i=0; i<nJugadores; i++){
            this.jugador[i] = new Jugador();
        }
        
    }
    
    public Baraja getPoquer() {
        return poquer;
    }

    public void setPoquer(Baraja poquer) {
        this.poquer = poquer;
    }

    public String[] getDibujo() {
        return dibujo;
    }

    public void setDibujo(String[] dibujo) {
        this.dibujo = dibujo;
    }

    public Jugador[] getJugador() {
        return jugador;
    }

    public void setJugador(Jugador[] jugador) {
        this.jugador = jugador;
    }
    
    void crearCartaPoker(){
        this.poquer.crearCarta(4, 14, this.dibujo);
    }
    
    public void jugar(){
        //this.poquer.mostrar();
         this.barajarCartasPoker();
         repartirCartaPoker();
         descartarCartaPoker();
         //calcularGanador();
    }
    
    public void verBaraja(){
        poquer.mostrar();
    }
    
    public void barajarCartasPoker(){
        this.poquer.barajar();
    }
    
    public void repartirCartaPoker(){
        System.out.println("--Se han repartido cartas:--");
        for(int i=0; i<this.jugador.length; i++){
            this.jugador[i].setMano(this.poquer.repartir(this.nCartas));
            jugador[i].mostrarMano(i+1); 
        }
    }
    
    public void descartarCartaPoker(){
        int ronda = 1;//Rondas de cada jugador
        while(this.ganador == 0){
           System.out.println("\n----Ronda: "+ronda+" ----");
           for(int i=0; i<this.jugador.length; i++){
            this.jugador[i].compararCartas();
            //this.poquer.getCard().add(this.jugador[0].descartarCarta());//devuelve la carta descartada a la baraja
            
            this.jugador[i].prepararJugada(this.poquer.getCard().get(0), i+1);
            
            this.poquer.getCard().remove(this.poquer.getCard().get(0));
            
            this.ganador = this.ganador+jugador[i].getPuntos();
           }
           ronda++;
           
        }
        this.calcularGanador();
    } 
    
    public void calcularGanador(){
        int winner = this.jugador[0].getPuntos();
        int numGan = 0;
        for(int i=0; i<this.jugador.length; i++){
             //System.out.println("Puntuacion: "+this.jugador[i].getPuntos());
            if(this.jugador[i].getPuntos() > winner){
               winner = this.jugador[i].getPuntos();
               numGan = i;
            }
        }
        
        System.out.println("\n----Jugador "+(numGan+1)+" tiene la mejor mano:\n"+this.jugador[numGan].getMano());
    }
}
