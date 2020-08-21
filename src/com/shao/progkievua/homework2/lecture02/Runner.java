package com.shao.progkievua.homework2.lecture02;

public class Runner {
    public static void main(String[] args) {
        Board board = new Board();
        Triangle triangle = new Triangle(
                new Point(0, 0),
                new Point(0, 5),
                new Point(5, 0));
        Rectangle rectangle1 = new Rectangle(
                new Point(0, 0),
                new Point(0, 5),
                new Point(5, 5),
                new Point(5, 0));
        Rectangle rectangle2 = new Rectangle(
                new Point(0, 0),
                new Point(0, 15),
                new Point(15, 15),
                new Point(15, 0));
        Hexagon hexagon = new Hexagon(
                new Point(0, 0),
                new Point(-2, 3),
                new Point(0, 6),
                new Point(5, 6),
                new Point(8, 3),
                new Point(5, 0));

        board.addShape(triangle, 1);
        board.addShape(rectangle1, 1);
        board.addShape(hexagon, 2);
        board.addShape(rectangle2, 3);
        System.out.println(board);

        board.removeShape(2);
        System.out.println(board);
    }

}
