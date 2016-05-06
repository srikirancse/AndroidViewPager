package com.example.srikiransistla.homework3;

import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

import java.util.HashMap;

public class Fragment_DetailView extends Fragment {
    private static final String ARG_MOVIE = "movie";
    private HashMap<String,?> movie;

    private int total;

    public interface OnListItemSelectedListener{
        public void onListItemSelected(HashMap<String, ?> movie);
    }

    public static Fragment_DetailView newInstance(HashMap<String, ?> movie) {
        Fragment_DetailView fragment = new Fragment_DetailView();
        Bundle args = new Bundle();
        args.putSerializable(ARG_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment_DetailView() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            movie=(HashMap<String,?>) getArguments().getSerializable(ARG_MOVIE);
        }

        if (savedInstanceState!=null)
            total=savedInstanceState.getInt("Total");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.activity_detail,container,false);

        final TextView name=(TextView) rootView.findViewById(R.id.detail_name);
        final TextView year=(TextView) rootView.findViewById(R.id.detail_year);
        final TextView duration=(TextView) rootView.findViewById(R.id.detail_duration);
        final TextView director=(TextView) rootView.findViewById(R.id.detail_director_name);
        final TextView cast=(TextView) rootView.findViewById(R.id.detail_cast_names);
        final TextView description=(TextView) rootView.findViewById(R.id.detail_description);
        final ImageView poster=(ImageView) rootView.findViewById(R.id.detail_poster);
        final RatingBar rating=(RatingBar) rootView.findViewById(R.id.detail_rating);
        final TextView ratingNum=(TextView) rootView.findViewById(R.id.detail_rating_num);

        String movieName=(String) movie.get("name");
        String movieYear=(String) movie.get("year");
        String movieDuration=(String) movie.get("length");
        String movieDirector=(String) movie.get("director");
        String movieCast=(String) movie.get("stars");
        String movieDescription=(String) movie.get("description");
        Double movieRating=((Double) movie.get("rating"));
        Double movieRatingHalf=movieRating/2;
        Integer moviePoster=(Integer) movie.get("image");

        name.setText(movieName);
        year.setText(movieYear);
        duration.setText(movieDuration);
        director.setText(movieDirector);
        cast.setText(movieCast);
        description.setText(movieDescription);
        poster.setImageResource(moviePoster);
        float f = movieRatingHalf.floatValue();
        rating.setRating(f);
        ratingNum.setText(movieRating+"");

        return rootView;
    }

}

