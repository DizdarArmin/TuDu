package com.dizdar.biggie.armin.tudu;


import java.io.Serializable;

class TaskItem implements Serializable{
    /*
    Model of Task
    Declaring 3 fields of type String
                                       */
    private String name;
    private String description;
    private String date;
    private int hour;
    private int minute;



    /*
    Task constructor
    @param name.
    @param description.
    @param date.
    */
TaskItem(String name, String description,String date, int hour, int minute) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
    }
    //Getter for hour.
     int getHour(){
        return hour;
    }

    //Getter for minute.
    int getMinute(){
        return minute;
    }

    // Getter for name.
    public String getName() {
        return name;
    }

    //Getter for date
    String getDate(){
        return date;
    }

    //Getter for description
     String getDescription() {
        return description;
    }




    //Setter for name
    //@param name
    void setName(String name) {
        this.name = name;
    }

    //Setter for description
    //@param description
    void setDescription(String description) {
        this.description = description;
    }

    //Setter for date.
    //@param date.
     void setDate(String date){
        this.date = date;
    }





} // End of TaskItem.class
