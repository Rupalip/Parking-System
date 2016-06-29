package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class SecurityPerson implements ParkingLotObserver {


  @Override
  public void update(ParkingLotEventTypes event) {
    redirectSecurityStaff();
  }

  public void updateParkingIsAvailable() {

  }

  private void redirectSecurityStaff() {

  }
}
