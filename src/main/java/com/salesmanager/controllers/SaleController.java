package com.salesmanager.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.salesmanager.service.DataLoad;
import com.salesmanager.service.DataReport;
import org.json.JSONException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Configuration
@EnableScheduling
@RestController
@RequestMapping("/sale")
public class SaleController {

  @RequestMapping(value="/findAll", method= RequestMethod.GET)
  //@Scheduled(fixedDelay = 5000)
  @ResponseBody
  JsonNode employeeFindAll() throws IOException, JSONException {
    DataLoad dataLoad = new DataLoad();
    return dataLoad.getSale();
  }

  @RequestMapping(value="/saleBySalesman/{salesman}", method= RequestMethod.GET)
  @ResponseBody
  Object saleFindBySalesman(@PathVariable("salesman") String salesman) throws IOException, JSONException {
    DataReport dataReport = new DataReport();
    dataReport.setReportJson(salesman);
    return dataReport.setReportJson(salesman);
  }

}