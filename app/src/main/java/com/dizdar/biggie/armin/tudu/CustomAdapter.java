package com.dizdar.biggie.armin.tudu;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
// Beginning of CustomAdapter body
// In this class I made customAdapter to be able to put more values in each listView row.
public class CustomAdapter extends ArrayAdapter<TaskItem>{


    // CustomAdapter constructor which is passing info to parent.
    public CustomAdapter(Context context, ArrayList<TaskItem>taskItems ) {
        super(context, R.layout.row_layout_with_delete ,taskItems);
    }

    @NonNull
    @Override
    //Overridden method which is giving customView specific layout.
    //@param position
    //@param convertView
    //@param parent
    //Using LayoutInflater to populate customView with Custom layout file
    public View getView(final int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.row_layout_with_delete, parent ,false);

        //Getting String values from ArrayList objects.
        String name = getItem(position).getName();
        String description = getItem(position).getDescription();
        String date = getItem(position).getDate();
        String hour = Integer.toString(getItem(position).getHour());
        String minute = Integer.toString(getItem(position).getMinute());



        // Initializing TextView widgets.
        TextView nameOfTask = customView.findViewById(R.id.custom_name);
        TextView descriptionOfTask = customView.findViewById(R.id.custom_description);
        TextView dateOfTask = customView.findViewById(R.id.custom_date);
        TextView timeOfTask = customView.findViewById(R.id.custom_time);

        //Populating TextView widgets inside of ListView with Strings from ArrayList objects.
        nameOfTask.setText(name);
        descriptionOfTask.setText(description);
        dateOfTask.setText(date);
        timeOfTask.setText(hour + ":" + minute);




        // Initializing Delete Button widget and setting onClick action to remove
        Button deletebutton = customView.findViewById(R.id.DeleteButton);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(getItem(position));
            }
        });




            return customView;
    }
}
