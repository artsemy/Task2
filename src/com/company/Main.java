package com.company;

public class Main {

    /*
    notebook with notes. note [theme, data, email, message]
    when program start all info read from txt file
    when program end all info write to txt file
    search for param, group of param, add note
    special condition:
        search and compare validate with regular expressions
        code adding info must validate inserted
     */
    public static void main(String[] args) {
        //start program with open menu
        Menu menu = new Menu();
        menu.mainMenu();
    }

}
