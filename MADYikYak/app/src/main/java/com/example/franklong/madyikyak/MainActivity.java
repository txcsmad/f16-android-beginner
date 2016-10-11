package com.example.franklong.madyikyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView javaListView;
    private ArrayList<String> posts;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();
        posts.add("hey guys android is the best");
        posts.add("whoa android is so cool");
        posts.add("Frank sucks");
        posts.add("KIERAN SUX");
        posts.add("Jacob is the worst");
        posts.add("Jacob is definitely the worst");
        posts.add("Ali is an awful human being");


        javaListView = (ListView) findViewById(R.id.feed);
        mAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.post_text, posts);
        javaListView.setAdapter(mAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.compose) {
            //do some stuff
            Intent i = new Intent(getApplicationContext(), ComposeActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
