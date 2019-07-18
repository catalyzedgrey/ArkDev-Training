package com.arkdev.task04.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.arkdev.task04.R;
import com.arkdev.task04.adapters.BookAdapter;
import com.arkdev.task04.models.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String URL = "http://jsonstub.com/books";
    RecyclerView recyclerView;
    List<Book> bookList = new ArrayList<>();
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitViews();
        new LoadBooks().execute(URL);
    }

    private void InitViews() {

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new BookAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }


    private class LoadBooks extends AsyncTask<String, String, List<Book>> {

        @Override
        protected List<Book> doInBackground(String... strings) {
            java.net.URL url;
            HttpURLConnection urlConnection = null;
            List<Book> books = new ArrayList<>();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                //HTTP header
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("JsonStub-User-Key", "a5a3a085-c9bd-462a-83c5-77620f963745");
                urlConnection.setRequestProperty("JsonStub-Project-Key", "612f90bf-ac5d-4ad7-9a41-f59460cd8d1c");

                int responseCode = urlConnection.getResponseCode();
                String responseMessage = urlConnection.getResponseMessage();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String responseString = readStream(urlConnection.getInputStream());
                    Log.v("CatalogClient-Response", responseString);
                    books = parseBookData(responseString);
                } else {
                    Log.v("CatalogClient", "Response code:" + responseCode);
                    Log.v("CatalogClient", "Response message:" + responseMessage);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
            }


            return books;
        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer response = new StringBuffer();
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return response.toString();
        }

        private List<Book> parseBookData(String jString) {

            List<Book> bookList = new ArrayList<Book>();
            try {
                JSONObject jObj = new JSONObject(jString);
                JSONArray books = jObj.getJSONArray("books");
                if (books != null) {
                    for (int i = 0; i < books.length(); i++) {
                        String title = books.getJSONObject(i).getString("name");
                        String price = books.getJSONObject(i).getString("price");
                        //the value of progress is a placeholder here....
                        bookList.add(new Book(title, price));
                    }

                }

            } catch (JSONException e) {
                Log.e("CatalogClient", "unexpected JSON exception", e);
            }

            return bookList;
        }

        @Override
        protected void onPostExecute(List<Book> books) {
            super.onPostExecute(books);
            adapter.setData(books);
        }
    }

}
