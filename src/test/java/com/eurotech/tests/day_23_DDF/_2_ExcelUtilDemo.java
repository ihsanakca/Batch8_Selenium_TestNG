package com.eurotech.tests.day_23_DDF;


import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _2_ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */
        ExcelUtil excelData=new ExcelUtil("src/test/resources/LoginList.xlsx","Test");

        //satır sayısı
        System.out.println("excelData.rowCount() = " + excelData.rowCount());
    }

    @Test
    public void readExcelFile_2(){

        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData =new ExcelUtil(ConfigurationReader.get("excelPath"),"Test");

        //get column count - sütun sayısı alalım
        System.out.println("excelData.columnCount() = " + excelData.columnCount());

        //get all column names - sütun adlarını alalım
        System.out.println("getColumnsNames = " + excelData.getColumnsNames());

        //get all data to a list of map - bütün datayı alalım bir maplerden oluşan liste alalım
        List<Map<String, String>> dataList = excelData.getDataList();

        //ilk satır bilgilerini mape alalım (başlıklar hariç düzenlenmiş)
        System.out.println("dataList.get(0) = " + dataList.get(0));

        //dokuzuncu sıradaki şahsın bilgilerini alalım (index 0 dan başlıyor)
        System.out.println("dataList.get(8) = " + dataList.get(8));

        //dokuzuncu sıradaki şahsın email bilgisini alalım (Key/Value formatında keyler sütun adlarıdır.)
        System.out.println("dataList.get(8).get(\"City\") = " + dataList.get(8).get("City"));

        //bütün datayı iki boyutlu arraye alalım (Two dimensional array)
        String[][] dataArray = excelData.getDataArray();

        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        System.out.println("dataArray[0][0] = " + dataArray[0][0]);
        System.out.println("dataArray[9][2] = " + dataArray[9][2]);

        //bütün datayı iki boyutlu arraye alalım (Two dimensional array) Ama sütun başlıkları hariç
        String[][] dataArrayWithoutFirstRow = excelData.getDataArrayWithoutFirstRow();

        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));
        System.out.println("dataArrayWithoutFirstRow[8][2] = " + dataArrayWithoutFirstRow[8][2]);


    }
}
