package com.learning.musicplayer_18011071;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class SongLibraryActivity extends AppCompatActivity {
    RecyclerView recyclerView = findViewById(R.id.songsView);
    TextView noMusicTextView = findViewById(R.id.no_songs_text);
    ArrayList<MusicFile> libraryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] libraryContent = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };
        String selection = MediaStore.Audio.Media.IS_MUSIC +" != 0";
        Cursor clicker = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, libraryContent, selection, null, null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_library);

        recyclerView = findViewById(R.id.songsView);
        noMusicTextView = findViewById(R.id.no_songs_text);

        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };


        while (clicker.moveToNext()) {
            MusicFile songData = new MusicFile(clicker.getString(1), clicker.getString(0), clicker.getString(2));
            if (new File(songData.getPath()).exists())
                libraryList.add(songData);
        }
        //if library is empty no songs found will be shown if it not empty we will shown scrollable recylerview
        if (libraryList.size()!=0){
            //create the view? explain this part
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new LibraryAdapter(libraryList,getApplicationContext()));
        }else{
            noMusicTextView.setVisibility(View.VISIBLE);
        }
    }
















}
