package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

public class MotorBike extends AbstractVehicle {
    
    /**
     * Base Fare for all MotorBikes.
     */
    public static final BigDecimal BIKE_FARE = BASE_FARE.multiply(new BigDecimal("2.00"));
    
    /**
     * Type of Bicycle.
     */
    private final boolean myMotorBikeType;
    
    /**
     * 
     * @param theVehicleID
     * @param theName
     * @param theVIN
     * @param theMotorBikeType
     */   
    public MotorBike(final int theVehicleID, final String theVIN, final String theName, final boolean theMotorBikeType) {
        super(theVehicleID, theVIN, theName);
        this.myMotorBikeType = theMotorBikeType;
        this.myRentalAmount = BIKE_FARE;
    }
    
    /**
     * Implement abstract un-implemented method to Calculate the rental Fare.
     * 
     * @return theRentalAmount
     */
    @Override
    public BigDecimal calculateRentalAmount() {
        final BigDecimal amount;
        
        if (this.myMotorBikeType) {
            amount = BIKE_FARE.add(new BigDecimal("5.00"));
        } else {
            amount = BIKE_FARE;
        }
        
        return amount;      
    }
    
    /**     
     * What is the BiCycle Type?
     * 
     * @return the BiCycle Type
     */
    public boolean getMyMotorBikeType() {
        return this.myMotorBikeType;
    }
    
    /**
     * Returns a String containing the variables : MotorBike (ID:myVehicleID, Name:myName, VIN:myVIN, CanRent?:myAvailabiility, IsTouring?:myMotorBikeType).
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
        sb.append("IsTouring?:");
        sb.append(this.myMotorBikeType);
        sb.append(")");
        
        return sb.toString();
    }
    
    /**
     * This method compares the myVehicleID, myName, myVIN, myAvailability, and myMotorBikeType to determine the equality of the MotorBike objects.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOtherMotorBike) {
        boolean result = true;
         
        if (this == theOtherMotorBike) {
            result = true;
        } else if (theOtherMotorBike == null) {
            result = false;
        } else if (this.getClass() != theOtherMotorBike.getClass()) {
            result = false;
        } else {
            final MotorBike otherObject = (MotorBike) theOtherMotorBike;
            result = this.getMyVehicleID() == otherObject.getMyVehicleID()
                             && this.getMyName().equals(otherObject.getMyName())
                             && this.getMyVIN().equals(otherObject.getMyVIN())
                             && this.getMyAvailability() == otherObject.getMyAvailability()
                             && this.myMotorBikeType == otherObject.getMyMotorBikeType();
        }
         
        return result;
    }
    
    /**
     * This method returns the hash code of the MotorBike object.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getMyVehicleID(), this.getMyName(), this.getMyVIN(), this.getMyAvailability(), myMotorBikeType);
    }
}
