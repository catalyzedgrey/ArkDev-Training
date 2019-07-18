package com.arkdev.task04.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkdev.task04.R;
import com.arkdev.task04.models.Book;
import com.arkdev.task04.viewholders.BookViewHolder;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>  {
    List<Book> bookList;

    public BookAdapter() {
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_book, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder bookViewHolder, int i) {
        bookViewHolder.BindBook(bookList.get(i));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public void setData(List<Book> books)
    {
        this.bookList = books;
        notifyDataSetChanged();
    }
}
