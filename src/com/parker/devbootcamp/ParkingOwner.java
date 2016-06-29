package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingOwner implements ParkingLotObserver {


  private void displayParkinfFull() {
    System.out.println("Parking is full");
  }

  @Override
  public void update(ParkingLotEventTypes event) {
    switch (event) {
      case PARKING_AVAILABLE:
        displayParkinfFull();
        break;
      case PARKING_FULL:
        updateParkingIsAvailable();
        break;

    }

  }

  private void updateParkingIsAvailable() {
  }
}
