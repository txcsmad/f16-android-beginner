package com.example.franklong.madyikyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComposeActivity extends AppCompatActivity {

    private EditText javaComposeText;
    private Button javaSubmitButton;

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
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("input", s);
                startActivity(i);
            }
        });
    }
}
