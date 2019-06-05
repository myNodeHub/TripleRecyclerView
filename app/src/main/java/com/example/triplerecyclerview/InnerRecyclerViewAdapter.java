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
public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder> {

    public ArrayList<Motor> motorList = new ArrayList<>();
    Context context;

    public InnerRecyclerViewAdapter(Context context,ArrayList<Motor> motorList ) {

        this.motorList = motorList;
        this.context = context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder { //Предоставляет прямую ссылку на каждый View-компонент
        TextView motorTextView;
        RecyclerView motorRecyclerView;
        CardView motorCardView;

        public ViewHolder(View itemView) { //конструктор принимает на вход View-компонент, ищет все дочерние компоненты, и возвращает их холдеру
            super(itemView);
            motorTextView = itemView.findViewById(R.id.motorTextView);
            motorRecyclerView = itemView.findViewById(R.id.motorRecyclerView);
            motorCardView = itemView.findViewById(R.id.motorCardView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //создаёт объект ViewHolder, которому передаем на вход View-компонент
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.motor_view, parent, false);


        InnerRecyclerViewAdapter.ViewHolder vh = new InnerRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.motorTextView.setText("Двигатель: " + motorList.get(position).getMotorName()); // связывает холдер с элементом листа листов д.э.

        //инициализация адаптера типа GrandSonRecyclerViewAdapter
        GrandSonRecyclerViewAdapter grandSonRecyclerView = new GrandSonRecyclerViewAdapter(context, motorList.get(position).getdetailList());

        //устанавливает рец.вьюхе innerRecyclerView табличный лэйаут
        holder.motorRecyclerView.setLayoutManager(new LinearLayoutManager(context));


        holder.motorCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // обработчик.
                if (motorList.get(position).isExpandedMotor() == false) {
                    holder.motorRecyclerView.setVisibility(View.VISIBLE);
                    motorList.get(position).setExpandedMotor(true);
                } else {
                    holder.motorRecyclerView.setVisibility(View.GONE);
                    motorList.get(position).setExpandedMotor(false);
                }
            }
        });

        holder.motorRecyclerView.setAdapter(grandSonRecyclerView); //устанавливает рец.вьюхе innerRecyclerView адаптер itemInnerRecyclerView
    }

    @Override
    public int getItemCount() {
        return motorList.size();
    }


}
