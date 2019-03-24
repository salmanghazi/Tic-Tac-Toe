/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign4;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author m.salmanghazi
 */
public class TTModel {

    tictactoe view;
    ImageIcon img;
    private int currentPlayer;
    TTController control;

    TTModel(int curr, tictactoe vie, TTController con) {
        currentPlayer = curr;
        if (currentPlayer == 1) {
            img = new ImageIcon("newI.jpg");
        } else {
            img = new ImageIcon("cross.png");
        }
        this.view = vie;
        this.control = con;
    }

    TTModel() {
    }

    void checkMove(int pl, int x, int y, tictactoe v) {
        currentPlayer = pl;
        if (currentPlayer == 1) {
            img = new ImageIcon("newI.jpg");
        } else {
            img = new ImageIcon("cross.png");
        }
        v.buttons[x][y].setIcon(img);
        view=v;
       // haswon();
    }    
}
