package com.leo9.dc07.array_stack;

public class TestDemoAS {
    public static void main(String[] args) {
        //region 测试栈操作
        /*
        ArrayStack stack = new ArrayStack(5);
        stack.showStack();
        for(int i = 0; i < 5; i++){
            stack.pushData(i);
        }
        System.out.println("=============show the stack=================");
        stack.showStack();

        System.out.println("===========pop data============");
        for(int i = 4; i >=0; i--){
            System.out.println("the data popped is: " + stack.popData());
        }
        stack.showStack();
        stack.popData();

         */
        //endregion

        //region 表达式的运算

        //定义一个表达式进行测试
        String expressoion = "3+2*6-2";

        //创建两个栈, 一个数栈一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //定义需要的相关变量, 索引, 操作数1和操作数2,
        //操作符接收字符, 运算结果, 临时操作符
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = ' ';
        int res = 0;
        char ch = ' ';

        //开始循环扫描表达式语句
        while (true){
            //依次获取expression中的每个字符, 每次从字符串中截取一位
            ch = expressoion.substring(index, index+1).charAt(0);
            //判断ch是什么,然后做相应的处理
            if(operStack.isOper(ch)){
                //如果是运算符
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    //如果符号栈有操作符, 就进行比较
                    //如果当前的操作符的优先级小于或者等于栈中的操作符
                    if(operStack.priority(ch) <= operStack.priority(operStack.getTopData())){
                        num1 = numStack.popData();
                        num2 = numStack.popData();
                        oper = operStack.popData();
                        res = numStack.calculate(num1,num2,oper);
                        //把运算结果入数栈
                        numStack.pushData(res);
                        //把当前操作符入符号栈
                        operStack.pushData(oper);
                    }
                }
                else{
                    //如果为空直接入栈
                }
            }
        }


        //endregion
    }
}
