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

   public String tasksInNextSixHours () {
       String toReturn = null;
       int tasksInSixHours = 0;
       // Getting epoch time in milliseconds and converting to minutes.
       long currentTimeInMinutes = (System.currentTimeMillis() / 1000) / 60;
       //Adding 6 hours to current time value.
       long timeInSixHours = currentTimeInMinutes + 300;


        // Checking if the task date is today.
       for (int i = 0; i < taskList.size(); i++) {
           String toCompare = taskList.get(i).getDate();
           if (today().equals(toCompare)) {

        // If task date is today, then get hours and minutes from task.
               int hour = taskList.get(i).getHour();
               int minute = taskList.get(i).getMinute();
               if (hour >12) {
                   hour = hour - 12;
               }
        //Transforming hours to minutes,adding minutes to hour minutes and storing everything in long.
               long minutesToCheck = Long.valueOf((hour * 60) + minute);


        //Checking if value of current time and task time is less then value of 6 hours.
               if ((currentTimeInMinutes + minutesToCheck) < timeInSixHours){

        // Incrementing tasks in 6 hours counter.
                   tasksInSixHours++;
               } //Closing seconds if statement

           } // Closing first if statement.

       } //Closing for loop


       // Defining which String should be returned depending on the value of tasksInSixHours
       if (tasksInSixHours == 1) {
           toReturn = "You have " + tasksInSixHours + " task in next 6 hours.";
       }
       else if (tasksInSixHours > 1) {
           toReturn = "You have " + tasksInSixHours + " tasks in next 6 hours.";
       }
       else if (tasksInSixHours == 0) {
           toReturn = "You don't have tasks scheduled in next 6 hours.";
       }
        return  toReturn;
   } // Closing method body.


} // End of TaskCollection body.









