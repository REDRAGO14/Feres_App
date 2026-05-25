package feres;
public class CargoRide extends feres.Vehicle {
    private double capacityInQuintals; // Unique attribute for freight hauling capacity

    public CargoRide(String plateNumber, String driverName, double ratePerKm, double capacityInQuintals) {
        super(plateNumber, driverName, ratePerKm);
        this.capacityInQuintals = capacityInQuintals;
    }

    @Override
    public double calculateFare(double kilometers) {
        // Cargo operations include a base heavy-handling loading fee of 150 ETB
        double baseLoadingFee = 150.0;
        return super.calculateFare(kilometers) + baseLoadingFee;
    }

    public double getCapacityInQuintals() { return capacityInQuintals; }
}