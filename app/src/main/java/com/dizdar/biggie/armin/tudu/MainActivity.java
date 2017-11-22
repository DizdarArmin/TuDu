package com.dizdar.biggie.armin.tudu;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // Beginning of MainActivity body.

    //Declaring fields
    TaskItem itemToAdd;     //Instance of model.
    TaskCollection collection; //Instance of class that contains ArrayList of model
    ListView listView;
    ArrayAdapter arrayAdapter;

    String pickedDate = ""; //Date variable. Value of picked date. Empty by default.
    String addedName; // Name of task variable.
    String addedDescription; // Description of task variable.
    int pickedHour;
    int pickedMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing collection,listView,arrayAdapter. And setting arrayAdapter to adapter of listView.
        collection = new TaskCollection();
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new CustomAdapter(this, collection.getTaskList());
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Method override for inflating menu bar with Add and Check Buttons.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) { //Method for handling menu bar buttons
        int id = item.getItemId(); //Declaring integer variable which will be in charge which Button is clicked.

        if (id == R.id.add) { // In case that Add button is clicked. Pop up window will be shown
            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.alert_label_editor, null); // Reference to pop up  xml file.
            dialogBuilder.setView(dialogView);

            final AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();

            //Declaring EditText widgets, for being able to extract data.
            final EditText dialogName = dialogView.findViewById(R.id.dialog_name);
            final EditText dialogDescription = dialogView.findViewById(R.id.dialog_description);




            Button addTask = dialogView.findViewById(R.id.add_task); //Initializing add button .
            addTask.setOnClickListener(new View.OnClickListener() { // Add Button on Click listener.
                @Override
                public void onClick(View view) {
                    addedName = dialogName.getText().toString(); // Extracting strings from EditText widgets,
                    addedDescription = dialogDescription.getText().toString(); // and storing them in fields.


                    if (addedName + addedDescription + pickedDate !="" &&  pickedHour + pickedMinute != 0 ) { // Checking if user input exists to proceed.
                            itemToAdd = new TaskItem(addedName, addedDescription, pickedDate, pickedHour , pickedMinute); // Making object which contains 3 strings and 2 integers.
                            collection.add(itemToAdd); //Adding object to ArrayList
                            arrayAdapter.notifyDataSetChanged(); // Updating the view.
                            alertDialog.cancel(); //Exits from pop up window
                    }
                            else {
                                //Notify if user input is empty.
                                Toast.makeText(getApplicationContext(),"You should write something!", Toast.LENGTH_LONG).show();
                                alertDialog.cancel(); //Exits from pop up window
                    }
                }
            });

            Button cancel = dialogView.findViewById(R.id.cancel);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override                   //Exits from pop up window
                public void onClick(View view) {
                    alertDialog.cancel();
                }
            });

        }
        if (id == R.id.checkTasks) { // Menu button for notifying how many tasks you have for today.
            String taskForToday = collection.tasksForToday();
            String taskNextSixHours = collection.tasksInNextSixHours();

            String toToast = (taskForToday + "\n" + taskNextSixHours);
            Toast.makeText(this, toToast ,Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public void callDatePicker(View view){ // Method for displaying pop up window to chose date.
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dateView = inflater.inflate(R.layout.date_dialog, null);
        dialogBuilder.setView(dateView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        final DatePicker dp = dateView.findViewById(R.id.datePicker); // DatePicker widget reference.
        dp.setMinDate(System.currentTimeMillis() - 1000); // Setting minimal date to pick (today).
        Button add = dateView.findViewById(R.id.add); // Add button.
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // Add button OnClick method.
                String day = Integer.toString (dp.getDayOfMonth()); // Extracting day, month, year from DatePicker
                String month = Integer.toString(dp.getMonth()+1); //and converting to String.
                String year = Integer.toString(dp.getYear());

                pickedDate = day+"/"+ month + "/" + year ; // Storing day,month and year in pickedDate variable.
                String toDisplay = "Due date of your task is : " + day + "/" + month + "/" + year;
                // Notifying which date user picked.
                Toast.makeText(getApplicationContext(),toDisplay,Toast.LENGTH_LONG).show();
                alertDialog.cancel();
            }
        });

    }

    public void callTimePicker(View view) { // Method for displaying pop up window to chose date.
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View timeView = inflater.inflate(R.layout.time_dialog, null);
        dialogBuilder.setView(timeView);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


        final TimePicker tp = timeView.findViewById(R.id.timePicker);
        Button addButton = timeView.findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickedHour = tp.getHour();
                pickedMinute = tp.getMinute();
                String toDisplay = ("You have set your time to: " + pickedHour +":"+ pickedMinute);
                Toast.makeText(getApplicationContext(),toDisplay,Toast.LENGTH_LONG).show();
                alertDialog.cancel();


            }
        });

    }







} //End of MainActivity.























