package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesDataAnalyzer {


    // This method reads a file and adds each line of the file into the corresponding SalesRecord object
    public SalesRecord[] readFile(String fileName) {
        int countLines = 0;
        SalesRecord[] salesRecord = null;
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null){
                    countLines++;
                }
            salesRecord = new SalesRecord[countLines];
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            int index = 0;
            while((line = bufferedReader.readLine()) != null ){
                String[] split = line.split(",");
                String date = split[0];
                int customer_id = Integer.parseInt(split[1]);
                int product_category = Integer.parseInt(split[2]);
                String payment_method = split[3];
                double value = Double.parseDouble(split[4]);
                double time_on_site = Double.parseDouble(split[5]);
                int clicks_in_site = Integer.parseInt(split[6]);
                salesRecord[index] = new SalesRecord(date,customer_id,product_category,payment_method,value,time_on_site,clicks_in_site);
                index++;

            }


        }
        catch(FileNotFoundException e){

        }
        catch (IOException e){
            System.out.println( e);
            e.printStackTrace();
        }




        return salesRecord;
    }

    public static void main(String[] args) {
        SalesDataAnalyzer salesDataAnalyzer = new SalesDataAnalyzer();
        SalesRecord[] response = salesDataAnalyzer.readFile("src/main/resources/number_format_changed.csv");
        for(int i = 0;i< response.length;i++){
            System.out.println(response[i]);
        }
    }



}
