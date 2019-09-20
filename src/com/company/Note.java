package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private String theme;
    private Date date;
    private String email;
    private String message;

    public Note() {
    }

    public Note(String theme, Date date, String email, String message) {
        this.theme = theme;
        this.date = date;
        this.email = email;
        this.message = message;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return "theme: " + theme + "\n" +
                "date: " + dateFormat.format(date) + "\n" +
                "email: " + email + "\n" +
                "message: " + message + "\n";
    }
}
