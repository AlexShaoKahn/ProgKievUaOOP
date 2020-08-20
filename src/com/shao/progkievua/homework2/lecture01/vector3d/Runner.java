package com.shao.progkievua.homework2.lecture01.vector3d;

public class Runner {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D();
        Vector3D v2 = new Vector3D();

        System.out.println("Vector v1: " + v1);
        System.out.println("Vector v2: " + v2);
        System.out.println();
        System.out.println("Summ: " + Vector3D.summ(v1, v2));
        System.out.println("Scalar: " + Vector3D.scalar(v1, v2));
        System.out.println("Vector: " + Vector3D.vector(v1, v2));
    }
}
