package com.company;


import java.io.Serializable;


/**
 * Created by admin on 24.07.2015.
 */
public class Singleton implements Serializable {
    private String data = "I love reading fiction";
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public void printData() { System.out.println("Data: " + data); }

    /*
     * Refreshes data, setting the old data value to a new one
     * @param   data    new data to store
     */
    public void setData(String data) {
        this.data = data;
        System.out.println("New data is set");
    }

    protected Object readResolve() {
        instance = this;
        return instance;
    }

    public static Singleton getInstance() { return instance; }
}
