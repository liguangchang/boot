package com.jasmine.boot;

import java.util.ArrayList;
import java.util.Iterator;

public class TestCatch {
    static int s=1;
    public static void main(String[] args) {

        testBasic();
        System.err.println("----");
        testIterator();
    }
    public static  int testBasic(){
        int i = 1;
        try{
            i++;
            System.out.println("try block, i = "+i);
        }catch(Exception e){
            i ++;
            System.out.println("catch block i = "+i);
        }finally{
            i = 10;
            System.out.println("finally block i = "+i);
        }
        return i;
    }
    static void testIterator(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        Iterator<Integer> iterator = integers.iterator();
        iterator.forEachRemaining(s-> System.out.println(s));


        while (iterator.hasNext()){
             iterator.next();

        }
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.err.println(next);
        }
    }
}
