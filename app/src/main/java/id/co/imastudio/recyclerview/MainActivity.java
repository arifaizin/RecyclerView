package id.co.imastudio.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<FilmModel> filmList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmList = new ArrayList<>();

        for (int i = 0; i<10; i++){
            FilmModel film1 = new FilmModel("The Raid", "https://coretanfilm.files.wordpress.com/2012/07/sang-pemimpi.jpg");
            filmList.add(film1);

            FilmModel film2 = new FilmModel();
            film2.setGambarFilm("https://pbs.twimg.com/media/C8rBmAYXkAAscTv.jpg");
            film2.setJudulFilm("The Raid");
            filmList.add(film2);
        }

        adapter = new FilmAdapter(filmList, this);
        layoutManager = new GridLayoutManager(this, 2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

    }
}
