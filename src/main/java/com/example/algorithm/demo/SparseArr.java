package com.example.algorithm.demo;

/**
 *  稀疏数组
 *  * @projectName demo
 *  * @title     SparseArr   
 *  * @package    com.example.demo.controller  
 *  * @author Administrator     
 *  * @date   2020/5/10 0010 星期日
 *  * @version V1.0.0
 *  
 */
public class SparseArr {


    public static void main(String[] args) {
        // 11 * 11 的棋盘 1 代表黑子 2代表蓝子
        int row = 11;
        int col = 11;
        int[][] chessArr = new int[row][col];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 2;

        for (int[] rows : chessArr) {
            for (int data : rows) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }

        // 获取不为的个数
        int sum = 0;
        for (int[] rows : chessArr) {
            for (int data : rows) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("不为0的数据个数：" + sum);

        // 稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = row;
        sparseArr[0][1] = col;
        sparseArr[0][2] = sum;

        // 将二维数组的不为0的值存放在稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        // 输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }

        // 将稀疏数组恢复成二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        // 恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.print(chessArr2[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
