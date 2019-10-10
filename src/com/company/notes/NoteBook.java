package com.company.notes;

import com.company.comparators.DateComparator;
import com.company.comparators.EmailComparator;
import com.company.comparators.ThemeComparator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteBook {

    private Note[] notes;

    //constructor
    public NoteBook() {
        notes = new Note[0];
    }

    //add note
    public void addNote(Note note){
        notes = Arrays.copyOf(notes, notes.length+1);
        notes[notes.length-1] = note;
    }

    //add note
    public void addNote(String theme, String date, String email, String text){
        Note note = new Note(theme, date, email, text);
        addNote(note);
    }

    //sort by theme
    public void sortByTheme(){
        Arrays.sort(notes, new ThemeComparator());
    }

    //sort by date
    public void sortByDate(){
        Arrays.sort(notes, new DateComparator());
    }

    //sort by email
    public void sortByEmail(){
        Arrays.sort(notes, new EmailComparator());
    }

    //init read from file
    public void open(){
        readFromFile();
    }

    //read from file
    private void readFromFile(){
        Path path = Paths.get("./resources/notes.txt");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()){
                String theme = scanner.nextLine().substring(7);
                Date date = dateFormat.parse(scanner.nextLine().substring(6));
                String email = scanner.nextLine().substring(7);
                String text = scanner.nextLine().substring(9);
                Note note = new Note(theme, date, email, text);
                addNote(note);
                scanner.nextLine();
            }
        } catch (IOException | ParseException ignored) {
        }
    }

    //close write to file
    public void close(){
        writeToFile();
    }

    //write to file
    private void writeToFile(){
        File file = new File("./resources/notes.txt");
        try {
            FileWriter writer = new FileWriter(file, false);
            for (Note n: notes) {
                writer.append(n.toString());
                writer.append("--------------------\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print notes
    public void print(){
        for (Note n: notes) {
            System.out.println(n);
        }
    }

    //find by theme
    public NoteBook findByTheme(String theme){
        NoteBook res = new NoteBook();
        for (Note n: notes) {
            if (n.getTheme().contains(theme)){
                res.addNote(n);
            }
        }
        return res;
    }

    //find by date
    public NoteBook findByDate(String date){
        NoteBook res = new NoteBook();
        for (Note n: notes) {
            if (n.dateToString().contains(date)){
                res.addNote(n);
            }
        }
        return res;
    }

    //find by email
    public NoteBook findByEmail(String email){
        NoteBook res = new NoteBook();
        for (Note n: notes) {
            if (n.getEmail().contains(email)){
                res.addNote(n);
            }
        }
        return res;
    }

    //find by word
    public NoteBook findHasWord(String word){
        NoteBook res = new NoteBook();
        for (Note n: notes) {
            if (n.getMessage().contains(word)){
                res.addNote(n);
            }
        }
        return res;
    }

    //find by word with regular exp
    public NoteBook findHasWord(String word, int k){
        Pattern pattern = Pattern.compile(word);
        Matcher matcher;
        NoteBook res = new NoteBook();
        for (Note n: notes) {
            matcher = pattern.matcher(n.getMessage());
            if (matcher.find()){
                res.addNote(n);
            }
        }
        return res;
    }

    //find by email and word
    public NoteBook findByEmailWord(String email, String word){
        NoteBook res = new NoteBook();
        res = this.findByEmail(email);
        res = res.findHasWord(word);
        return res;
    }

}
