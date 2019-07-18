package com.arkdev.task04.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arkdev.task04.R;
import com.arkdev.task04.models.Book;

public class BookViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV, priceTV;

    public BookViewHolder(View itemView) {
        super(itemView);

        nameTV = itemView.findViewById(R.id.name_tv);
        priceTV = itemView.findViewById(R.id.price_tv);


    }

    public void BindBook(Book book) {
        nameTV.setText(book.getName());
        priceTV.setText(book.getPrice());
    }
}
