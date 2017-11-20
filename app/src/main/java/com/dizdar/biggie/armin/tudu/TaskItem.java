package com.dizdar.biggie.armin.tudu;


import java.io.Serializable;

public class TaskItem implements Serializable{
    /*
    Model of Task
    Declaring 3 fields of type String
                                       */
    private String name;
    private String description;
    private String date;
    private String time;



    /*
    Task constructor
    @param name.
    @param description.
    @param date.
    */
    public TaskItem(String name, String description,String date) {
        this.name = name;
        this.description = description;
        this.date = date;

    }


    // Getter for name;
    public String getName() {
        return name;
    }

    //Getter for date
    public String getDate(){
        return date;
    }

    //Getter for description
    public String getDescription() {
        return description;
    }




    //Setter for name
    //@param name
    public void setName(String name) {
        this.name = name;
    }

    //Setter for description
    //@param description
    public void setDescription(String description) {
        this.description = description;
    }

    //Setter for date.
    //@param date.
    public void setDate(String date){
        this.date = date;
    }






} // End of TaskItem.class
