package com.salesmanager.controllers;

import com.salesmanager.service.DataReport;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Configuration
@EnableScheduling
@RestController
@RequestMapping("/report")
public class ReportController {

  @RequestMapping(value="/findAll", method= RequestMethod.GET)
  //@Scheduled(fixedDelay = 5000)
  @ResponseBody
  String setReport() throws IOException{
    DataReport dataReport = new DataReport();
    return dataReport.setReport();
  }

}