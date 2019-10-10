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

    //constructor
    public Note(String theme, Date date, String email, String message) {
        this.theme = theme;
        this.date = date;
        this.email = email;
        this.message = message;
    }

    //constructor
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

    //get method
    public String getTheme() {
        return theme;
    }

    //set method
    public void setTheme(String theme) {
        this.theme = theme;
    }

    //get method
    public Date getDate() {
        return date;
    }

    //set method
    public void setDate(Date date) {
        this.date = date;
    }

    //get method
    public String getEmail() {
        return email;
    }

    //set method
    public void setEmail(String email) {
        this.email = email;
    }

    //get method
    public String getMessage() {
        return message;
    }

    //set method
    public void setMessage(String message) {
        this.message = message;
    }

    //to string
    @Override
    public String toString() {

        return "theme: " + theme + "\n" +
                "date: " + dateToString() + "\n" +
                "email: " + email + "\n" +
                "message: " + message + "\n";
    }

    //format date to string
    public String dateToString(){
        String res = dateFormat.format(date);
        return res;
    }

}
