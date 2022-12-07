package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

public class BiCycle extends AbstractVehicle {

    /**
     * Base Fare for all BiCycles.
     */
    public static final BigDecimal CYCLE_FARE = BASE_FARE;
    
    /**
     * Type of Bicycle.
     */
    private final String myBicycleType;
    
    /**
     * 
     * @param theVehicleID
     * @param theName
     * @param theVIN
     * @param theBicycleType
     */   
    public BiCycle(final int theVehicleID, final String theVIN, final String theName, final String theBicycleType) {
        super(theVehicleID, theVIN, theName);
        this.myBicycleType = theBicycleType;
        this.myRentalAmount = CYCLE_FARE;
    }
    
    /**
     * Implement abstract un-implemented method to Calculate the rental Fare.
     * 
     * @return theRentalAmount
     */
    @Override
    public BigDecimal calculateRentalAmount() {
        final BigDecimal amount;
        
        if ("Road".equals(this.myBicycleType)) {
            amount = CYCLE_FARE;
        } else if ("mountain".equals(this.myBicycleType)) {
            amount = CYCLE_FARE.multiply(new BigDecimal("1.01"));
        } else if ("Cruiser".equals(this.myBicycleType)) {
            amount = CYCLE_FARE.multiply(new BigDecimal("1.02"));
        } else {
            amount = CYCLE_FARE.multiply(new BigDecimal("1.04"));
        }
        
        return amount;      
    }
    
    /**     
     * What is the BiCycle Type?
     * 
     * @return the BiCycle Type
     */
    public String getMyBiCycleType() {
        return this.myBicycleType;
    }
    
    /**
     * Returns a String containing the variables : BiCycle (ID:myVehicleID, Name:myName, VIN:myVIN, CanRent?:myAvailabiility, CycleType:myBiCycleType).
     * 
     * {@inheritDoc}
     */
    @Override 
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        
        final String comma = ", ";
        sb.append(" (ID:");
        sb.append(this.getMyVehicleID());
        sb.append(comma);
        sb.append("Name:");
        sb.append(this.getMyName());
        sb.append(comma);
        sb.append("VIN:");
        sb.append(this.getMyVIN());
        sb.append(comma);
        sb.append("CanRent?:");
        sb.append(this.getMyAvailability());
        sb.append(comma);
        sb.append("CycleType:");
        sb.append(myBicycleType);
        sb.append(")");
        
        return sb.toString();
    }
    
    /**
     * This method compares the myVehicleID, myName, myVIN, myAvailability, and myBiCycleType to determine the equality of the BiCycle objects.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOtherBiCycle) {
        boolean result = true;
         
        if (this == theOtherBiCycle) {
            result = true;
        } else if (theOtherBiCycle == null) {
            result = false;
        } else if (this.getClass() != theOtherBiCycle.getClass()) {
            result = false;
        } else {
            final BiCycle otherObject = (BiCycle) theOtherBiCycle;
            result = this.getMyVehicleID() == otherObject.getMyVehicleID()
                             && this.getMyName().equals(otherObject.getMyName())
                             && this.getMyVIN().equals(otherObject.getMyVIN())
                             && this.getMyAvailability() == otherObject.getMyAvailability()
                             && this.myBicycleType.equals(otherObject.getMyBiCycleType());
        }
         
        return result;
    }
    
    /**
     * This method returns the hash code of the BiCycle object.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getMyVehicleID(), this.getMyName(), this.getMyVIN(), this.getMyAvailability(), myBicycleType);
    }
    
    
}
