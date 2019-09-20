package com.company.notes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String theme;
    private Date date;
    private String email;
    private String message;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public Note() {
    }

    public Note(String theme, Date date, String email, String message) {
        this.theme = theme;
        this.date = date;
        this.email = email;
        this.message = message;
    }

    public Note(String theme, String date, String email, String message) {
        try {
            Date d = dateFormat.parse(date);
            this.theme = theme;
            this.date = d;
            this.email = email;
            this.message = message;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {

        return "theme: " + theme + "\n" +
                "date: " + dateToString() + "\n" +
                "email: " + email + "\n" +
                "message: " + message + "\n";
    }

    public String dateToString(){
        String res = dateFormat.format(date);
        return res;
    }
}
