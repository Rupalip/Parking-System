package com.parker.devbootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingLot {

  private List<ParkingSlot> issuedParkingSlots;
  private final int noOfSlots;

  public ParkingLot(int noOfSlots) {
    this.noOfSlots = noOfSlots;
    issuedParkingSlots = new ArrayList<>();
  }

  public ParkingToken getNextAvailableSlot() {
    if (!isSlotsAvailable())
      throw new ParkingLotUnavailableException("Parking lot is full");
    ParkingSlot assignedParkingSlot = new ParkingSlot("P123");
    issuedParkingSlots.add(assignedParkingSlot);
    return new ParkingToken("s12345", System.currentTimeMillis(), assignedParkingSlot);
  }

  private boolean isSlotsAvailable() {
    return issuedParkingSlots.size() < noOfSlots;
  }

  public boolean unpark(ParkingToken token) {
    if (issuedParkingSlots.remove(token.getParkingSlot())) {
      return true;
    }
    return false;
  }
}
