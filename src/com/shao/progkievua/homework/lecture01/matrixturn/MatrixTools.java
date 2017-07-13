package com.shao.progkievua.homework.lecture01.matrixturn;

import java.util.Random;

final class MatrixTools {
    private static Random random = new Random();

    private MatrixTools() {
    }

    static int[][] generateMatrix() {
        int[][] m = new int[random.nextInt(10) + 5][random.nextInt(10) + 5];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = random.nextInt(100);
            }
        }
        return m;
    }

    static String matrixToString(int[][] m) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            result.append("[");
            for (int j = 0; j < m[0].length; j++) {
                result.append(m[i][j] / 10 > 0 ? m[i][j] : "0" + m[i][j]);
                if (j != m[0].length - 1) result.append(", ");
            }
            result.append("]\n");
        }
        return result.toString();
    }

    static int[][] turnMatrix(int[][] m, int degree, Side side) {
        if (!isRightDegree(degree)) {
            System.out.println("90, 180 or 270 degrees only!");
            return null;
        }
        int[][] result = degree == 180 ? new int[m.length][m[0].length] : new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if ((side == Side.RIGHT && degree == 90) || (side == Side.LEFT && degree == 270))
                    result[j][result[0].length - 1 - i] = m[i][j];
                else if ((side == Side.LEFT && degree == 90) || (side == Side.RIGHT && degree == 270))
                    result[result.length - 1 - j][i] = m[i][j];
                else if (degree == 180) result[result.length - 1 - i][result[0].length - 1 - j] = m[i][j];
            }
        }
        return result;
    }

    private static boolean isRightDegree(int degree) {
        if (degree == 90 || degree == 180 || degree == 270) return true;
        else return false;
    }
}
