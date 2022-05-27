
import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edwin
 */
public class Alien {
    private String claveAlien;
    private int numero, contadorAliens = 3, diffAlien = 20;
    
    private ArrayList numeros = new ArrayList();
    private JPanel dashboard, shoot;
    private Timer timer;
    private javax.swing.JLabel alien_elemental = new javax.swing.JLabel();
    private PilaNodo lista;
    private Alien alien;
    private JLabel score;
    private int puntaje;
    public Alien(){
    }
    
    public Alien(String claveAlien) {
        this.claveAlien = claveAlien;
    }
    
    public Alien(JPanel dashboard, JPanel shoot, JLabel score, int puntaje){
        this.dashboard = dashboard;
        this.shoot = shoot;
        this.score = score;
        this.puntaje = puntaje;
    }
    
    public void aliensInvaders(){
        for(int i = 1; i <= contadorAliens; i++){
            numero = (int) (Math.random() * 3 + 1);
            if (numeros.contains(numero)) {
                i--;
            } else {
                numeros.add(numero);
            }
            if(numero%2==0){        
               // aliens es una lista
               lista = new PilaNodo();
               alien = new Alien();
               alien.setClaveAlien("/IconSpace/alien2.png");
               lista.apilar(alien);
               System.out.println("Hey 2");
               System.out.println(lista.mostrar());
               break;
            }
            else if(numero%3==0){
               lista = new PilaNodo();
               alien = new Alien();
               alien.setClaveAlien("/IconSpace/alien3.png");
               lista.apilar(alien);
               System.out.println("Hey 3");
               System.out.println(lista.mostrar());
               break;
            }
            else{
               lista = new PilaNodo();
               alien = new Alien();
               alien.setClaveAlien("/IconSpace/alien1.png");
               lista.apilar(alien);
               System.out.println("Hey 1");
               System.out.println(lista.mostrar());
               break;
            }
        }
        
        alien_elemental.setBackground(new java.awt.Color(255, 0, 0));
        alien_elemental.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alien_elemental.setIcon(new javax.swing.ImageIcon(getClass().getResource(lista.mostrar()))); // NOI18N
       
        this.dashboard.add(alien_elemental, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 48, 48));
        launchTimerForAlien();
    }
    
    private void moveAlien() {
        Point location = alien_elemental.getLocation();
        Point shootLocation = shoot.getLocation();
        
        if (location.x > 735) {
            diffAlien = -20;
        }
        else if (location.x < 15) {
            diffAlien = 20;
        }
        if((shootLocation.y <= location.y+50) &&
            (shootLocation.x >= location.x-50 && shootLocation.x <= location.x+50)){
            this.dashboard.remove(alien_elemental);
            aliensInvaders();
            shootLocation.setLocation(0, 0);
            shoot.setVisible(false);
            puntaje = puntaje + 10;
            score.setText("SCORE: " + puntaje);
        }
        
        location.x += diffAlien;
        alien_elemental.setLocation(location);
    }
    
    public void resetPoint(){
        puntaje = 0;
    }
    
    private void launchTimerForAlien() {
        if (timer == null) {
            timer = new Timer(0, e -> moveAlien());
            timer.setDelay(500);
        }
        timer.start();
    }

    public void setClaveAlien(String claveAlien) {
        this.claveAlien = claveAlien;
    }
    public String getClaveAlien() {
        return claveAlien;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.claveAlien);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alien other = (Alien) obj;
        return Objects.equals(this.claveAlien, other.claveAlien);
    }

    @Override
    public String toString() {
        return claveAlien+" ";
    }
}