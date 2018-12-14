/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trex;

import general.UserInterface;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import resources.Resources;

/**
 *
 * @author Angela
 */
public class Dead implements TrexState {

    private final Trex trex;
    private final BufferedImage deadTRex;//immagine TRex morto
    
    public Dead(Trex trex) {
        this.trex = trex;
        this.deadTRex = Resources.instance().getDeadImage();
    }

    @Override
    public void create(Graphics g) {
        g.drawImage(this.deadTRex, trex.x, trex.y, null);
        //g.drawImage(gameOverImage, 0, 0, null);
        g.setFont(new Font("Courier New", Font.BOLD, 25));
        g.drawString("GAME OVER", UserInterface.width / 2 - 70, UserInterface.height / 2);
        g.drawString("Press ENTER to restart", UserInterface.width / 2 - 150, UserInterface.height / 2 + 35);
    }
    
}