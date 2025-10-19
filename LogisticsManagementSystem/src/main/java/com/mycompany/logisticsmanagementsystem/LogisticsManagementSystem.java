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
    
    
    public static void cityManagement(Scanner scanner) {
    String[] cities = new String[30];
    int cityCount = 0;
    
    while (true) {
        System.out.println("\n=== City Management ===");
        System.out.println("1. Add City");
        System.out.println("2. View Cities");
        System.out.println("3. Remove City");
        System.out.println("4. Rename City");
        System.out.println("5. Back to Main");
        System.out.print("Choose: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                while (true) {
                    System.out.println("Enter city name (type -1 to stop): ");
                    
                    String newCity = scanner.nextLine();
                    
                    if (newCity.equals("-1")) {
                        break;
                    }
                    
                    if (cityCount < 30) {
                        cities[cityCount] = newCity;
                        cityCount++;
                        System.out.println("Added: " + newCity);
                    }
                    else {
                        System.out.println(" Cannot add more cities.");
                        break;
                    }
                }   break;
            case 2:
                if (cityCount == 0) {
                    System.out.println("No cities added yet.");
                }
                else {
                    System.out.println("=== Cities List ===");
                    for (int i = 0; i < cityCount; i++) {
                        System.out.println((i+1) + ". " + cities[i]);
                    }
                }   
                break;
            
            case 3:
                if (cityCount == 0) {
                    System.out.println("No cities to remove!");
                } 
                
                else {
                    System.out.println("=== Cities List ===");
                    
                    for (int i = 0; i < cityCount; i++) {
                        System.out.println((i+1) + ". " + cities[i]);
                    }
                    
                    System.out.print("Enter city number to remove: ");
                    int removeChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (removeChoice >= 1 && removeChoice <= cityCount) {
                        String removedCity = cities[removeChoice - 1];
                        
                        
                        for (int i = removeChoice - 1; i < cityCount - 1; i++) {
                            cities[i] = cities[i + 1];
                        }
                        cityCount--;
                        System.out.println("Removed: " + removedCity);
                    }
                    else {
                        System.out.println("Invalid city number!");
                    }
                }           break;
            case 4:
                
                if (cityCount == 0) {
                    System.out.println("No cities to rename!");
                } 
                
                else {
                    System.out.println("=== Cities List ===");
                    for (int i = 0; i < cityCount; i++) {
                        System.out.println((i+1) + ". " + cities[i]);
                    }
                    
                    System.out.print("Enter city number to rename: ");
                    int renameChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    if (renameChoice >= 1 && renameChoice <= cityCount) {
                        
                        System.out.print("Enter new name for " + cities[renameChoice - 1] + ": ");
                        String newName = scanner.nextLine();
                        String oldName = cities[renameChoice - 1];
                        cities[renameChoice - 1] = newName;
                        System.out.println("Renamed '" + oldName + "' to '" + newName + "'");
                    } 
                    
                    else {
                        System.out.println("Invalid city number!");
                    }
                }          
                break;
            case 5:
                System.out.println("Back to the Main Menu...");
                
                return;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}
}
