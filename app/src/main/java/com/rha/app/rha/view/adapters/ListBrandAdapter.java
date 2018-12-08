package com.rha.app.rha.view.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rha.app.rha.R;

import java.util.ArrayList;

public class ListBrandAdapter extends RecyclerView.Adapter<ListBrandAdapter.MyViewHolder> {

    private ArrayList<String> brandList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgcategories;
        private TextView txtCategories;

        public MyViewHolder(View view) {
            super(view);
            imgcategories = (ImageView) view.findViewById(R.id.imgBrands);
            txtCategories = (TextView)view.findViewById(R.id.txtCategories);
        }
    }


    public ListBrandAdapter(Context context,ArrayList<String> moviesList) {
        this.context = context;
        this.brandList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_brands, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Movie movie = moviesList.get(position);
//        holder.title.setText(movie.getTitle());
//        holder.genre.setText(movie.getGenre());
//        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }
}
