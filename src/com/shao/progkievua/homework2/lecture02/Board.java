package com.shao.progkievua.homework2.lecture02;

import java.io.Serializable;

public class Board implements Serializable {
    private Shape[] boardParts = new Shape[4];

    public void addShape(Shape shape, int boardPart) {
        boardParts[boardPart] = shape;
    }

    public void removeShape(int boardPart) {
        boardParts[boardPart] = null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Board: ").append(System.lineSeparator());
        for (int i = 0; i < boardParts.length; i++) {
            result.append("Part ").append(i + 1).append(": ");
            if (boardParts[i] == null) result.append("No shape");
            else result.append(boardParts[i].toString());
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
