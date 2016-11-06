package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        private Customer cus;
        private Contact con;
        public DataAdapter(Customer customer, Contact contact) {
            this.con = contact;
            this.cus = customer;
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (Map.Entry<String,String> entry : Solution.countries.entrySet()) {
                if (entry.getValue().equals(cus.getCountryName())) {
                    countryCode = entry.getKey();
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return cus.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return con.getName().split(",")[1].trim();
        }

        @Override
        public String getContactLastName() {
            return con.getName().split(",")[0];
        }

        @Override
        public String getDialString() {
            String dialString = "";
            dialString = "callto://" + con.getPhoneNumber().replaceAll("[()-]]","");
            return dialString;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}