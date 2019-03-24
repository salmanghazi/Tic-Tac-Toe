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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

        setTitle("Tic Tac Toe");
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
        JOptionPane.showMessageDialog(rootPane, "GameOver-Try Again");

        this.dispose();
    }

    public void gameOver(String arr) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        String soundName = "yay.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        clip.start();
        JOptionPane.showMessageDialog(rootPane, arr);

        this.dispose();
    }

    class Clicklistener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    if (e.getSource() == buttons[k][l]) {
                        ttc.hasClicked(k, l);

                    }
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
