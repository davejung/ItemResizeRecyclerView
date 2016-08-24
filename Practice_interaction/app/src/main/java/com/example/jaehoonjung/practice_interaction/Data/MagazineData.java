package com.example.jaehoonjung.practice_interaction.Data;

/**
 * Created by jaehoonjung on 2016. 8. 22..
 */
public class MagazineData {

    private String title;
    private String summary;
    private int resource;

    public int getResource() {
        return resource;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public MagazineData(String title, String summary, int resource){
        this.title = title;
        this.summary = summary;
        this.resource = resource;
    }
}
