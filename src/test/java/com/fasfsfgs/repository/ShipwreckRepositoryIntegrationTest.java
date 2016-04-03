package com.fasfsfgs.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasfsfgs.App;
import com.fasfsfgs.model.Shipwreck;
import com.fasfsfgs.repository.ShipwreckRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class ShipwreckRepositoryIntegrationTest {

  @Autowired
  private ShipwreckRepository shipwreckRepository;

  @Test
  public void test() {
    List<Shipwreck> result = shipwreckRepository.findAll();
    assertThat(result.size(), is(greaterThanOrEqualTo(0)));
  }

}
