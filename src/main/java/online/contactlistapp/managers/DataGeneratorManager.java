package online.contactlistapp.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {
    private static Faker fakerObject = new Faker();

    public static  String getRandomEmail(){
        return fakerObject.internet().emailAddress();
    }

        public static String getName(){
            return fakerObject.name().firstName();
        }

        public static String getLastName(){
        return fakerObject.name().lastName();
        }

        public static String getRandomPasword(int min, int max){
        return fakerObject.internet().password();
        }
    }


