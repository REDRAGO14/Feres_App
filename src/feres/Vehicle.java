package feres;

public class Vehicle {
    private String plateNumber;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String plateNumber, String driverName, double ratePerKm) {
        this.plateNumber = plateNumber;
        this.driverName = driverName;
        setRatePerKm(ratePerKm); // Use setter for validation
    }

    // Overridable method for Runtime Polymorphism
    public double calculateFare(double kilometers) {
        return kilometers * ratePerKm;
    }

    // Getters and Setters with basic validation encapsulation
    public String getPlateNumber() { return plateNumber; }
    public String getDriverName() { return driverName; }

    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm > 0) {
            this.ratePerKm = ratePerKm;
        } else {
            this.ratePerKm = 25.0; // Default fallback safety minimum rate
        }
    }
}