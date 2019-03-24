/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assign4;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class TTController {

    tictactoe view;
    TTModel model;
    int currentPlayer = 1;//1 for tick    2 for cross
    int[][] visited = new int[3][3];
    int check = 0;

    TTController(tictactoe t, TTModel m) {
        model = m;
        view = t;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = 0;
            }
        }
    }

    void hasClicked(int x, int y) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (visited[x][y] == 0) {
            if (currentPlayer == 1) {
                model.checkMove(currentPlayer, x, y, view);
                currentPlayer = 2;
                visited[x][y] = 1;
                check++;
                haswon();
                
                
            } else if (currentPlayer == 2) {
                model.checkMove(currentPlayer, x, y, view);
                currentPlayer = 1;
                visited[x][y] = 2;
                haswon();
                
            }
        }
    }

    void haswon() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        
        if (visited[0][0] == 1 && visited[0][1] == 1 && visited[0][2] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");

        } else if (visited[0][0] == 1 && visited[1][0] == 1 && visited[2][0] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[0][0] == 1 && visited[1][1] == 1 && visited[2][2] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[1][2] == 1 && visited[2][2] == 1 && visited[0][2] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[2][1] == 1 && visited[2][2] == 1 && visited[2][0] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[0][2] == 1 && visited[1][1] == 1 && visited[2][0] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[0][1] == 1 && visited[1][1] == 1 && visited[2][1] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        } else if (visited[1][0] == 1 && visited[1][1] == 1 && visited[1][2] == 1) {
            System.out.println("Tick won");
            view.gameOver("Tick has won");
        }
        else if (check==5)
            view.endGame();
        if (visited[0][0] == 2 && visited[0][1] == 2 && visited[0][2] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");

        } else if (visited[0][0] == 2 && visited[1][0] == 2 && visited[2][0] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[0][0] == 2 && visited[1][1] == 2 && visited[2][2] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[1][2] == 2 && visited[2][2] == 2 && visited[0][2] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[2][1] == 2 && visited[2][2] == 2 && visited[2][0] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[0][2] == 2 && visited[1][1] == 2 && visited[2][0] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[0][1] == 2 && visited[1][1] == 2 && visited[2][1] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        } else if (visited[1][0] == 2 && visited[1][1] == 2 && visited[1][2] == 2) {
            System.out.println("Cross won");
            view.gameOver("Cross has won");
        }

    }
}
