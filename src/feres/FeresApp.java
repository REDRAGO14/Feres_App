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
        System.out.println("\n🎉 RIDE CONFIRMED!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Driver: " + vehicle.getDriverName());
        System.out.println("Payment: Cash on Arrival");
    }

    public void processBooking(Vehicle vehicle, String passengerName, String transactionId){
        System.out.println("\n🎉 RIDE CONFIRMED!");
        System.out.println("Passenger: " + passengerName);
        System.out.println("Driver: " + vehicle.getDriverName());
        System.out.println("Transaction ID: " + transactionId);
    }
}