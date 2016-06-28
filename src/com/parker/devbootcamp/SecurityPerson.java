package com.parker.devbootcamp;

/**
 * Created by vohray on 6/28/16.
 */
public class SecurityPerson implements ParkingLotObserver {


  @Override
  public void updateParkingFull() {
    redirectSecurityStaff();
  }

  private void redirectSecurityStaff() {

  }
}
