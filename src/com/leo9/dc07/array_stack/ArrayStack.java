package com.leo9.dc07.array_stack;

/*
* 定义一个数组栈的类表示栈结构
* */
public class ArrayStack {
    //定义栈的最大大小
    private int maxSize;
    //定义一个数组, 模拟栈的结构, 数据存放于数组中
    private int[] stack;
    //定义栈顶指针, 初始值为 -1, 没有数据时就是 -1 表示没有数据
    private int top = -1;

    //定义构造器
    public ArrayStack(int maxSize){
        //定义数组的最大存储位
        this.maxSize = maxSize;
        //初始化数组
        stack = new int[maxSize];
    }

    //判断栈是否为满
    public Boolean isFull(){
        //当栈顶指针+1等于栈最大存储位时, 栈满
        return top + 1 == maxSize;
    }

    //判断栈是否为空
    public Boolean isEmpty(){
        //当栈顶指针变回-1的时候, 栈空
        return top == -1;
    }

    //数据入栈
    public void pushData(int data){
        //判断栈是否存满
        if(isFull()){
            System.out.println("the stack is full!");
            return;
        }

        //栈顶指针上移
        top++;
        //存入数据
        stack[top] = data;
    }

    //数据出栈
    public int popData(){
        //判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }

        //取得数据
        int val = stack[top];
        //指针下移
        top--;
        //返回数据
        return val;
    }

    //遍历栈
    public void showStack(){
        if(isEmpty()){
            System.out.println("the stack is empty!");
            return;
        }
        for(int i = 0; i <= top; i++){
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }

    //返回运算符优先级, 优先级由user决定, 用数字表示
    //数字越大优先级越高
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }
        else if(oper == '+' || oper == '-'){
            return 0;
        }
        else {
            //假定运算式只有四则运算符号,若出现四则运算符外的符号, 返回-1
            return -1;
        }
    }

    //判断是否为运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //运算方法
    public int calculate(int num1, int num2, int oper){
        //定义变量用于接收计算结果
        int res = 0;

        //判断操作符
        switch (oper){
            case '+':
                res = num2 + num1;
                break;
            case '-':
                //num2是后出栈的那一位
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //获取栈顶
    public int getTopData(){
        return stack[top];
    }
}

