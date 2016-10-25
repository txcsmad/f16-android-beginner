package com.example.franklong.madyikyak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by franklong on 10/11/16.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ArrayList<String> mDataset, mUsername, mURL, mTimeStamp;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView usernameTextView;
        public TextView postTextView;
        public TextView timestampTextView;
        public ImageView profilePicture;
        public ImageView divider;
        public ViewHolder(View v) {
            super(v);
            usernameTextView = (TextView) v.findViewById(R.id.username);
            postTextView = (TextView) v.findViewById(R.id.post_text);
            timestampTextView = (TextView) v.findViewById(R.id.time_stamp);
            profilePicture = (ImageView) v.findViewById(R.id.picture);
            divider = (ImageView) v.findViewById(R.id.divider);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PostAdapter(ArrayList<String> myDataset, ArrayList<String> myUsername, ArrayList<String> myTimeStamp,
                       ArrayList<String> myURL, Context myContext) {
        mDataset = myDataset;
        mURL = myURL;
        mUsername = myUsername;
        mTimeStamp = myTimeStamp;
        context = myContext;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.postTextView.setText(mDataset.get(position));
        holder.usernameTextView.setText(mUsername.get(position));
        holder.divider.setImageResource(R.drawable.divider);
        holder.timestampTextView.setText(mTimeStamp.get(position));
        Picasso.with(context).load(mURL.get(position)).into(holder.profilePicture);

        Log.v("position", position + "");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}



