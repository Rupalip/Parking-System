package com.parker.devbootcamp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by vohray on 6/28/16.
 */
public class ParkingLotTest {

  @Test
  public void shouldGetParkingSlotIfAvailable() {
    Car car = new Car("MH R 1012");
    ParkingLot prkLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, prkLot.getNextAvailableSlot());
  }

  @Test(expected = ParkingLotUnavailableException.class)
  public void shouldNotGetParkingSlotIfFull() {
    Car car = new Car("MH R 1012");
    ParkingLot prkLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, prkLot.getNextAvailableSlot());
    assertNull(prkLot.getNextAvailableSlot());

  }

  @Test
  public void shouldBeAbleToUnpark() {
    ParkingLot parkingLot = new ParkingLot(1);
    ParkingToken token = new ParkingToken("s12345", System.currentTimeMillis(), new ParkingSlot("P123"));
    assertEquals(token, parkingLot.getNextAvailableSlot());
    assertTrue(parkingLot.unpark(token));
  }

}
