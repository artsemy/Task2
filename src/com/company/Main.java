package com.company;

public class Main {

    public static void main(String[] args) {
        NoteBook book = new NoteBook();
        book.sortByTheme();
        book.print();
        book.close();
    }
}
