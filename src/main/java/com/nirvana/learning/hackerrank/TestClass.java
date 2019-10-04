package com.nirvana.learning.hackerrank;

import javafx.util.Pair;

import java.io.*;

public class TestClass {
    public static void main(String[] args) throws FileNotFoundException {
        /*int Output=10;
        boolean b1= false;
        if((b1==true)&&((Output+=10)==20)){
            System.out.println("We are equal : "+Output);
        }else{
            System.out.println("Not Equal: "+Output);
        }*/

        MultiRun a = new MultiRun("Krishna");
        Pair p1= new Pair(1,2);
        /*Thread t = new Thread(a);*/
        a.start();
        /*t.start();*/

       /*File f = new File("testRandomFile.txt");
        FileOutputStream fileOutputStream= new FileOutputStream("textTexst.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile("fasf.txt","rw");
        try {
            boolean newFile = f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
