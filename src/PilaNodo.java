/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



/**
 *
 * @author edwin
 */
public class PilaNodo {
    private Nodo primero, ultimo;
    Alien alien;
    public void apilar(Alien alien){
        this.alien = alien;
        Nodo nuevo =  new Nodo(alien);
        if(primero == null){
            primero = nuevo;
        }
        else{
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    
    public String mostrar(){
        String s = ""+this.alien;
        return s;
    }
}
