package com.shao.progkievua.homework2.lecture01.vector3d;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Vector3D implements Serializable {
    private int x;
    private int y;
    private int z;

    public Vector3D() {
        this(new Random().nextInt(21) - 10, new Random().nextInt(21) - 10, new Random().nextInt(21) - 10);
    }

    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3D summ(Vector3D r1, Vector3D r2) {
        return new Vector3D(r1.x + r2.x, r1.y + r2.y, r1.z + r2.z);
    }

    public static int scalar(Vector3D r1, Vector3D r2) {
        return r1.x + r2.x + r1.y * r2.y + r1.z * r2.z;
    }

    public static Vector3D vector(Vector3D r1, Vector3D r2) {
        return new Vector3D(r1.y * r2.z - r1.z * r2.y, r1.z * r2.x - r1.x * r2.z, r1.x * r2.y - r1.y * r2.x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3D vector3D = (Vector3D) o;
        return x == vector3D.x &&
                y == vector3D.y &&
                z == vector3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
