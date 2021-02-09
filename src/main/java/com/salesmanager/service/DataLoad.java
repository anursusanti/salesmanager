package com.salesmanager.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.salesmanager.models.Employee;
import org.json.JSONException;

import javax.naming.Name;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataLoad {


    public JsonNode getEmployee() throws IOException, JSONException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        BufferedReader br = new BufferedReader(new FileReader("data/in/file.txt "));
        StringBuilder everything = new StringBuilder();
        String strLine;
        everything.append("[");
        while ((strLine = br.readLine()) != null)   {
            if (strLine.contains("001")) {
                String[] cArray = strLine.split("ç");
                everything.append("{");
                everything.append('"' + "Operator" + '"' + ":" + '"' + cArray[0] + '"' +  ",");
                everything.append('"' + "CPF" + '"' + ":" + '"' + cArray[1] + '"'  + ",");
                everything.append('"' + "Name" + '"' + ":" + '"' + cArray[2] + '"'  + ",");
                everything.append('"' + "Salary" + '"'+ ':' + '"' + cArray[3] + '"' );
                everything.append("}");
                everything.append(",");
            }
        }
        int last = everything.lastIndexOf(",");
        if (last >= 0) { everything.delete(last, everything.length()); }
        everything.append("]");
        System.out.println("-----------------------");
        System.out.println("Request API Successful.");
        System.out.println("Access on Employee End-point.");
        System.out.println("At " + dtf.format(now));

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser jsonParser = factory.createParser(String.valueOf(everything));
        JsonNode node = mapper.readTree(jsonParser);

        return node;
    }


        public JsonNode getCustomer() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        BufferedReader br = new BufferedReader(new FileReader("data/in/file.txt "));
        StringBuilder everything = new StringBuilder();
        String strLine;
        everything.append("[");
        while ((strLine = br.readLine()) != null)   {
            if (strLine.contains("002")) {
                String[] cArray = strLine.split("ç");
                everything.append("{");
                everything.append('"' + "Operator" + '"' + ":" + '"' + cArray[0] + '"' +  ",");
                everything.append('"' + "CNPJ" + '"' + ":" + '"' + cArray[1] + '"' +  ",");
                everything.append('"' + "Name" + '"' + ":" + '"' + cArray[2] + '"' +  ",");
                everything.append('"' + "BusinessArea" + '"' + ":" + '"'  + cArray[3] + '"');
                everything.append("}");
                everything.append(",");
            }
        }
        int last = everything.lastIndexOf(",");
        if (last >= 0) { everything.delete(last, everything.length()); }
        everything.append("]");
        System.out.println("-----------------------");
        System.out.println("Request API Successful.");
        System.out.println("Access on Customer End-point.");
        System.out.println("At " + dtf.format(now));

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser jsonParser = factory.createParser(String.valueOf(everything));
            JsonNode node = mapper.readTree(jsonParser);

        return node;
    }

    public JsonNode getSale() throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        BufferedReader br = new BufferedReader(new FileReader("data/in/file.txt "));
        StringBuilder everything = new StringBuilder();
        String strLine;
        everything.append("[");
        everything.append("{");
        everything.append('"' + "Sale" + '"' + ":[");

        while ((strLine = br.readLine()) != null)   {
            if (strLine.contains("003")) {
                String[] cArray = strLine.split("ç");
                everything.append("{");
                everything.append('"' + "Operator" + '"' + ":" + '"' + cArray[0] + '"' +  ",");
                everything.append('"' + "SaleId" + '"' + ":" + '"' + cArray[1] + '"' +  ",");
                everything.append('"' + "SaleItems" + '"' + ":" + "[");
                String[] cItemArray = cArray[2].split(",");
                Integer i = 0;
                while(i < cItemArray.length) {
                    //cItemArray[i] = cItemArray[i].replace("[","");
                    //cItemArray[i] = cItemArray[i].replace("]","");

                    String[] cItemDetailArray = cItemArray[i].split("-");
                    everything.append("{");
                    cItemDetailArray[0] = cItemDetailArray[0].replace("[","");
                    everything.append('"' + "ItemId" + '"' + ":" + '"' + cItemDetailArray[0] + '"' +  ",");
                    everything.append('"' + "ItemQuantity" + '"' + ":" + '"' + cItemDetailArray[1] + '"' +  ",");
                    cItemDetailArray[2] = cItemDetailArray[2].replace("]","");
                    everything.append('"' + "ItemPrice" + '"' + ":" + '"' + cItemDetailArray[2] + '"');
                    everything.append("}");
                    everything.append(",");
                    i++;
                }
                int last = everything.lastIndexOf(",");
                if (last >= 0) { everything.delete(last, everything.length()); }
                everything.append("],");
                everything.append('"' + "SalesmanName"  + '"' + ":" + '"' + cArray[3] + '"');
                everything.append("}");
                everything.append(",");

            }

        }

        int last = everything.lastIndexOf(",");
        if (last >= 0) { everything.delete(last, everything.length()); }
        everything.append("]");
        everything.append("}");
        everything.append("]");
        System.out.println("-----------------------");
        System.out.println("Request API Successful.");
        System.out.println("Access on Sales End-point.");
        System.out.println("At " + dtf.format(now));

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser jsonParser = factory.createParser(String.valueOf(everything));
        JsonNode node = mapper.readTree(jsonParser);

        return node;
    }


}
