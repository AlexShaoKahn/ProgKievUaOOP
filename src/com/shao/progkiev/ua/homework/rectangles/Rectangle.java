package com.shao.progkiev.ua.homework.rectangles;

public class Rectangle {
    private int height;
    private int width;

    Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    private int getPerimeter() {
        return (height + width) * 2;
    }

    int getArea() {
        return height * width;
    }

    public String toString() {
        return "height: " + height + ", width: " + width + ", perimeter: " + getPerimeter() + ", area: " + getArea();
        /*
        return new StringBuilder()
                .append("height: ").append(height)
                .append(", width: ").append(width)
                .append(", perimeter: ").append(getPerimeter())
                .append(", area: ").append(getArea())
                .toString();
        */
    }
}
