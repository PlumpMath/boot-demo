package com.fasfsfgs.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasfsfgs.App;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class ShipwreckControllerWebTest {

  @Test
  public void testListAll() throws IOException {
    TestRestTemplate restTemplate = new TestRestTemplate();
    ResponseEntity<String> resp =
        restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);

    assertThat(resp.getStatusCode(), is(HttpStatus.OK));

    ObjectMapper mapper = new ObjectMapper();
    JsonNode respJson = mapper.readTree(resp.getBody());

    assertThat(respJson.isMissingNode(), is(false));
    assertThat(respJson.toString(), equalTo("[]"));
  }

}
