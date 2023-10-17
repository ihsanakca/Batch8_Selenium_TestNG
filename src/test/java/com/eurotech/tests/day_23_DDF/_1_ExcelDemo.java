package com.eurotech.tests.day_23_DDF;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class _1_ExcelDemo {

    public String readFromExcelCell(String path,String sheet,int row,int column) throws IOException {

        FileInputStream fis=new FileInputStream(path);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheet(sheet);
        String s = sheet1.getRow(row).getCell(column).getStringCellValue();
        return s;
    }


    @Test
    public void test1() throws IOException {

        System.out.println(readFromExcelCell("src/test/resources/LoginList.xlsx", "Test", 3, 1));
    }
}
