package feres;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        feres.FeresApp feresSystem = new FeresApp();
        Scanner scanner = new Scanner(System.in);

        feresSystem.registerVehicle(new StandardRide("AA-C23456", "Henok", 20, false));
        feresSystem.registerVehicle(new CargoRide("AA-B35321", "Biruk", 30, 150));

        boolean running = true;
        while (running) {
            try {
                System.out.println("\n==================================");
                System.out.println("   ** FERES TERMINAL ** ");
                System.out.println("==================================");
                System.out.println("1. Register as a Driver");
                System.out.println("2. View All Online Drivers");
                System.out.println("3. Book a Trip");
                System.out.println("4. Exit");

                System.out.print("Please Enter Your Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("\n--- DRIVER REGISTRATION ---");
                    System.out.print("Enter Driver Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Plate Number: ");
                    String plate = scanner.nextLine();

                    System.out.print("Set Rate per KM (ETB): ");
                    double rate = scanner.nextDouble();

                    System.out.print("Select Your Category: 1. Standard Ride 2. Cargo Ride: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Is it a Premium car? (true/false): ");
                        boolean isPremium = scanner.nextBoolean();
                        feresSystem.registerVehicle(new StandardRide(plate, name, rate, isPremium));
                    } else if (type == 2) {
                        System.out.print("Enter Weight Capacity (Quintals): ");
                        double capacity = scanner.nextDouble();
                        feresSystem.registerVehicle(new CargoRide(plate, name, rate, capacity));
                    }
                    System.out.println("[SUCCESS] Driver registered successfully!");

                } else if (choice == 2) {
                    ArrayList<Vehicle> drivers = feresSystem.getActiveDrivers();
                    if (drivers.isEmpty()) {
                        System.out.println("No available drivers online.");
                    } else {
                        System.out.println("\n--- AVAILABLE DRIVERS ---");
                        int i = 0;
                        for (Vehicle v : drivers) {
                            String type = (v instanceof StandardRide) ? "Passenger Car" : "Cargo Truck";
                            System.out.println("[" + i + "] " + v.getDriverName() +
                                    " | Plate: " + v.getPlateNumber() +
                                    " | Rate: " + v.getRatePerKm() + " ETB/km" +
                                    " | Type: " + type);
                            i++;
                        }
                    }

                } else if (choice == 3) {
                    ArrayList<Vehicle> allDrivers = feresSystem.getActiveDrivers();
                    if (allDrivers.isEmpty()) {
                        System.out.println("No drivers available to book!");
                    } else {
                        System.out.print("Enter your name: ");
                        String passengerName = scanner.nextLine();

                        System.out.println("\nSelect Service Category:");
                        System.out.println("1. Standard Passenger Car");
                        System.out.println("2. Cargo / Delivery Truck");
                        System.out.print("Choice: ");
                        int categoryChoice = scanner.nextInt();

                        System.out.print("Enter Estimated trip distance (KM): ");
                        double km = scanner.nextDouble();

                        ArrayList<Vehicle> filteredList = new ArrayList<>();
                        System.out.println("\n--- AVAILABLE " + (categoryChoice == 1 ? "CARS" : "TRUCKS") + " ---");
                        int displayIndex = 0;
                        for (Vehicle v : allDrivers) {
                            if ((categoryChoice == 1 && v instanceof StandardRide) || (categoryChoice == 2 && v instanceof CargoRide)) {
                                filteredList.add(v);
                                double waga = v.calculateFare(km);
                                System.out.printf("[%d] %s | Waga: %.2f ETB\n", displayIndex, v.getDriverName(), waga);
                                displayIndex++;
                            }
                        }

                        if (filteredList.isEmpty()) {
                            System.out.println("Sorry, no vehicles available in this category.");
                        } else {
                            System.out.print("Select Driver index to Book: ");
                            int selection = scanner.nextInt();

                            if (selection >= 0 && selection < filteredList.size()) {
                                Vehicle selectedVehicle = filteredList.get(selection);
                                System.out.print("Is this a group ride? (1: Yes, 2: No): ");
                                int groupChoice = scanner.nextInt();

                                if (groupChoice == 1) {
                                    System.out.print("Passenger count: ");
                                    int count = scanner.nextInt();
                                    feresSystem.processBooking(selectedVehicle, passengerName, count);
                                } else {
                                    feresSystem.processBooking(selectedVehicle, passengerName);
                                }
                            } else {
                                System.out.println("Error: Driver index out of range.");
                            }
                        }
                    }

                } else if (choice == 4) {
                    System.out.println("Thank you for using Feres :)");
                    running = false;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[!] ERROR: Invalid input type. Please enter numbers where required.");
                scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("\n[!] ERROR: That driver index does not exist.");
            }
        }
        scanner.close();
    }
}