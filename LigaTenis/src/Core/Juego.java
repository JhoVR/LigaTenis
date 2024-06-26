/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import Core.Persona.Juez;
import Core.Persona.Jugador;
import java.util.ArrayList;

/**
 *
 * @author jregalado
 */
public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Juez juez;
    private Juego juegoPrevio1;
    private Juego juegoPrevio2;
    private Juego juegoSiguiente;
    private ArrayList<Set> sets;

    public Juego(Jugador jugador1, Jugador jugador2, Juez juez) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juez = juez;
        this.sets=new ArrayList<>();
        this.juegoPrevio1=null;
        this.juegoPrevio2=null;
        this.juegoSiguiente=null;
        
        this.jugador1.addJuego(this);
        this.jugador2.addJuego(this);
        this.juez.addJuego(this);
    }

    public Juego(Juego juegoPrevio1, Juego juegoPrevio2, Juez juez) {
        this.juez = juez;
        this.juegoPrevio1 = juegoPrevio1;
        this.juegoPrevio2 = juegoPrevio2;
        this.juegoSiguiente=null;
        this.sets=new ArrayList<>();
        this.jugador1 = juegoPrevio1.getGanador();
        this.jugador2= juegoPrevio2.getGanador();
        
        this.jugador1.addJuego(this);
        this.jugador2.addJuego(this);
        this.juez.addJuego(this);
        
        this.juegoPrevio1.setJuegoSiguiente(this);
        this.juegoPrevio2.setJuegoSiguiente(this);
    }
    
    
    
    public boolean addSets(Set set1){
        this.sets.add(set1);
        return true;
    }
    public boolean addSets(Set set1, Set set2){
        this.sets.add(set1);
        this.sets.add(set2);
        return true;
    }
    public boolean addSets(Set set1, Set set2,Set set3){
        this.sets.add(set1);
        this.sets.add(set2);
        this.sets.add(set3);
        return true;
    }
    
    public Jugador getGanador(){
        Set lastSet= this.sets.get(this.sets.size() - 1);
        if(lastSet.getPuntosJugador1()>lastSet.getPuntosJugador2()) return this.jugador1;
        return this.jugador2;
    }
    
    public boolean setJuegoSiguiente(Juego juegoSiguiente){
        this.juegoSiguiente=juegoSiguiente;
        return true;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Juez getJuez() {
        return juez;
    }

    public Juego getJuegoPrevio1() {
        return juegoPrevio1;
    }

    public Juego getJuegoPrevio2() {
        return juegoPrevio2;
    }

    public Juego getJuegoSiguiente() {
        return juegoSiguiente;
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
    
    
}
