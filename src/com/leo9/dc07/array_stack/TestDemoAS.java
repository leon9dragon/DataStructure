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
        String expression = "4-6-2*2";

        //创建两个栈, 一个数栈一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //定义需要的相关变量, 索引, 操作数1和操作数2,
        //操作符接收字符, 运算结果, 临时操作符
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';

        //开始循环扫描表达式语句
        while (true){
            //依次获取expression中的每个字符, 每次从字符串中截取一位
            ch = expression.substring(index, index+1).charAt(0);
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
                        //令符号栈最多只有2个操作符, 防止出现减法/除法失误, 要先判断栈是否为空
                        //把当前操作符入符号栈, 入栈前先判断当前操作符优先级是否小于或者等于栈中的操作符
                        if(!operStack.isEmpty()){
                            if(operStack.priority(ch) <= operStack.priority(operStack.getTopData())){
                                num1 = numStack.popData();
                                num2 = numStack.popData();
                                oper = operStack.popData();
                                res = numStack.calculate(num1,num2,oper);
                                //把运算结果入数栈
                                numStack.pushData(res);
                            }
                        }
                        operStack.pushData(ch);
                    }
                    //如果当前的操作符的优先级大于栈中的操作符
                    else{
                        operStack.pushData(ch);
                    }
                }
                else{
                    //如果为空直接入栈
                    operStack.pushData(ch);
                }
            }
            else{
                //如果是数字,则直接入数栈
                //数字对应ASCII码和实际码数相差48
                //比如1这个字符对应ASCII码为49, 因此需要减48
                numStack.pushData(ch - 48);

                //当处理多位数时, 不能立即入栈, 要先判断后一位是否为符号再决定入栈
                int temp = 0;
                while(true){
                    temp++;
                    char ch2 = expression.substring(index + temp, index + temp + 1).charAt(0);
                    if(!operStack.isOper(ch2)){
                        ch += ch2;
                    }
                }

                

            }
            //让index+1,并判断是否扫描到expression最后
            index++;
            //当扫描到表达式最后一位的后一位, 即为空的时候, 跳出循环
            if(index >= expression.length()){
                break;
            }
        }

        //表达式扫描完毕,顺序的从数栈和符号栈中出栈相应的数和符号, 并运行
        while(true){
            //若符号栈为空, 则计算到最后的结果
            //此时数栈只剩一个数字, 即为最终结果
            if(operStack.isEmpty()){
                break;
            }
            //开始计算
            num1 = numStack.popData();
            num2 = numStack.popData();
            oper = operStack.popData();
            res = numStack.calculate(num1,num2,oper);
            //把运算结果入数栈
            numStack.pushData(res);
        }

        //循环结束后数栈只剩结果, 进行输出
        System.out.println("=======result of calculate==========");
        System.out.println(expression + " = " + numStack.popData());

        //endregion
    }
}
