package com.eurotech.tests.day_01_automation_intro;


import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class _3_JavaFakerDemo {
    public static void main(String[] args) {
        //mock data üretmek için kullanılır... (sahte data)
        Faker faker = new Faker();

        //sahte bir isim üretelim
        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        //sahte bir şehir üretelim
        String city = "Yeni " + faker.address().city();
        System.out.println("city = " + city);

        //kredi kart no
        String creditCard = faker.finance().creditCard();
        System.out.println("creditCard = " + creditCard);

        //american express kredi kart no
        String creditCard2 = faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("creditCard2 = " + creditCard2);

        //visa kredi kart no
        String creditCard3 = faker.finance().creditCard(CreditCardType.VISA);
        System.out.println("creditCard3 = " + creditCard3);

        //şifre üretelim
        String password = faker.internet().password();
        System.out.println("password = " + password);

        //rakam harf vb içeren şifre üretelim...
        String password2 = faker.internet().password(8, 16, true, true, true);
        System.out.println("password2 = " + password2);

        //belli bir değerle başlayan şifre üretelim
        String password3 = "AB**23" + faker.internet().password();
        System.out.println("password3 = " + password3);

        faker.internet().password();
    }
}
