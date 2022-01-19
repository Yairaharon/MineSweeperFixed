
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * CLASS
 *
 * @author YAIR
 */
public class MineSweeper {

    private int count = 48;
    private boolean gameover = false;

    public boolean isGameover() {
        return gameover;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }
    private int numBombs;
    private int length;
    private int width;
    private char Array[][];
    Random rnd = new Random();

    public MineSweeper(int length, int width, int numBombs) {
        this.length = length;
        this.width = width;
        this.Array = new char[length][width];
        this.numBombs = numBombs;

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.Array[i][j] = '0';
            }

        }
        for (int i = 0; i < this.numBombs; i++) {
            this.Array[rnd.nextInt(this.length)][rnd.nextInt(this.width)] = '*';
        }
    }

    public void printArray() {
        if (this.gameover == false) {
            for (int i = 0; i < this.length; i++) {
                for (int j = 0; j < this.width; j++) {
//                if (this.Array[i][j] == 9) {
//                    System.out.print("0"+" ");
//                } else {
                    System.out.print((char) this.Array[i][j] + " ");
//                }
                }
                System.out.println(" ");
            }
        }
    }

    public void check_num_of_mine(int i, int j) {
        int row;
        int column;
        int tempi;
        int tempj;

        tempi = i - 1;
        tempj = j - 1;
        count = 48;
        row = i + 1;
        column = j + 1;
        if (this.Array[i][j] == '*') {
            System.out.println("BOOM!!! Game over!");
            gameover = true;
            return;
        }

        for (int k = tempi; k <= row; k++) {
            for (int l = tempj; l <= column; l++) {
                if (k >= 0 && k < this.length && l >= 0 && l < this.width) {     //THIS IF CHECK IF WE ARE IN THE ARRAY
                    if (this.Array[k][l] == '*') {
                        count++;

                    }

                }
            }
        }
        this.Array[i][j] = (char) count;    //count is 48 in int, but we doing a casting to char and is the char '0'
    }

    public void open_empty_fields(int locali, int localj) {
        check_num_of_mine(locali, localj);
        if (gameover == true) {
            return;
        }
        if (count == 48) {  //אם אין לפחות מוקש בשמינייה שעוטפת את המקום שלחצנו עליו
            this.Array[locali][localj] = '-';
            int row;
            int column;
            int tempi;
            int tempj;

            tempi = locali - 1;
            tempj = localj - 1;
            row = locali + 1;
            column = localj + 1;
            for (int k = tempi; k <= row; k++) {
                for (int l = tempj; l <= column; l++) {
                    if (k >= 0 && k < this.length && l >= 0 && l < this.width) {  //THIS IF CHECK IF WE ARE IN THE ARRAY
                        if ((k == locali) && (l == localj)) {                     //This IF check if we are in the place that the user has chosen
                            continue;
                        }
                        if (this.Array[k][l] == '-') {
                            continue;
                        }
                        if (this.Array[k][l] >= '1' && this.Array[k][l] <= '8') {
                            continue;
                        }

                        open_empty_fields(k, l);

                    }
                }
            }

        }

    }

}
