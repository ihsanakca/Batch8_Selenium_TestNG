package com.eurotech.tests.day_24_miscellaneous;

import org.testng.annotations.Test;

public class _03_getEnv_Method {
    @Test
    public void getEnvTest(){
        /**
         * environment variables'da bulunan değişkenlere erişmek için kullanılır.
         */
        String pass = System.getenv("Password");
        System.out.println("pass = " + pass);
    }
}
