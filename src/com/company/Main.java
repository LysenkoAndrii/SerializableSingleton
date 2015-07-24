package com.company;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.Serializable;


public class Main {
    private static File file = new File("singleton.ser");

    public static void main(String[] args) throws Exception {
        Singleton singleton = Singleton.getInstance();
        singleton.printData();
        Main.writeObject(singleton);
        singleton.setData("By the way, Java is awesome");
        singleton.printData();
        Main.readObject();
        singleton = null; // explicit "losing" of old object
        singleton = Singleton.getInstance(); //
        singleton.printData();
    }
    static void writeObject(Serializable ser) throws Exception {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(ser);
            System.out.println("Singleton is written");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readObject() {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file))) {
            stream.readObject();
            System.out.println("Singleton is read");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
