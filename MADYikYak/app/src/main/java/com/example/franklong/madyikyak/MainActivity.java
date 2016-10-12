package com.example.franklong.madyikyak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView javaRecyclerView;
    private ArrayList<String> posts;
    private PostAdapter mAdapter;

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


        javaRecyclerView = (RecyclerView) findViewById(R.id.feed);
        mAdapter = new PostAdapter(posts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        javaRecyclerView.setLayoutManager(linearLayoutManager);

        javaRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        String newPost = getIntent().getStringExtra("input");
        if(newPost != null) posts.add(newPost);
        mAdapter.notifyDataSetChanged();
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
