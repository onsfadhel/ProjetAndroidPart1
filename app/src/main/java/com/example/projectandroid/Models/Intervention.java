package com.example.projectandroid.Models;

public class Intervention {
    private String title,societe,address,time;


    public Intervention(String title, String societe, String address,String time) {
        this.title = title;
        this.societe =societe;
        this.address=address;
        this.time=time;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getTime(){
        return time;
    }
    public void setTime(){
        this.time=time;
    }

}
