package com.sang.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class GreetingController {
  // hello world
  @GetMapping("/hello")
  public String hello() {
    return "Hello world";
  }

  // bye world
  @GetMapping("/bye")
  public String bye() {
    return "Bye world11";
  }
}