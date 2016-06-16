package br.ufc.dc.dspm.mynotes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {

    private int id;

    private String title;

    private String content;

    private Date date;

    public void setDateByString(String dateStr){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

            this.date = formatter.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "(" + id + ") " + title + ": " + content;
    }
}