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
    
    static String[] cities = new String[30];
    static int cityCount=0;
    static int[][] distances = new int[30][30];
    
    static String[] vehicleTypes = {"Van","Truck","Lorry"};
    static int[] capacities={1000,5000,10000};
    static int[] ratesPerKm={30,40,80};
    static int[] avgSpeeds={60,50,45};
    static int[] fuelEfficiency={12,6,4};
    
    static String[] deliverySource = new String[100];
    static String[] deliveryDestination = new String[100];
    static int[] deliveryWeights = new int[100];
    static int[] deliveryVehicles = new int[100];
    static double[] deliveryCosts = new double[100];
    static int deliveryCount = 0;
    

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
                distanceManagement(scanner);
                break;
            case 3:
                delieveryManagement(scanner);
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
                }           
                break;
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
                
        }
    }
}
    
    public static void distanceManagement(Scanner scanner){
        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                distances[i][j] = 0;
                
                
            }
        }
        
        while (true) {
            System.out.println("\n=== Distance Management ===");
            System.out.println("1. Add/Edit Distance");
            System.out.println("2. View Distance Table");
            System.out.println("3. Back to Main");
            System.out.print("Choose: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    if (cityCount < 2) {
                        System.out.println("Need at least 2 cities to set distances!");
                        break;
                    }
                    
                    System.out.println("Available cities:");
                    for(int i=0; i<cityCount; i++){
                        System.out.println((i + 1) + ". " + cities[i]);
                    
                    }
                    
                    System.out.print("Enter first city number: ");
                    int c1 = scanner.nextInt();
                    System.out.print("Enter second city number: ");
                    int c2 = scanner.nextInt();
                    
                    if (c1 == c2) {
                        distances[c1-1][c2-1] = 0;
                        System.out.println("Distance set to 0 (same city)");
                    } 
                    else {
                        System.out.print("Enter distance in km: ");
                        int distance = scanner.nextInt();
                        distances[c1-1][c2-1] = distance;
                        distances[c2-1][c1-1] = distance;
                        System.out.println("Distance set successfully!");
                    }
                    
                    break;
                  
                        
                    case 2:
    
                        if (cityCount == 0) {
                            System.out.println("No cities added yet!");
                            break;
                        }
    
                        System.out.println("\nDistance Table:");
                        System.out.print("From\\To\t");
                        for (int i = 0; i < cityCount; i++) {
                            System.out.print(cities[i] + "\t");
                        }
                        System.out.println();
    
                        for (int i = 0; i < cityCount; i++) {
                            System.out.print(cities[i] + "\t");
                            for (int j = 0; j < cityCount; j++) {
                                System.out.print(distances[i][j] + "km\t");
                            }
                        System.out.println();
                        }
                        break;
                        
                case 3:
                    System.out.println("Back to Main...");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    
            }
    }
}
    
    public static void vehicleManagement(Scanner scanner){
        
        while (true) {
            System.out.println("\n=== Vehicle Management ===");
            System.out.println("1. View Vehicle Types");
            System.out.println("2. Select the Vehicle Type: ");
            System.out.println("3. Back to Main");
            System.out.print("Choose: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    viewVehicleTypes();
                    break;
                
                case 2:
                    selectVehicle(scanner);
                    break;
                
                case 3:
                    System.out.println("Back to Main...");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    
                
             
            }
        
        }
    
    
    }
    
    public static void viewVehicleTypes() {
        System.out.println("\n=== VEHICLE TYPES ===");
        System.out.println("Type   Capacity(kg)  Rate/km  Speed(km/h)  Fuel(km/l)");
        System.out.println("----------------------------------------------------");
    
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-8s %-14d %-9d %-13d %-10d\n",
                vehicleTypes[i], capacities[i], ratesPerKm[i],avgSpeeds[i], fuelEfficiency[i]);
    }
}
    public static int selectVehicle(Scanner scanner) {
        viewVehicleTypes();
        
        System.out.print("\nSelect vehicle (1=Van, 2=Truck, 3=Lorry): ");
        int vehicleChoice = scanner.nextInt();
    
        if (vehicleChoice >= 1 && vehicleChoice <= 3) {
            System.out.println("Selected: " + vehicleTypes[vehicleChoice-1]);
            return vehicleChoice;
        } 
        else {
            System.out.println("Invalid vehicle selection!");
            return -1;
        }
    }
    
    
    public static void delieveryManagement(Scanner scanner){
        
        while (true) {
            System.out.println("\n=== Delievery Management ===");
            System.out.println("1. View Vehicle Types");
            System.out.println("2. Select the Vehicle Type: ");
            System.out.println("3. Back to Main");
            System.out.print("Choose: ");
        
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
                newDeliveryRequest(scanner);
                break;
            case 2:
                viewDeliveryHistory();
                break;
            case 3:
                System.out.println("Back to Main...");
                return;
            default:
                System.out.println("Invalid choice!");
            }
            
           
        
    
    
    
        }


    }
    
    public static void newDeliveryRequest(Scanner scanner){
        
        if(cityCount < 2){
            System.out.println("Need at least 2 cities for delievery!");
            return;
        
        
        }
        
        if(deliveryCount >= 100) {
        System.out.println("Delivery records full! Maximum 100 deliveries...");
        return;
        
        }
        
        
        
        System.out.println("\n=== NEW DELIVERY REQUEST ===");
    
    
        System.out.println("Available Cities:");
        for (int i = 0; i < cityCount; i++) {
            System.out.println((i + 1) + ". " + cities[i]);
        }
    
    
        System.out.print("Enter source city number: ");
        int sourceIndex = scanner.nextInt() - 1;
    
    
        System.out.print("Enter destination city number: ");
        int destIndex = scanner.nextInt() - 1;
    
    
        if (sourceIndex < 0 || sourceIndex >= cityCount || destIndex < 0 || destIndex >= cityCount) {
            System.out.println("Invalid city selection!");
            return;
        }
    
    
        if (sourceIndex == destIndex) {
            System.out.println("Source and destination cannot be the same!");
            return;
        }
    
    
        System.out.print("Enter package weight (kg): ");
        int weight = scanner.nextInt();
    
    
        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Van (Capacity: 1000kg, Rate: 30/km)");
        System.out.println("2. Truck (Capacity: 5000kg, Rate: 40/km)");
        System.out.println("3. Lorry (Capacity: 10000kg, Rate: 80/km)");
        System.out.print("Enter vehicle choice (1-3): ");
        int vehicleChoice = scanner.nextInt();
    
    
        if (vehicleChoice < 1 || vehicleChoice > 3) {
            System.out.println("Invalid vehicle choice!");
            return;
        }

    
    
        if (weight > capacities[vehicleChoice - 1]) {
            System.out.println("Weight exceeds vehicle capacity! Maximum: " + capacities[vehicleChoice - 1] + "kg");
            return;
        }
    
   
        deliverySource[deliveryCount] = cities[sourceIndex];
        deliveryDestination[deliveryCount] = cities[destIndex];
        deliveryWeights[deliveryCount] = weight;
        deliveryVehicles[deliveryCount] = vehicleChoice;
        deliveryCosts[deliveryCount] = 0; 
    
        deliveryCount++;
        System.out.println("Delivery request recorded successfully!");
        
    }
    
    
    public static void viewDeliveryHistory() {
    if (deliveryCount == 0) {
        System.out.println("No deliveries recorded yet!");
        return;
    }
    
    System.out.println("\n=== DELIVERY HISTORY ===");
    System.out.println("No.  From       To         Weight  Vehicle  Cost");
    System.out.println("------------------------------------------------");
    
    for (int i = 0; i < deliveryCount; i++) {
        System.out.printf("%-4d %-10s %-10s %-7d %-8s %-8.2f\n",
            i + 1,
            deliverySource[i],
            deliveryDestination[i],
            deliveryWeights[i],
            vehicleTypes[deliveryVehicles[i] - 1],
            deliveryCosts[i]
        );
    }
    
    System.out.println("Total deliveries: " + deliveryCount);
    }
    
    

        
    
    
    
    }


