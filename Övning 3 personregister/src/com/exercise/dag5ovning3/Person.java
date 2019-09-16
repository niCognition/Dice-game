package com.exercise.dag5ovning3;

public class Person {
    private String namn;
    private String age;
    private String adress;
    private String telefon;


    public Person(String namn, String age, String adress, String telefon) {
        this.namn = namn;
        this.age = age;
        this.adress = adress;
        this.telefon = telefon;
    }

    public String getNamn(){
        return namn;
    }
    public String getAge(){
        return age;
    }
    public String getAdress(){
        return adress;
    }
    public String getTelefon(){
        return telefon;
    }

    public String personInfo(String namn, String age, String adress, String telefon){
        String text = "\nNamn: " + namn + "\nÅlder: " + age + " år" + "\nAdress: " + adress
                + "\nTelefonnr: " + telefon;
        return text;
    }

}