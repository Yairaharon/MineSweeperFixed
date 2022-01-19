
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * MAIN
 *
 * @author YAIR
 */
public class Main_MIneSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length,width and bombs: ");
        MineSweeper board1 = new MineSweeper(sc.nextInt(), sc.nextInt(), sc.nextInt());
        board1.printArray();
        while (!board1.isGameover()){                         //בןליאן מקבלים עם איס 
        System.out.println("Enter location: ");       
        board1.open_empty_fields(sc.nextInt(), sc.nextInt());
        board1.printArray();
        }
         
    }
    
    
//recorsia
//static int sum = 0;
//    public static int rec(int n) {
//        
//
//        if (n == 0) {
//            return sum;
//        }
//        
//        sum+=n;
//         n--;
//         
//       return rec(n);
//        
//        
//
//    }

}
