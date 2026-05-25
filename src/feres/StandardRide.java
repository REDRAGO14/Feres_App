package feres;
public class StandardRide extends feres.Vehicle {
    private boolean isPremiumEconomy; // True if it's a newer car like a Suzuki Dzire

    public StandardRide(String plateNumber, String driverName, double ratePerKm, boolean isPremiumEconomy) {
        super(plateNumber, driverName, ratePerKm);
        this.isPremiumEconomy = isPremiumEconomy;
    }

    @Override
    public double calculateFare(double kilometers) {
        // Premium economy cars get a flat 20 ETB comfort charge added
        if (isPremiumEconomy) {
            return super.calculateFare(kilometers) + 20.0;
        }
        return super.calculateFare(kilometers);
    }
}