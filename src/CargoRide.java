public class CargoRide extends Vehicle {
    private double capacityInQuintals;

    public CargoRide(String plateNumber, String driverName, double ratePerKm, double capacityInQuintals){
        super(plateNumber, driverName, ratePerKm);
        this.capacityInQuintals = capacityInQuintals;
    }

    @Override
    public double calculateFee(double distance){
        double baseLoddingFee = 150;
        return suber.calculateFee(distance) + baseLoddingFee;
    }

    public double getCapacityInQuintals(){
        return capacityInQuintals;
    }
}
