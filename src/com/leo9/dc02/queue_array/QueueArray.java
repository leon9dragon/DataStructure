package com.leo9.dc02.queue_array;
/**
 * 使用数组模拟队列编写一个QueueArray类
 * */
public class QueueArray {
    //定义队列数组的最大容量
    private int max_size;
    //定义队首指针
    private int front;
    //定义队尾指针
    private int rear;
    //定义队列本身, 用以存放数据模拟队列.
    private int[] arr;

    //创建队列的构造器
    public QueueArray(int arr_max_size){
        max_size = arr_max_size;
        arr = new int[max_size];
        //front指向队列头部, 但是是队列头的前一个位置,
        //就是第一个数据前面, 而非这个数据本身.
        this.front = -1;
        //rear指向队列尾部, 指向队列尾的数据, 就是队列最后一个数据本身.
        this.rear = -1;
    }

    //判断队列是否占满
    public boolean isFull(){
        return rear == max_size - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列, 数据入列
    public void addQueue(int data){
        //先判断队列是否占满
        if (isFull()){
            System.out.println("the queue is full!");
            return;
        }
        //队列还有位置则, 队尾后移一位, 再增加数据
        rear++;
        arr[rear] = data;
    }

    //取出队列的数据, 数据出列
    public int getQueue(){
        //先判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("the queue is empty!");
        }
        //队列内有数据, 队首后移一位, 再取出数据
        front ++;
        return arr[front];
    }

    //显示队列的所有数据, 实际是遍历数组
    public void showQueue(){
        //先判断非空
        if(isEmpty()){
            System.out.println("the queue is empty! no data in queue!");
            return;
        }
        System.out.println("the data in queue:");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据, 并非取出数据
    public int headQueue(){
        //先判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("the queue is empty!");
        }
        return arr[front+1];
    }
}
