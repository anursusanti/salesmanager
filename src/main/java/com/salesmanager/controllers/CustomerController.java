package com.salesmanager.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.salesmanager.service.DataLoad;
import org.json.JSONException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Configuration
@EnableScheduling
@RestController
@RequestMapping("/customer")
public class CustomerController {

  @RequestMapping(value="/findAll", method= RequestMethod.GET)
  //@Scheduled(fixedDelay = 5000)
  @ResponseBody
  JsonNode customerFindAll() throws IOException, JSONException {
    DataLoad dataLoad = new DataLoad();
    return dataLoad.getCustomer();
  }
}