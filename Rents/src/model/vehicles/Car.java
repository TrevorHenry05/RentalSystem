package model.vehicles;

import java.math.BigDecimal;
import java.util.Objects;

public class Car extends AbstractVehicle {

    /**
     * Base Fare for all Cars.
     */
    public static final BigDecimal CAR_FARE = BASE_FARE.multiply(new BigDecimal("3.00"));
    
    /**
     * Car is luxury or not.
     */
    private final boolean myCarLuxury;
    
    /**
     * Car has navigation or not.
     */
    private final boolean myCarNavigation;
    
    /**
     * Car has driving assistance or not.
     */
    private final boolean myCarDrivingAssistance;
    
    /**
     * 
     * @param theVehicleID
     * @param theName
     * @param theVIN
     * @param theCarLuxury
     * @param theCarNavigation
     * @param theCarDrivingAssistance
     */   
    public Car(final int theVehicleID, final String theVIN, final String theName, final boolean theCarLuxury, final boolean theCarNavigation, final boolean theCarDrivingAssistance) {
        super(theVehicleID, theVIN, theName);
        this.myCarLuxury = theCarLuxury;
        this.myCarNavigation = theCarNavigation;
        this.myCarDrivingAssistance = theCarDrivingAssistance;
        this.myRentalAmount = CAR_FARE;
    }
    
    /**
     * Implement abstract un-implemented method to Calculate the rental Fare.
     * 
     * @return theRentalAmount
     */
    @Override
    public BigDecimal calculateRentalAmount() {
        BigDecimal amount = CAR_FARE;
        
        if (this.myCarLuxury) {
            amount = amount.add(new BigDecimal("10.00"));
        }
        
        if (this.myCarNavigation) {
            amount = amount.add(new BigDecimal("1.00"));
        }
        
        if (this.myCarDrivingAssistance) {
            amount = amount.add(new BigDecimal("2.00"));
        }
        
        return amount;      
    }
    
    /**     
     * Does the car have Luxury?
     * 
     * @return luxury
     */
    public boolean getMyCarLuxury() {
        return this.myCarLuxury;
    }
    
    /**     
     * Does the car have Navigation?
     * 
     * @return Navigation
     */
    public boolean getMyCarNavigation() {
        return this.myCarNavigation;
    }
    
    /**     
     * Does the car have driving assistance?
     * 
     * @return Driving Assistance
     */
    public boolean getMyCarDrivingAssistance() {
        return this.myCarDrivingAssistance;
    }
    
    /**
     * Returns a String containing the variables : Car (ID:myVehicleID, Name:myName, VIN:myVIN, CanRent?:myAvailabiility, IsLuxury?:myCarLuxury, HasNavigation?:myCarNavigation, HasDrivingAssistance?:myCarDrivingAssitance).
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
        sb.append("IsLuxury?:");
        sb.append(this.myCarLuxury);
        sb.append(comma);
        sb.append("HasNavigation?:");
        sb.append(this.myCarNavigation);
        sb.append(comma);
        sb.append("HasAssistance?:");
        sb.append(this.myCarDrivingAssistance);
        sb.append(")");
        
        return sb.toString();
    }
    
    /**
     * This method compares the myVehicleID, myName, myVIN, myAvailability, myCarLuxury, myCarNavigation, and myCarDrivingAssistance to determine the equality of the Car objects.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object theOtherCar) {
        boolean result = true;
         
        if (this == theOtherCar) {
            result = true;
        } else if (theOtherCar == null) {
            result = false;
        } else if (this.getClass() != theOtherCar.getClass()) {
            result = false;
        } else {
            final Car otherObject = (Car) theOtherCar;
            result = this.getMyVehicleID() == otherObject.getMyVehicleID()
                             && this.getMyName().equals(otherObject.getMyName())
                             && this.getMyVIN().equals(otherObject.getMyVIN())
                             && this.getMyAvailability() == otherObject.getMyAvailability()
                             && this.myCarLuxury == otherObject.getMyCarLuxury()
                             && this.myCarNavigation == otherObject.getMyCarNavigation()
                             && this.myCarDrivingAssistance == otherObject.getMyCarDrivingAssistance();
        }
         
        return result;
    }
    
    /**
     * This method returns the hash code of the Car object.
     * 
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getMyVehicleID(), this.getMyName(), this.getMyVIN(), this.getMyAvailability(), myCarLuxury, myCarNavigation, myCarDrivingAssistance);
    }
    
}
