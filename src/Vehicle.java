public class Vehicle {
    private String plateNumber;
    private String driverName;
    protected double startingFee;
    private double ratePerKm;

    public Vehicle(String plateNumber, String driverName, double ratePerKm){
        this.plateNumber = plateNumber;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.startingFee = 110;
    }

    public double calculateFee(double distance){
            return (distance * ratePerKm) + startingFee;
    }

    //getters
    String getPlateNumber(){
        return plateNumber;
    }
    String getDriverName(){
        return driverName;
    }
    double getRatePerKm(){
        return ratePerKm;
    }

    //setters

    public void setPlateNumber(String plateNumber){
        this.plateNumber = plateNumber;
    }
    public void setDriverName(String driverName){
        this.driverName = driverName;
    }
    public void setRatePerKm(double ratePerKm){
        //validation
        if(ratePerKm > 0){
            this.ratePerKm = ratePerKm;
        }else{
            this.ratePerKm = 100;
        }
    }
}
