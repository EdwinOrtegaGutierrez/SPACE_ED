
import java.awt.Point;
import java.awt.event.KeyEvent;
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
public class Shooter {
    
    private int  diff = 10;
    private Timer timer;
    private JPanel shoot, nave, dashboard;
            
    public Shooter(){}
    
    public Shooter(JPanel shoot, JPanel nave, JPanel dashboard){
        this.shoot = shoot;
        this.nave = nave;
        this.dashboard = dashboard;
    }
    
    private void moveShoot() {
        Point location = shoot.getLocation();
        if (location.y > 0) {
            diff = diff -10;

            location.y += diff;
            shoot.setLocation(location);
        }
        if (location.y <= 75) {
            diff = 0;
            stopTimer();
            shoot.setLocation(50, 30000);
        }
    }
    private void launchTimer() {
        if (timer == null) {
            timer = new Timer(0, e -> moveShoot());
            timer.setDelay(500);
        }
        timer.start();
    }

    private void stopTimer() {
        timer.stop();
    }
    
    public void shooting(KeyEvent e){
        switch(e.getKeyCode()){
            case 90 -> {// Key Z
                
                int naveX = nave.getX()+20, naveY = nave.getY()-16;

                shoot.setBackground(new java.awt.Color(255, 51, 102));
                dashboard.add(shoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(nave.getX()+20, nave.getY()-16, 5, 15));
                shoot.setLocation(naveX, naveY);
                shoot.setVisible(true);
                launchTimer();
            }
        }
    }
    
}