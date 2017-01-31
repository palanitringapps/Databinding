package com.lbloop.utils;

import android.os.AsyncTask;

import com.lbloop.model.Movie;


public class ModifyInBackgroundTask extends AsyncTask<Movie, Void, Void> {
   @Override
   protected Void doInBackground(Movie... movies) {
      for (Movie movie : movies) {
         movie.setTitle(movie.getTitle() + " modified");
      }
      return null;
   }
}
