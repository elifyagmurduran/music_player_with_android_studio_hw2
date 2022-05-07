package com.learning.musicplayer_18011071;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder>{
    ArrayList<MusicFile> songList;
    Context context;

    public LibraryAdapter(ArrayList<MusicFile> songList, Context context) {
        this.songList = songList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout_resource,parent,false);
        return new LibraryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MusicFile fileData = songList.get(position);
        holder.songtitletext.setText(fileData.getTitle());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView songtitletext;
        ImageView songart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songtitletext = itemView.findViewById(R.id.song_title);
            songart = itemView.findViewById(R.id.song_art);
        }
    }

}
