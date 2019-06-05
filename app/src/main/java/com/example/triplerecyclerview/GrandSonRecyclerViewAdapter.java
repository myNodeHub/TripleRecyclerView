package com.example.triplerecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aroliant on 1/3/2018.
 */
//  RecyclerView с параметром ViewHolder
public class GrandSonRecyclerViewAdapter extends RecyclerView.Adapter<GrandSonRecyclerViewAdapter.ViewHolder> {

    ArrayList<Detail> detailList = new ArrayList<>();
    Context context;

    public GrandSonRecyclerViewAdapter(Context context, ArrayList<Detail> detailList) {

        this.detailList = detailList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView detailName;
        CardView detailCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            detailName = itemView.findViewById(R.id.detailName);
            detailCardView = itemView.findViewById(R.id.detailCardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_view, parent, false);


        GrandSonRecyclerViewAdapter.ViewHolder vh = new GrandSonRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.detailName.setText("Деталь: " + detailList.get(position).getDetailName());

        holder.detailCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("detail", detailList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }


}
