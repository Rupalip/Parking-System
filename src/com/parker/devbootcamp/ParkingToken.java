package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingToken {
  private final String tokenNumber;

  private final long issuedTime;
  private final ParkingSlot parkingSlot;

  public ParkingToken(String tokenNumber, long issuedTime, ParkingSlot parkingSlot) {
    this.tokenNumber = tokenNumber;
    this.issuedTime = issuedTime;
    this.parkingSlot = parkingSlot;
  }

  public long getIssuedTime() {
    return issuedTime;
  }

  public String getTokenNumber() {
    return tokenNumber;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ParkingToken that = (ParkingToken) o;

    if (!tokenNumber.equals(that.tokenNumber)) return false;
    return parkingSlot.equals(that.parkingSlot);

  }

  @Override
  public int hashCode() {
    int result = tokenNumber.hashCode();
    result = 31 * result + parkingSlot.hashCode();
    return result;
  }

  public ParkingSlot getParkingSlot() {
    return parkingSlot;
  }
}
