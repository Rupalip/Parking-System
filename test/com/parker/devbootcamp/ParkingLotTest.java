package com.parker.devbootcamp;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingLotTest {

  @Test
  public void shouldGetParkingSlotIfAvailable() {
    Car car = new Car("MH R 1012");
    ParkingLot prkLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, prkLot.park());
  }

  @Test(expected = ParkingLotUnavailableException.class)
  public void shouldNotGetParkingSlotIfFull() {
    Car car = new Car("MH R 1012");
    ParkingLot prkLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, prkLot.park());
    assertNull(prkLot.park());

  }

  @Test
  public void shouldBeAbleToUnpark() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, parkingLot.park());
    assertTrue(parkingLot.unpark(token));
  }

  @Test
  public void shouldNotifyObserversOnParkingFull() {
    ParkingLot parkingLot = new ParkingLot(1);

    ParkingOwner parkingOwner = mock(ParkingOwner.class);
    parkingLot.addObserver(parkingOwner);
    SecurityPerson securityPerson = mock(SecurityPerson.class);
    parkingLot.addObserver(securityPerson);

    parkingLot.park();

    verify(parkingOwner, times(1)).updateParkingFull();
    verify(securityPerson, times(1)).updateParkingFull();

  }

}
