package com.shao.progkievua.homework2.lecture02;

import java.io.Serializable;
import java.util.Arrays;

public class Board implements Serializable {
    private Shape[] boardParts;

    public Board() {
        boardParts = new Shape[4];
    }

    public void addShape(Shape shape, int boardPart) {
        boardParts[boardPart] = shape;
    }

    public void removeShape(int boardPart) {
        boardParts[boardPart] = null;
    }

    public Shape[] getBoardParts() {
        return boardParts;
    }

    public void setBoardParts(Shape[] boardParts) {
        this.boardParts = boardParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(boardParts, board.boardParts);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(boardParts);
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
