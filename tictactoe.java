/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class tictactoe extends javax.swing.JFrame {

    private TTController ttc;
    private TTModel ttm;
    JButton[][] buttons;
    int i = 0, j = 0;

    ;
    
    public tictactoe() {
        initComponents();

        setTitle("Muhammad Salman");
        setSize(500, 500);
        buttons = new JButton[3][3];

        this.setLayout(new GridLayout(3, 3));
        Clicklistener click = new Clicklistener();
        for (j = 0; j < 3; j++) {
            for (i = 0; i < 3; i++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(click);
                buttons[i][j].setEnabled(true);
                this.add(buttons[i][j]);
            }
        }
        ttc = new TTController(this, new TTModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tictactoe().setVisible(true);
            }
        });
    }

    public void endGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String soundName = "lose.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        clip.start();
        
        JOptionPane.showMessageDialog(rootPane, "GameOver-Try Again","Draw",JOptionPane.ERROR_MESSAGE);

        this.dispose();
    }

    public void gameOver(String arr) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        ImageIcon img1 = new ImageIcon("newI.jpg");
        ImageIcon img2 = new ImageIcon("cross.png");
        String soundName = "yay.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        if(arr=="Tick has won")
        {
            JOptionPane.showMessageDialog(rootPane, arr,"Player 1 has won",JOptionPane.INFORMATION_MESSAGE, img1);
        }
        else
            JOptionPane.showMessageDialog(rootPane, arr,"Player 2 has won",JOptionPane.INFORMATION_MESSAGE, img2);
        
        

        this.dispose();
    }

    class Clicklistener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (e.getSource() == buttons[k][l]) {
                        try {
                            ttc.hasClicked(k, l);
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(tictactoe.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(tictactoe.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(tictactoe.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
