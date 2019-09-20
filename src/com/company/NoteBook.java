package com.company;

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

public class NoteBook {

    private Note[] notes;

    public NoteBook() {
        notes = new Note[0];
        readFromFile();
    }

    public NoteBook(Note[] notes) {
        this.notes = notes;
    }

    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }

    public void addNote(Note note){
        notes = Arrays.copyOf(notes, notes.length+1);
        notes[notes.length-1] = note;
    }

    public void sortByTheme(){
        Arrays.sort(notes, new ThemeComparator());
    }

    public void sortByDate(){
        Arrays.sort(notes, new DateComparator());
    }

    public void sortByEmail(){
        Arrays.sort(notes, new EmailComparator());
    }

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

    public void close(){
        writeToFile();
    }

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

    public void print(){
        for (Note n: notes) {
            System.out.println(n);
        }
    }
}
