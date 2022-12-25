 package model.vehicles;

import java.math.BigDecimal;

public abstract class AbstractVehicle {
    
    /**
     * Base Fare for all vehicles.
     */
    public static final  BigDecimal BASE_FARE = new BigDecimal("10.00");
    /**
     * Rental amount for a vehicle.
     */
    protected BigDecimal myRentalAmount;
    /**
     * ID number for the vehicle.
     */
    private final int myVehicleID;
    /**
     * VIN number of the vehicle.
     */
    private final String myVIN;
    /**
     * The name of the vehicle.
     */
    private final String myName;    
    /**
     * The availability of the Vehicle.
     */
    private boolean myAvailability;
    
    /**
     * 
     * @param theVehicleID
     * @param theVIN
     * @param theName
     */   
    public AbstractVehicle(final int theVehicleID, final String theVIN, final String theName) {
        this.myVehicleID = theVehicleID;
        this.myVIN = theVIN;
        this.myName = theName;
        this.myRentalAmount = BASE_FARE;
        this.myAvailability = true;
    }

    /**     
     * What is the the rental amount?
     * 
     * @return the rental amount
     */
    public BigDecimal getMyRentalAmount() {
        return myRentalAmount;
    }

    /**     
     * What is the Vehicle ID?
     * 
     * @return the Vehicle ID
     */
    public int getMyVehicleID() {
        return myVehicleID;
    }

    /**     
     * What is the vehicle VIN?
     * 
     * @return the VIN
     */
    public String getMyVIN() {
        return myVIN;
    }

    /**     
     * What is the Name of the Vehicle?
     * 
     * @return the Vehicle Name
     */
    public String getMyName() {
        return myName;
    }

    /**     
     * What is the Vehicles availability?
     * 
     * @return the BiCycle Type
     */
    public boolean getMyAvailability() {
        return myAvailability;
    }


    /**     
     * Set the Vehicles rental Availability.
     * 
     * @param theAvailability
     */
    public void setMyAvailability(final boolean theAvailability) {
        this.myAvailability = theAvailability;
    }

    /**
     * abstract class method to calculate rental amount.
     * 
     * @return rental amount
     */
    public abstract BigDecimal calculateRentalAmount();
}
