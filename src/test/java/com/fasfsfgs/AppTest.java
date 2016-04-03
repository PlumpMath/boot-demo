package com.fasfsfgs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasfsfgs.controller.HomeController;

public class AppTest {

  @Test
  public void test() {
    HomeController homeController = new HomeController();
    String result = homeController.home();
    assertEquals("oi!", result);
  }

}
