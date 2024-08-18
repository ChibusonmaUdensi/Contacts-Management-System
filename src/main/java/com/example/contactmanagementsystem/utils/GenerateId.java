package com.example.contactmanagementsystem.utils;
import java.util.Random;

public class GenerateId {

    public static Long generateId(Random random){

        return random.nextLong();
    }
    public  static  int generatePhoneBookId(Random random){
        return random.nextInt();
    }
}
