package com.theironyard.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView list;
    EditText text;
    Button addButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) { //creates
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //displays layout for app

        list = (ListView) findViewById(R.id.listView); //have to cast it so java knows
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button); //R. from our own project

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); //built into android
        list.setAdapter(items);

        addButton.setOnClickListener(this); //this class we're inside of can ...
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) { //from implement view on click listener
        String item = text.getText().toString();
        items.add(item);
        text.setText(""); //clears out text
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { //from implement on long click
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }
}
