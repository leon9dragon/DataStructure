package com.leo9.dc21.hash_table;

public class TestDemoHT {
    public static void main(String[] args) {
        EmpHashTable emp_table = new EmpHashTable(5);
        emp_table.add(new EmpNode(1,"leo"));
        emp_table.add(new EmpNode(6,"ken"));
        System.out.println("========show the hashtable===========");
        emp_table.viewList();
        System.out.println("============search the employer=================");
        emp_table.searchEmpById(6);
        emp_table.searchEmpById(7);
    }
}
