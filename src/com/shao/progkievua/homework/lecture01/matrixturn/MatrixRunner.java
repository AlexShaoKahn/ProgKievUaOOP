package com.shao.progkievua.homework.lecture01.matrixturn;

public class MatrixRunner {
    public static void main(String[] args) {
        int[][] matrix000 = MatrixTools.generateMatrix();
        int[][] matrix090l = MatrixTools.turnMatrix(matrix000, 90, Side.LEFT);
        int[][] matrix180l = MatrixTools.turnMatrix(matrix000, 180, Side.LEFT);
        int[][] matrix270l = MatrixTools.turnMatrix(matrix000, 270, Side.LEFT);

        System.out.println("Source matrix:");
        System.out.println(MatrixTools.matrixToString(matrix000));
        System.out.println("Counterclockwise by 90 degrees");
        System.out.println(MatrixTools.matrixToString(matrix090l));
        System.out.println("Counterclockwise by 180 degrees");
        System.out.println(MatrixTools.matrixToString(matrix180l));
        System.out.println("Counterclockwise by 270 degrees");
        System.out.println(MatrixTools.matrixToString(matrix270l));
    }
}
