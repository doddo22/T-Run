/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import general.Board;

/**
 *
 * @author claud
 */
public class Bird extends Item{
    
    
    public Bird(int x, int y) {
        super(x, y, "image/bn/bird1.png");
    }
    
    @Override
    public void collisionAction(Item collidedItem) {
        Board.running = false;
        Board.gameOver = true;
        super.TRex.setState(TRex.getDead());        
    }
            
}
