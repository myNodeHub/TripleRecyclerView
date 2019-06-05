package com.example.triplerecyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aroliant on 1/3/2018.
 */
//  RecyclerView с параметром ViewHolder
public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    ArrayList<Transport> transportList = new ArrayList<>();
    Context context;

    public ExpandableRecyclerViewAdapter(Context context, ArrayList<Transport> transportList)//принимает контекст, и лист род. эл.
    {
        this.context = context;
        this.transportList = transportList;

    }

    public class ViewHolder extends RecyclerView.ViewHolder { //принимает Вью(layout) на вход и инициализирует все его компоненты
        TextView transportName;
        RecyclerView transportRecyclerView;
        CardView transportCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            transportName = itemView.findViewById(R.id.transportName);
            transportRecyclerView = itemView.findViewById(R.id.transportRecyclerView);
            transportCardView = itemView.findViewById(R.id.transportCardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //создает объект ViewHolder передавая ему Вью(layout)
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transport_view, parent, false);

        ExpandableRecyclerViewAdapter.ViewHolder vh = new ExpandableRecyclerViewAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.transportName.setText(transportList.get(position).getTransportName());

        //инициализация адаптера типа InnerRecyclerViewAdapter
        InnerRecyclerViewAdapter itemInnerRecyclerView = new InnerRecyclerViewAdapter(context, transportList.get(position).getMotorList());

        //устанавливает рец.вьюхе innerRecyclerView табличный лэйаут
        holder.transportRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));


        holder.transportCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // обработчик.
                if (transportList.get(position).isExpandedTransport() == false) {
                    holder.transportRecyclerView.setVisibility(View.VISIBLE);
                    transportList.get(position).setExpandedTransport(true);
                } else {
                    holder.transportRecyclerView.setVisibility(View.GONE);
                    transportList.get(position).setExpandedTransport(false);
                }
            }
        });

        holder.transportRecyclerView.setAdapter(itemInnerRecyclerView); //устанавливает рец.вьюхе innerRecyclerView адаптер itemInnerRecyclerView

    }

    @Override
    public int getItemCount() {
        return transportList.size();
    }


}
