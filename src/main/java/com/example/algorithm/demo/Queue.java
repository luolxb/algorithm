package com.example.algorithm.demo;

import java.util.Scanner;

/**
 *      当前demo存在问题,数组不可复用，建议使用环形队列
 *      队列先进先出
 *  * @projectName demo
 *  * @title     Queue   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2020/5/10 0010 星期日
 *  * @version V1.0.0
 *  
 */
public class Queue {

    public static void main(String[] args) {
        // 测试
        QueueArr queueArr = new QueueArr(3);
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


class QueueArr {
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
    public QueueArr(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // front = -1; 指向队列头部的前一个位置
        this.front = -1;
        // rear = -1; 指向队列尾部
        this.rear = -1;
    }

    /**
     * 队列是否满了
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
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
        front++;
        return arr[front];
    }

    /**
     * 展示队列数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("数据空，不能显示数据");
            return;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

    /**
     * 显示头数据，不是取数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("数据空没有数据");
            throw new RuntimeException("数据空没有数据");
        }
        return arr[front + 1];
    }
}
