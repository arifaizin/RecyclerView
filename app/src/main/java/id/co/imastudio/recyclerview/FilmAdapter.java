package id.co.imastudio.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by idn on 5/13/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    List<FilmModel> filmList;
    Context context;
    private Cursor mCursor;

    //Create constructor
    public FilmAdapter(List<FilmModel> filmList, Context context) {
        this.filmList = filmList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulFilm;
        ImageView gambarFilm;

        public ViewHolder(View itemView) {
            super(itemView);
            judulFilm = (TextView) itemView.findViewById(R.id.tvItem);
            gambarFilm = (ImageView) itemView.findViewById(R.id.ivItem);
        }
    }

    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        itemView.setFocusable(true);
        return new ViewHolder(itemView);
        //item layout
    }

    @Override
    public void onBindViewHolder(FilmAdapter.ViewHolder holder, final int position) {

        int judulIndex = mCursor.getColumnIndex(FilmContract.FilmEntry.COLUMN_JUDUL);
        int posterIndex = mCursor.getColumnIndex(FilmContract.FilmEntry.COLUMN_POSTER);

        Log.d("Hasil Index",judulIndex +"-"+posterIndex );

        mCursor.moveToPosition(position); // get to the right location in the cursor

        // Determine the values of the wanted data
        String judulFilm = mCursor.getString(judulIndex);
        String posterFilm = mCursor.getString(posterIndex);


        Log.d("Hasil",judulFilm +"-"+posterFilm );
        //Set values
        holder.judulFilm.setText(judulFilm);
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+posterFilm)
                .error(R.mipmap.ic_launcher)
                .into(holder.gambarFilm);

//        //proses komponen
//        holder.judulFilm.setText(filmList.get(position).getJudulFilm());
////        holder.gambarFilm.setImageResource(filmList.get(position).getGambarFilm());
//        Glide.with(context)
//                .load("https://image.tmdb.org/t/p/w500"+filmList.get(position).getGambarFilm())
//                .error(R.mipmap.ic_launcher)
//                .into(holder.gambarFilm);

        holder.gambarFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Judul Film : "+ filmList.get(position).getJudulFilm(), Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent (context, ScrollingActivity.class);
//                pindah.putExtra("DATA_JUDUL", filmList.get(position).getJudulFilm());
                context.startActivity(pindah);
            }
        });



    }

    @Override
    public int getItemCount() {
//        return filmList.size();
        if (null == mCursor) return 0;
        return mCursor.getCount();
        //jumlah list
    }


    /**
     * When data changes and a re-query occurs, this function swaps the old Cursor
     * with a newly updated Cursor (Cursor c) that is passed in.
     */
void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
    }

}
