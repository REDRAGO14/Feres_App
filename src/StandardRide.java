public class StandardRide extends Vehicle {
    private boolean isPremiumEconomy;

    public StandardRide(String plateNumber, String driverName, double ratePerKm, boolean isPremiumEconomy){
        super(plateNumber,driverName, ratePerKm);
        this.isPremiumEconomy = isPremiumEconomy;
    }

    @Override
    public double calculateFee(double distance){
        if(isPremiumEconomy){
            return super.calculateFee(distance) + 50;
        }else {
            return super.calculateFee(distance);
        }
    }

}
