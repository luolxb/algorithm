package com.example.algorithm.demo;

import java.util.Scanner;

/**
 *  
 *  * @projectName algorithm
 *  * @title     CircleArrayQueue   
 *  * @package    com.example.algorithm.demo  
 *  * @author Administrator     
 *  * @date   2020/5/18 0018 星期一
 *  * @version V1.0.0
 *  
 */
public class CircleArrayQueue {


    public static void main(String[] args) {
        // 测试
        CircleArray queueArr = new CircleArray(4);
        // 用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取数据");
            System.out.println("h(head): 查看头部数据");

            key = scanner.next().charAt(0);
            switch (key) {
                // 展示数据
                case 's':
                    queueArr.showQueue();
                    break;
                // 添加数据到队列
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queueArr.addQueue(value);
                    break;
                // 从队列取数据
                case 'g':
                    try {
                        int res = queueArr.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                // 查看头部数据
                case 'h':
                    try {
                        queueArr.headQueue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                // 显示队列
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出...");
    }
}


class CircleArray {
    /**
     * 数组最大容量
     */
    int maxSize;

    /**
     * 队列头
     */
    int front;

    /**
     * 队列尾
     */
    int rear;

    /**
     * 存放数据，模拟队列
     */
    int arr[];

    /**
     * 构造器
     *
     * @param maxSize
     */
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // front = 0; 指向队列头部的前一个位置
//        this.front = 0;
//        // rear =0; 指向队列尾部
//        this.rear = 0;
    }

    /**
     * 队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        // 尾部 + 1 % size = 头部
        return (rear + 1) % maxSize == front;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加到队列
     *
     * @return
     */
    public void addQueue(int n) {
        // 判断队列是否满了
        if (isFull()) {
            System.out.println("队列满了，不能加入数据");
            return;
        }
        // 将数据直接加入
        arr[rear] = n;
        // rear往后移动
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列数据 数据出队列
     */
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            System.out.println("队列空，不能取数据");
            throw new RuntimeException("队列空，不能取数据");
        }

        // front指向队列第一个元素
        // 1. 先把front 赋值给一个临时变量
        // 2. 将front 往后移动  考虑取模
        // 3. 将临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 展示队列数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("数据空，不能显示数据");
            return;
        }
        // 从 front 开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

        }
    }

    /**
     * 求出当前数组有效数字个数
     *
     * @return
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;

    }

    /**
     * 显示头数据，不是取数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("数据空没有数据");
            throw new RuntimeException("数据空没有数据");
        }
        return arr[front];
    }
}
