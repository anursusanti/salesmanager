package com.salesmanager.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReport {

    private List<JsonNode> employee;

    public String setReport() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        BufferedReader br = new BufferedReader(new FileReader("data/in/file.txt "));
        StringBuilder everything = new StringBuilder();
        String strLine;
        everything.append("[");
        everything.append("{");
        everything.append('"' + "Sale" + '"' + ":[");
        String looser = null;
        Integer custCount = 0;
        Integer salesmanCount = 0;
        float bigger = 0;
        float smaller = 0;
        float totalOld = 0;
        float smallerOld = 0;
        float[] totalArray = new float[0];
        while ((strLine = br.readLine()) != null) {
            if (strLine.contains("002")) {
                custCount++;
            }
            if (strLine.contains("001")) {
                salesmanCount++;
            }
            if (strLine.contains("003")) {
                if (strLine.contains("003")) {
                    String[] cArray = strLine.split("ç");
                    String[] cItemArray = cArray[2].split(",");
                    Integer i = 0;
                    float valueOld = 0;
                    float valueCur = 0;
                    float total = 0;
                    float totalCur = 0;
                    while (i < cItemArray.length) {
                        cItemArray[i] = cItemArray[i].replace("[", "");
                        cItemArray[i] = cItemArray[i].replace("]", "");
                        String[] cItemDetailArray = cItemArray[i].split("-");
                        cItemDetailArray[2] = String.valueOf(Float.parseFloat(cItemDetailArray[2]));
                        valueOld = total;
                        valueCur = Float.valueOf(cItemDetailArray[2]);
                        total = valueOld + valueCur;
                        i++;
                    }
                    everything.append("{");
                    everything.append('"' + "Id" + '"' + ":" + '"' + cArray[1] + '"' + ",");
                    everything.append('"' +"Total" + '"'  + ":" + '"' + total + '"');
                    everything.append("}");
                    everything.append(",");

                    if (totalOld > total) {
                        bigger = totalOld;
                        smallerOld = smaller;
                        smaller = total;
                    }
                    if (smallerOld < smaller & smallerOld != 0) {
                        smaller = smallerOld;
                    }
                    if (totalOld > total) {
                        totalOld = totalOld;
                    }else {totalOld = total;}
                    looser = cArray[3];
                }
            }
        }



        //everything.append("],");



        everything.append("}");
        int last = everything.lastIndexOf(",");
        if (last >= 0) { everything.delete(last, everything.length()); }
        everything.append("],");
        everything.append('"' + "Biggest sale" + '"'  + ":" + '"' + bigger + '"' + ",");
        everything.append('"' + "Smaller sale" + '"'  + ":" + '"' + smaller + '"' + ",");
        everything.append('"' + "Looser" + '"'  + ":" + '"' + looser + '"' + ",");
        everything.append('"' + "Customer Amount" + '"'  + ":" + '"' + custCount + '"' + ",");
        everything.append('"' + "Salesman Amount" + '"'  + ":" + '"' + salesmanCount + '"');
        everything.append("}");
        everything.append("]");




        BufferedWriter writer = new BufferedWriter(new FileWriter("data/out/file.txt"));
        writer.write("         REPORT        " + "\r\n");
        writer.write("-----------------------" + "\r\n");
        writer.write("The number of customer is: " + custCount + "\r\n");
        writer.write("The number of Salesman is: " + salesmanCount + "\r\n");
        writer.write("The biggest sale is: " + bigger + "\r\n");
        writer.write("The looser is: " + looser + "\r\n");
        writer.write("-----------------------" + "\r\n");
        writer.close();
        System.out.println("-----------------------");
        System.out.println("Request API Successful.");
        System.out.println("Access on Report End-point.");
        System.out.println("At " + dtf.format(now));
        return everything.toString();
    }

    public Object setReportJson(String salesman) throws IOException, JSONException {

        DataLoad dataLoad = new DataLoad();
        long sale = dataLoad.getSale().findValues("SalesmanName")
                .stream()
                .filter(p -> salesman.equals(p.asText())).count();
        return sale;
    }
    }

