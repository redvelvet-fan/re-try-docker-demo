package com.sang.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

//This Controller CRUD Linked Postgresql Database
//by call RestAPI

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class TableController {

  // get all table list
  @RequestMapping("/list")
  public void getTableList() {
    // get all the table list
    
  }
}
