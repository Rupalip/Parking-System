package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingSlot {
  private final String slotNumber;

  public ParkingSlot(String slotNumber) {

    this.slotNumber = slotNumber;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ParkingSlot that = (ParkingSlot) o;

    return slotNumber.equals(that.slotNumber);

  }

  @Override
  public int hashCode() {
    return slotNumber.hashCode();
  }

  public String getSlotNumber() {

    return slotNumber;
  }

}
