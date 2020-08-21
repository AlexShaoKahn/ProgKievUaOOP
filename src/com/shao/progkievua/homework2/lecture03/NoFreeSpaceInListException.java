package com.shao.progkievua.homework2.lecture03;

public class NoFreeSpaceInListException extends Exception {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";

    @Override
    public String getMessage() {
        return ANSI_RED + "ERROR: no free space in list" + ANSI_RESET;
    }

    @Override
    public String getLocalizedMessage() {
        return ANSI_RED + "ERROR: no free space in list" + ANSI_RESET;
    }
}
