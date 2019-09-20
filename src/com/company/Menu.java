package com.company;

import com.company.notes.NoteBook;

import java.util.Scanner;

public class Menu {

    private NoteBook noteBook;

    public Menu() {
        noteBook = new NoteBook();
        noteBook.open();
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        mainCommands();
        boolean exit = false;
        while (!exit){
            System.out.println("main menu");
            String command = scanner.nextLine();
            switch (command){
                case "commands":
                    mainCommands();
                    break;
                case "print":
                    noteBook.print();
                    break;
                case "sort":
                    sortMenu(noteBook);
                    break;
                case "find":
                    findMenu();
                    break;
                case "add":
                    addMenu();
                    break;
                case "exit":
                    noteBook.close();
                    exit = true;
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private void mainCommands(){
        System.out.println("'commands' - to print commands");
        System.out.println("'print' - to print all");
        System.out.println("'sort' - to sort menu");
        System.out.println("'find' - to find menu");
        System.out.println("'add' - to add note menu");
        System.out.println("'exit' - to exit");
    }

    public void sortMenu(NoteBook book){
        Scanner scanner = new Scanner(System.in);
        sortCommands();
        boolean exit = false;
        while (!exit){
            System.out.println("sort menu");
            String command = scanner.nextLine();
            switch (command) {
                case "commands":
                    sortCommands();
                    break;
                case "theme":
                    book.sortByTheme();
                    book.print();
                    break;
                case "date":
                    book.sortByDate();
                    book.print();
                    break;
                case "email":
                    book.sortByEmail();
                    book.print();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private void sortCommands(){
        System.out.println("'commands' - to print commands");
        System.out.println("'theme' - to sort by theme");
        System.out.println("'date' - to sort by date");
        System.out.println("'email' - to sort by email");
        System.out.println("'exit' - to exit");
    }

    public void findMenu(){
        NoteBook res = noteBook;
        Scanner scanner = new Scanner(System.in);
        findCommands();
        boolean exit = false;
        while (!exit){
            System.out.println("find menu");
            String command = scanner.nextLine();
            switch (command) {
                case "commands":
                    findCommands();
                    break;
                case "theme":
                case "date":
                case "email":
                case "word":
                    res = findBy(command);
                    res.print();
                    break;
                case "sort":
                    sortMenu(res);
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("wrong command");
            }
        }
    }

    private void findCommands(){
        System.out.println("'commands' - to print commands");
        System.out.println("'theme' - to find by theme");
        System.out.println("'date' - to find by date");
        System.out.println("'email' - to find by email");
        System.out.println("'word' - to find by word in text");
        System.out.println("'sort' - to sort founded");
        System.out.println("'exit' - to exit");
    }

    private NoteBook findBy(String command){
        Scanner scanner = new Scanner(System.in);
        String findWord;
        switch (command) {
            case "theme":
                System.out.println("insert theme");
                findWord = scanner.nextLine();
                return noteBook.findByTheme(findWord);
            case "date":
                System.out.println("insert date");
                findWord = scanner.nextLine();
                return noteBook.findByDate(findWord);
            case "email":
                System.out.println("insert email");
                findWord = scanner.nextLine();
                return noteBook.findByEmail(findWord);
            case "word":
                System.out.println("insert word");
                findWord = scanner.nextLine();
                return noteBook.findHasWord(findWord);
        }
        return new NoteBook();
    }

    public void addMenu(){

    }
}
