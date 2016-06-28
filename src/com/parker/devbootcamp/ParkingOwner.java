package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingOwner implements ParkingLotObserver {


  private void displayParkinfFull(){
      System.out.println("Parking is full");
  }

  @Override
  public void updateParkingFull() {
    displayParkinfFull();
  }
}
