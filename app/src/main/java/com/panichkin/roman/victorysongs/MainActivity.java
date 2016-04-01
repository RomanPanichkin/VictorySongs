package com.panichkin.roman.victorysongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    int chosenSongPosition;

  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      final ArrayList<Song> songArrayList = new ArrayList<>();
      createListView(songArrayList);

    // находим список
    final ListView lvMain = (ListView) findViewById(R.id.songs_ListView);

    // создаем адаптер
    ArrayAdapter<Song> adapter = new ArrayAdapter<Song>(this,
        R.layout.list_item, songArrayList);

    // присваиваем адаптер списку
    lvMain.setAdapter(adapter);

      lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
                                  int position, long id) {
              chosenSongPosition = position;
              toPlayer(view, songArrayList, chosenSongPosition);
          }
      });
  }

    private void createListView(ArrayList<Song> songArrayList) {
        Song katusha = new Song("Катюша", getString(R.string.katusha_lyrics), R.raw.katusha);
        Song denPobedi = new Song("День Победы", getString(R.string.denpobedi_lyrics), R.raw.denpopedi);
        Song posledniyBoi = new Song("Последний бой", getString(R.string.posledniyBoi_lyrics), R.raw.posledniyboi);
        songArrayList.add(katusha);
        songArrayList.add(denPobedi);
        songArrayList.add(posledniyBoi);
    }

    public void toPlayer(View view, ArrayList<Song> arrayList, int chosenSong) {
            Intent intent = new Intent(this, PlayerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", arrayList);
            intent.putExtras(bundle);
            intent.putExtra("chosenSong", chosenSong);
            startActivity(intent);
        }
}