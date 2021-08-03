package com.codingwithkprathore.horizontalrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerView Adapter";

    // variable
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImageUrls, ArrayList<String> mNames) {
        this.mImageUrls = mImageUrls;
        this.mNames = mNames;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .into(holder.image);

        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on a image." + mNames.get(position));
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            name = itemView.findViewById(R.id.name);

        }
    }
}
