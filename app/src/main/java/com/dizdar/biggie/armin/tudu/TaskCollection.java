package com.dizdar.biggie.armin.tudu;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class TaskCollection { //Beginning of TaskCollection body.

    // Declared ArrayList in field.
    private ArrayList<TaskItem> taskList;


    // Method for returning ArrayList
    ArrayList<TaskItem> getTaskList() {
            return taskList;
        }



// TaskCollection constructor.
    TaskCollection() {
            this.taskList = new ArrayList<>();
    }

    /* Method for adding TaskItem to ArrayList of TaskItems
       @param item
     */
    void add(TaskItem item){
        taskList.add(item);
    }

    // Method for checking how many tasks you have for today
    // Return String
    String tasksForToday() {
        String toPass;
        int i;
        int numberOfTasks = 0;
        for (i = 0; i < taskList.size(); i++) {
            String toCompare = taskList.get(i).getDate();
                if (today().equals(toCompare)) {
                    numberOfTasks++;
                }
            }

        if (numberOfTasks == 1) {
            toPass = "You have " + numberOfTasks + " task today!";
        }
        else if (numberOfTasks == 0){
            toPass = " You have no tasks for today!";
        }

        else {
            toPass = "You have " + numberOfTasks + " tasks today!";
        }
        return toPass;
    }

    //Method that returns String value of today's date.
    private String today(){
        Calendar today = Calendar.getInstance();
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.GERMANY);
        String strDate = myDateFormat.format(today.getTime());
        return strDate;
    }

} // End of TaskCollection body.









