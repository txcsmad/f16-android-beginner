package com.example.franklong.madyikyak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ComposeActivity extends AppCompatActivity {

    private final String USERNAME = "Ali";
    private final String PICTURE_URL = "UF1fDF";

    private EditText javaComposeText;
    private Button javaSubmitButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mRef = database.getReference("data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        javaComposeText = (EditText) findViewById(R.id.compose_text);
        javaSubmitButton = (Button) findViewById(R.id.submit_button);

        javaSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = javaComposeText.getText().toString();
                String timestamps = new SimpleDateFormat("MM\\dd\\yy hh:mm:ss a").format(Calendar.getInstance().getTime());
                mRef.child(timestamps).child(PICTURE_URL).child(USERNAME).setValue(s);

                finish();
            }
        });
    }
}
