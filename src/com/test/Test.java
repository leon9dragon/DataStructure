package com.test;


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//实现类, 在泛型中指定类型
class Emp implements Comparable<Emp> {
    public String name;
    public int age;

    Emp(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //在比较方法中指定规则
    @Override
    public int compareTo(Emp o) {
        if (this.age > o.age) return 1;
        else if (this.age < o.age) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        //List<Emp> list = new ArrayList<>();
        Set<Emp> set = new TreeSet<>();
        ThreadLocalRandom curr = ThreadLocalRandom.current();
        int rad;
        for (int i = 5; i >= 0; i--) {
            rad = curr.nextInt(0, 100);
            set.add(new Emp("test" + rad, rad));
            //list.add(new Emp("test" + rad, rad));
        }
        //Collections.sort(list);
        //System.out.println(list);
        for (Emp emp : set) {
            System.out.println(emp);
        }
    }
}
