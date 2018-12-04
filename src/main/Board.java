/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.*;
import java.awt.*;
import components.*;
import java.awt.event.*;
import static java.lang.System.gc;
import sun.swing.BakedArrayList;

/**
 *
 * @author Gennaro
 */
public class Board extends JPanel implements Runnable, ActionListener {

    private TRex TRex;
    private Ground grass_ground;
    private Obstacles obstacles;
    private Moneys moneys;
    private Background background;

    public static int distance;
    private int score;
    private Thread animator;
    
  

    //INIZIALIZZO BOARD
    public Board() {

        setFocusable(true);//il metodo che mi ha salvato la vita con il keyListener

        addKeyListener(new TRexAdapter());

        //TREX
        TRex = new TRex();
        
        background = new Background();

        //GROUND
        grass_ground = new Ground();

        //OSTACOLI
        obstacles = new Obstacles();
        
        //MONETINE
        moneys = new Moneys();
        
        //DISTANZA PERCORSA
        distance = 0;
        //SCORE
        score = 0;

        //ATTENZIONE: questo deve essere fatto nella classe Partita
        background.update();
        grass_ground.update();
        moneys.update();
        obstacles.update();
        
        animator = new Thread(this);
        animator.start();
    }
    
    

    public void updateGame() {
        distance += 1;
        background.update();
        grass_ground.update();
        moneys.update();
        obstacles.update();
        

        if (obstacles.hasCollided(TRex.getCollider())) {
            System.out.println("Morto shobalola");
        }
        if (moneys.hasCollided(TRex.getCollider())) {
            System.out.println("Ho preso una monetina shobalola");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        background.create(g);
        grass_ground.create(g);//creare sempre prima il ground
        moneys.create(g);
        obstacles.create(g);
        
        TRex.create(g);
        g.setFont(new Font("Courier New", Font.BOLD, 25));
        g.drawString("MT: " + Integer.toString(distance), getWidth() / 4 - 100, 100);
        g.drawString("SCORE: " + Integer.toString(score), getWidth() - getWidth() / 4, 100);

        g.dispose();
    }
    
    public void repaintJump(){
        super.repaint();
    }

    @Override
    public void run() {

        while (true) {
            this.updateGame();
            this.repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
    }

    private class TRexAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            TRex.keyPressed(e);
        }
        
        @Override
        public void keyTyped(KeyEvent e){
            TRex.keyTyped(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            TRex.keyReleased(e);
        }
    }

}
