package feres;
import java.util.ArrayList;

public class FeresApp{
    private ArrayList<feres.Vehicle> activeDrivers;

    public FeresApp(){
        activeDrivers = new ArrayList<>();
    }

    public void registerVehicle(feres.Vehicle vehicle){
        activeDrivers.add(vehicle);
    }

    public ArrayList<feres.Vehicle> getActiveDrivers(){
        return activeDrivers;
    }

    public void processBooking(Vehicle vehicle, String passengerName){
        System.out.println("\n RIDE CONFIRMED!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Driver: " + vehicle.getDriverName());
        System.out.println("Car Plate: " + vehicle.getPlateNumber());
        System.out.println("Note: Single passenger trip");
    }

    public void processBooking(Vehicle vehicle, String passengerName, int passengerCount){
        System.out.println("\n RIDE CONFIRMED!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Driver Name: " + vehicle.getDriverName());
        System.out.println("Car Plate: " + vehicle.getPlateNumber());
        if (passengerCount > 4) {
            System.out.println("Note: Large group! Extra seating confirmed.");
        }
    }

}