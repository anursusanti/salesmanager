package com.salesmanager.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.salesmanager.service.DataLoad;
import org.json.JSONException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Configuration
@EnableScheduling
@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @RequestMapping(value="/findAll", method= RequestMethod.GET)
  //@Scheduled(fixedDelay = 5000)
  @ResponseBody
  JsonNode employeeFindAll() throws IOException, JSONException {
    DataLoad dataLoad = new DataLoad();
    return dataLoad.getEmployee();
  }
}