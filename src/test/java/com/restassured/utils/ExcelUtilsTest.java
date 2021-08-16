package com.restassured.utils;

public class ExcelUtilsTest {
    public static void main(String[] args) {
       String excelPath = "./src/test/java/com/restassured/dal/TestData.xlsx";
       String sheetName = "Sayfa1";
       ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
       excel.getRowCount();

       //2 satır, 3 sutunluk excel verilerini yazdırır
       for (int i=0; i<2; i++) {
           System.out.println("*********************************");
           for (int j = 0; j < 3; j++) {
               excel.getCellData(i,j);
           }
       }
    }
}
