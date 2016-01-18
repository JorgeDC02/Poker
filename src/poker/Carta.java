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
public class Carta {
    private int numero;
    private String palo;

    public Carta(String palo, int numero) {
        this.numero = numero;
        this.palo = palo;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta {" + "numero=" + this.numero + ", palo= " + this.palo + "}\n";
    }

    
}
