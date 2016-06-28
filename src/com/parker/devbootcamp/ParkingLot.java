package com.parker.devbootcamp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingLot {

  private List<ParkingSlot> issuedParkingSlots;
  private List<ParkingLotObserver> parkingLotObservers;
  private int noOfSlot1;
  private final int noOfSlots;


  public boolean addObserver(ParkingLotObserver parkingLotObserver) {
    return parkingLotObservers.add(parkingLotObserver);
  }

  public boolean removeObserver(ParkingLotObserver parkingLotObserver) {
    return parkingLotObservers.remove(parkingLotObserver);
  }

  public ParkingLot(int noOfSlots) {
    this.noOfSlots = noOfSlots;
    issuedParkingSlots = new ArrayList<>();
    parkingLotObservers = new ArrayList<>();
  }

  public ParkingToken park() {
    if (!isSlotsAvailable())
      throw new ParkingLotUnavailableException("Parking lot is full");
    else {
      ParkingSlot assignedParkingSlot = new ParkingSlot("P123");
      issuedParkingSlots.add(assignedParkingSlot);
      if (!isSlotsAvailable())
        notifyAllObservers();
      return new ParkingToken("s12345", System.currentTimeMillis(), assignedParkingSlot);
    }

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

  public void notifyAllObservers() {
    for (ParkingLotObserver observer : parkingLotObservers) {
      observer.updateParkingFull();
    }
  }
}
