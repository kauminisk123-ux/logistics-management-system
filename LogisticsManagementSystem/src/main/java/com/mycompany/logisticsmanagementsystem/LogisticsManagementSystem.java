/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.logisticsmanagementsystem;

/**
 *
 * @author U S E R
 */
import java.util.Scanner;
public class LogisticsManagementSystem {

    public static void main(String[] args) {
        System.out.println("\t\t*-*-*-*-*-WELCOME TO LOGISTICS MANAGEMENT SYSTEM-*-*-*-*-*");
        
        Scanner scanner=new Scanner(System.in);
        
        int choice;
    
    do {
        showMainMenu();
        choice = getUserChoice(scanner);
        
        switch (choice) {
            case 1:
                cityManagement(scanner);
                break;
            case 2:
                System.out.println("Distance Management Selected");
                break;
            case 3:
                System.out.println("Delivery Request Selected");
                break;
            case 4:
                System.out.println("Reports Selected");
                break;
            case 5:
                System.out.println("Thank you for using our system!! Exiting.....");
                break;
            default:
                System.out.println("Invalid choice! Please try again.....");
        }
        
    } while (choice != 5);  
    
    
    System.out.println("Successfully Executed !!");
}
    
    public static void showMainMenu() {
        System.out.println("\n------- MAIN MENU -------");
        System.out.println("1. City Management");
        System.out.println("2. Distance Management");
        System.out.println("3. Delivery Request");
        System.out.println("4. Reports");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");
    }
    
    public static int getUserChoice(Scanner scanner){
        int choice= scanner.nextInt();
        return choice;
    
    }
}
    
    
    