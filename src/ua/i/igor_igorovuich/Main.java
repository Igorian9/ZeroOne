package ua.i.igor_igorovuich;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        OneCount oneCount = new OneCount(new File("input"), new File("output.txt"));
        oneCount.count();
    }
}
