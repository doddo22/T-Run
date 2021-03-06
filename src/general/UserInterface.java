/*
 * This class represents the game window.
 * This class is implemented according with the Singleton design pattern.
 */
package general;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author G8
 */
public class UserInterface extends JFrame { //Singleton

    public static int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8);
    public static int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.7);
    private static UserInterface instance = null;

    private UserInterface() {
        this.add(new Board());//con questo metodo inserisco una Board al centro del contenitore JFrame
        this.setTitle("T-Run");//setto il titolo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setto l'operazione di default da eseguire quando chiudo la finestra
        this.setSize(width, height);
        this.setLocationRelativeTo(null);//in questo modo posiziono il JFrame al centro dello schermo
        this.setResizable(false);
    }

    public static UserInterface instance() {
        if (instance == null) {
            instance = new UserInterface();
        }
        return instance;
    }

    public static void setInstance(UserInterface instance) {
        UserInterface.instance = instance;
    }

}
