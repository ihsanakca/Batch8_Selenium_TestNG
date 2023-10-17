package com.eurotech.tests.day_23_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DataProviderDemo {

    @DataProvider
    public Object[][] testData_1(){
        String [][] notes={
                {"Hasan Sarı","70","100"},
                {"Veysel Candan","80","98"},
                {"Hanife Kara","90","95"},
                {"Burhan Eratlı","87","98"},
                {"Şule Aylin Atmaca","100","93"},
                {"Eylem Sönmez","89","97"}
        };
        return notes;
    }

    @Test(dataProvider = "testData_1")
    public void testNotes_1(String ad,String vize, String finalNot){
        System.out.println(ad+" "+vize+" "+finalNot);
    }

    @DataProvider (name = "OgrenciSinavNotlari")
    public Object[][] testData_2(){
        Object [][] notes={
                {"Hasan Sarı",70,100},
                {"Veysel Candan",80,98},
                {"Hanife Kara",90,95},
                {"Burhan Eratlı",87,98},
                {"Şule Aylin Atmaca",100,93},
                {"Eylem Sönmez",89,97}
        };
        return notes;
    }


    @Test(dataProvider = "OgrenciSinavNotlari")
    public void testNotes_2(String ad,int vize, int finalNot){
        System.out.println(ad+"--> Vize Notu= "+vize+" Final Notu= "+finalNot+" Yıl Sonu Notu= "+((vize*0.40)+(finalNot*0.60)));
    }
}
