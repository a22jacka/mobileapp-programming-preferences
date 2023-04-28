package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    // in My MainActivity class
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get a reference to the shared preference
        myPreferenceRef = getSharedPreferences("key", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

// Display preferences
        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.textViewS);
        prefTextRef.setText(myPreferenceRef.getString("key", "No preference found."));
    }

    void store() {
        EditText sharedPrefData = findViewById(R.id.editTextS);
        myPreferenceEditor.putString("key", sharedPrefData.getText().toString());
        myPreferenceEditor.apply();
    }
}