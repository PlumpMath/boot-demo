package com.fasfsfgs.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasfsfgs.model.Shipwreck;
import com.fasfsfgs.repository.ShipwreckRepository;

@RunWith(MockitoJUnitRunner.class)
public class ShipwreckControllerTest {

  @InjectMocks
  private ShipwreckController shipwreckController;

  @Mock
  private ShipwreckRepository shipwreckRepository;

  @Test
  public void testShipwreckGet() {
    Shipwreck shipwreck = new Shipwreck();
    shipwreck.setId(1L);
    when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);

    Shipwreck result = shipwreckController.get(1L);

    verify(shipwreckRepository).findOne(1L);

    // assertEquals(1L, result.getId().longValue());
    assertThat(result.getId(), is(1L));
  }

}
