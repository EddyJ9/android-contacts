package com.theironyard.androidcontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    ArrayAdapter<String> contacts;
    ListView listView;
    EditText name;
    EditText phone;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1);
        listView.setAdapter(contacts);
        addButton.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String contact = name.getText().toString() + " " + phone.getText().toString();
        contacts.add(contact);
        name.setText("");
        phone.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
        String contact = contacts.getItem(i);
        contacts.remove(contact);
        return true;
    }
}
