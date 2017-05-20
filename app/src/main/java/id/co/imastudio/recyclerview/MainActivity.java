package id.co.imastudio.recyclerview;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

//        for (int i = 0; i<10; i++){
//            FilmModel film1 = new FilmModel("The Raid", "https://coretanfilm.files.wordpress.com/2012/07/sang-pemimpi.jpg");
//            filmList.add(film1);
//
//            FilmModel film2 = new FilmModel();
//            film2.setGambarFilm("https://pbs.twimg.com/media/C8rBmAYXkAAscTv.jpg");
//            film2.setJudulFilm("The Raid");
//            filmList.add(film2);
//        }

//        adapter = new FilmAdapter(filmList, this);
//        layoutManager = new GridLayoutManager(this, 2);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);

        getDataOnline();

    }

    private void getDataOnline() {

        final ProgressDialog loading = ProgressDialog.show(this, "Loding Data", "Mohon Bersabar", false, false);
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=b08e3495841838f530552c2b261e00b1&language=en-US&page=1";

        JsonObjectRequest ambildata = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //ntar kalo respon ngapain
                loading.hide();
                try {
                    JSONArray arrayresults = response.getJSONArray("results");
                    for (int i = 0 ; i< arrayresults.length() ; i++){
                        JSONObject json = arrayresults.getJSONObject(i);
                        Log.d("Hasil Json :",""+json);
                        FilmModel film2 = new FilmModel();
                        film2.setGambarFilm(json.getString("poster_path"));
                        film2.setJudulFilm(json.getString("title"));
                        filmList.add(film2);
                    }
                    adapter = new FilmAdapter(filmList, MainActivity.this);
                    layoutManager = new GridLayoutManager(MainActivity.this, 2);

                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(layoutManager);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error get json", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //kalo error ngapain
                Toast.makeText(MainActivity.this, "Error no response : "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue antrian = Volley.newRequestQueue(this);
        antrian.add(ambildata);

    }

    //generate override method onConfig

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
