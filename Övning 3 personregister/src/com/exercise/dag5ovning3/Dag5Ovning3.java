package com.exercise.dag5ovning3;

//Basic personregister som kan hantera tre personer genom att det finns -
//objekt för varje person (person1, person2, person3).
//Man ska kunna mata in Namn, ålder, adress och telefon.
//Det skall finnas en extra klass utöver main klassen som har hand om variabler och metoder
//
import java.util.Scanner;

public class Dag5Ovning3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Skriv in namn på person 1:");
        String namnPerson1 = scan.nextLine();
        System.out.println("Skriv in ålder på person 1:");
        String agePerson1 = scan.nextLine();
        System.out.println("Skriv in adress för person 1:");
        String adressPerson1 = scan.nextLine();
        System.out.println("Skriv in telefonnr för person 1:");
        String telefonPerson1 = scan.nextLine();

        System.out.println("Skriv in namn på person 2:");
        String namnPerson2 = scan.nextLine();
        System.out.println("Skriv in ålder på person 2:");
        String agePerson2 = scan.nextLine();
        System.out.println("Skriv in adress för person 2:");
        String adressPerson2 = scan.nextLine();
        System.out.println("Skriv in telefonnr för person 2:");
        String telefonPerson2 = scan.nextLine();

        System.out.println("Skriv in namn på person 3:");
        String namnPerson3 = scan.nextLine();
        System.out.println("Skriv in ålder på person 3:");
        String agePerson3 = scan.nextLine();
        System.out.println("Skriv in adress för person 3:");
        String adressPerson3 = scan.nextLine();
        System.out.println("Skriv in telefonnr för person 3:");
        String telefonPerson3 = scan.nextLine();

        Person person1 = new Person(namnPerson1,agePerson1,adressPerson1,telefonPerson1);
        Person person2 = new Person(namnPerson2,agePerson2,adressPerson2,telefonPerson2);
        Person person3 = new Person(namnPerson3,agePerson3,adressPerson3,telefonPerson3);


        System.out.println(person1.personInfo(namnPerson1,agePerson1,adressPerson1,telefonPerson1));
        System.out.println(person2.personInfo(namnPerson2,agePerson2,adressPerson2,telefonPerson2));
        System.out.println(person3.personInfo(namnPerson3,agePerson3,adressPerson3,telefonPerson3));

    }
}
