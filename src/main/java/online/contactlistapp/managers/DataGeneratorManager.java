package online.contactlistapp.managers;

import com.github.javafaker.Faker;

public class DataGeneratorManager {
    private static Faker fakerObject = new Faker();

    public static  String getRandomEmail(){
        return fakerObject.internet().emailAddress();
    }

        public static String getRandomFirstName(){
            return fakerObject.internet().emailAddress();
        }

        public static String getRandomLastName(){
            return fakerObject.internet().emailAddress();
        }

        public static String getRandomPasword(int minLenght, int maxLenght){
        return fakerObject.internet().password(7, 10);
        }
    }


