package com.example.franklong.madyikyak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView javaRecyclerView;
    private ArrayList<String> posts, urls, usernames, timestamps;
    private PostAdapter mAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mRef = database.getReference("data");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();
        urls = new ArrayList<>();
        timestamps = new ArrayList<>();
        usernames = new ArrayList<>();

/*        posts.add("hey guys android is the best");
        posts.add("whoa android is so cool");
        posts.add("Frank sucks");
        posts.add("KIERAN SUX");
        posts.add("Jacob is the worst");
        posts.add("Jacob is definitely the worst");
        posts.add("Ali is an awful human being");*/


        javaRecyclerView = (RecyclerView) findViewById(R.id.feed);
        mAdapter = new PostAdapter(posts, usernames, timestamps, urls, getApplicationContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        javaRecyclerView.setLayoutManager(linearLayoutManager);

        javaRecyclerView.setAdapter(mAdapter);
    }

    private ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            refresh();
            for (DataSnapshot timeData: dataSnapshot.getChildren()) {
                String time = timeData.getKey();
                timestamps.add(time);
                for (DataSnapshot urlData: timeData.getChildren()) {
                    String url = "https://goo.gl/"+urlData.getKey();
                    urls.add(url);
                    for (DataSnapshot userData: urlData.getChildren()) {
                        String username = userData.getKey();
                        usernames.add(username);
                        String post = userData.getValue(String.class);
                        posts.add(post);

                    }

                }

            }
            Collections.reverse(posts);
            Collections.reverse(usernames);
            Collections.reverse(urls);
            Collections.reverse(timestamps);
            mAdapter.notifyDataSetChanged();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.w("Error", "Attempt unsuccessful");
        }
    };

    public void refresh(){
        posts.clear();
        urls.clear();
        timestamps.clear();
        usernames.clear();
    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first
        refresh();
        mRef.addValueEventListener(eventListener);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mRef.removeEventListener(eventListener);
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
