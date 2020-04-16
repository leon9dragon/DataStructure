package com.leo9.dc03.round_queue_array;

public class RoundQueueArray {
    //定义队列数组的最大容量
    private int max_size;
    //定义队首指针
    private int front;
    //定义队尾指针
    private int rear;
    //定义队列本身, 用以存放数据模拟队列.
    private int[] arr;

    //创建队列的构造器
    public RoundQueueArray(int arr_max_size){
        max_size = arr_max_size;
        arr = new int[max_size];
        //front 和 rear 的初始值都为 0
        //front指向队列头部第一个元素本身
        front = 0;
        //rear指向队列尾部最后一个元素的后一个位置.
        rear = 0;
    }

    //判断队列是否占满
    public boolean isFull(){
        return (rear + 1) % max_size == front;
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
        //若队列仍未占满, 则可以加入数据
        //由于rear指向的就是尾部元素的下一位, 直接加入即可
        arr[rear] = data;
        //加入数据后rear再后移一位, 但要取模, 防止溢出
        rear = (rear + 1) % max_size;
    }

    //取出队列的数据, 数据出列
    public int getQueue(){
        //先判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("the queue is empty!");
        }
        //队列内有数据, 可以取出数据
        //由于front的指向就是当前队首的数据, 因此可以直接取出
        int data = arr[front];
        //取出后front向后移动一位, 取模防止溢出
        front = (front + 1) % max_size;
        return data;
    }

    //获取队列内有效数据的个数
    public int getNum(){ return (rear + max_size - front) % max_size; }

    //显示队列的所有数据, 实际是遍历数组, 且只输出有效数据
    public void showQueue(){
        //先判断非空
        if(isEmpty()){
            System.out.println("the queue is empty! no data in queue!");
            return;
        }
        System.out.println("the data in queue:");
        //有效数据的个数
        int num = getNum();
        //输出有效数据, 从当前的front指向元素开始输出
        for(int i = 0; i < num; i++){
            //成员的数组内编号, 要取模防止溢出
            int the_sign = (front + i) % max_size;
            System.out.printf("arr[%d]=%d\n", the_sign, arr[the_sign]);
        }

    }

    //显示队列的头数据, 并非取出数据
    public int headQueue(){
        //先判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("the queue is empty!");
        }
        return arr[front];
    }
}
