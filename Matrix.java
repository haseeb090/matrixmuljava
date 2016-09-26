/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplab1;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Haseeb Khizar
 * only works a x a matrices,
 * where a is a 2
 */
public class Matrix {
    public int mat[][];
    private Scanner scan;
    public int x;
    public Matrix(int a){
        this.x = a;
        mat = new int[x][x];
    }
    public void populate(){
        scan = new Scanner(System.in);
        for(int i = 0; i<x;i++){
            for(int j = 0; j<x;j++){
                System.out.println("Please enter value " + i + j);
                mat[i][j]= scan.nextInt();               
            }
        }
    }
    
    public int[][] itermul(Matrix b){
        Matrix A = new Matrix(this.x);
        A.mat = this.mat;
        Matrix B = new Matrix(b.x);
        B.mat = b.mat;
        Matrix result = new Matrix(this.x);
        for(int i = 0; i<x;i++){
            for(int j = 0; j<x;j++){
               result.mat[i][j]= 0;               
            }
        }
        for(int i =0;i<x;i++){
            for(int j=0; j<x; j++){
                for(int k=0;k<x;k++){
                    result.mat[i][j] = result.mat[i][j] + (A.mat[i][k] * B.mat[k][j]);
                }
            }
        }
        
        return result.mat;
    }
    
    public int[][] strassenmul(Matrix b){
        Matrix A = new Matrix(this.x);
        A.mat = this.mat;
        Matrix B = new Matrix(b.x);
        B.mat = b.mat;
        Matrix result = new Matrix(this.x);
        for(int i = 0; i<x;i++){
            for(int j = 0; j<x;j++){
               result.mat[i][j]= 0;               
            }
        }
        int m1 = (A.mat[0][0] + A.mat[1][1]) * (B.mat[0][0] + B.mat[1][1]);
        int m2 = (A.mat[1][0] + A.mat[1][1]) * B.mat[0][0];
        int m3 = A.mat[0][0] * (B.mat[0][1] - B.mat[1][1]);
        int m4 = A.mat[1][1] * (B.mat[1][0] - B.mat[0][0]);
        int m5 = (A.mat[0][0] + A.mat[0][1])* B.mat[1][1];
        int m6 = (A.mat[1][0] - A.mat[0][0]) * (B.mat[0][0] + B.mat[0][1]);
        int m7 = (A.mat[0][1] - A.mat[1][1]) * (B.mat[1][0] + B.mat[1][1]);
        result.mat[0][0] = m1 + m4 - m5 +m7;
        result.mat[0][1] = m3 + m5;
        result.mat[1][0] = m2 + m4;
        result.mat[1][1] = m1 - m2 + m3 +m6;
        return result.mat;
    }
    
    public void print(){
        for(int i = 0; i<x;i++){
            for (int j=0; j<x;j++){
                System.out.print(this.mat[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
