package com.example.triplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView expanderRecyclerView; // объявляем рецик.вью

    public ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        expanderRecyclerView = findViewById(R.id.recyclerView); //инициализиация рецик.вью (мэйн активити)

        initiateExpander(); //вызывов initiateExpander

    }


    private void initiateExpander() {

//        ArrayList<String> parentList = new ArrayList<>();         //лист родительских элементов (Транспорт)
//        ArrayList<ArrayList> childListHolder = new ArrayList<>(); //лист листов дочерних элементов (Моторы)
//
//        ArrayList<String> grandSonListHolder = new ArrayList<>(); //лист листов внучатых элементов (пока равный для всех) (Детали)
//
//        grandSonListHolder.add("Grandson1");
//        grandSonListHolder.add("Grandson2");
//        grandSonListHolder.add("Grandson3");
//
//
//        parentList.add("Fruits & Vegetables");  //заполнение листа родительских элементов
//        parentList.add("Beverages & Health");
//        parentList.add("Home & Kitchen");
//
//        ArrayList<String> childNameList = new ArrayList<>(); // лист дочерних элементов (1)
//        childNameList.add("Apple");
//        childNameList.add("Mango");
//        childNameList.add("Banana");
//
//        childListHolder.add(childNameList);  // добавление листа дочерних элементов в лист листов д. э.
//
//        childNameList = new ArrayList<>();  // лист дочерних элементов (2)
//        childNameList.add("Red bull");
//        childNameList.add("Maa");
//        childNameList.add("Horlicks");
//
//        childListHolder.add(childNameList); // добавление листа дочерних элементов (2) в лист листов д. э.
//
//        childNameList = new ArrayList<>();  // лист дочерних элементов (3)
//        childNameList.add("Knife");
//        childNameList.add("Vessels");
//        childNameList.add("Spoons");
//
//        childListHolder.add(childNameList); // добавление листа дочерних элементов (3) в лист листов д. э.


///////////////////// авто
        ArrayList<Detail> detailsFor_Auto_Z18XEE = new ArrayList<>();        //лист Деталей двиг авто(1)
        detailsFor_Auto_Z18XEE.add(new Detail("Выпускной клапан", 308, "Bark_auto_dvig1_zap1", "Есть в наличии"));
        detailsFor_Auto_Z18XEE.add(new Detail("Картер", 405, "Bark_auto_dvig1_zap2", "Есть в наличии"));
        detailsFor_Auto_Z18XEE.add(new Detail("Нижняя мотыль", 540, "Bark_auto_dvig1_zap3", "Есть на складе"));
        detailsFor_Auto_Z18XEE.add(new Detail("Крейцкопф", 204, "Bark_auto_dvig1_zap4", "Нет в наличии"));
        detailsFor_Auto_Z18XEE.add(new Detail("Шпилька", 150, "Bark_auto_dvig1_zap5", "Под заказ"));

        ArrayList<Detail> detailFor_Auto_4G63M4DE = new ArrayList<>();        //лист Деталей двиг авто(2)
        detailFor_Auto_4G63M4DE.add(new Detail("Шайбы", 106, "Bark_auto_dvig2_zap1", "Есть в наличии"));
        detailFor_Auto_4G63M4DE.add(new Detail("Цапфа", 415, "Bark_auto_dvig2_zap2", "Есть в наличии"));
        detailFor_Auto_4G63M4DE.add(new Detail("Сальники", 550, "Bark_auto_dvig2_zap3", "Есть в наличии"));
        detailFor_Auto_4G63M4DE.add(new Detail("Крейцкопф", 234, "Bark_auto_dvig2_zap4", "Есть в наличии"));
        detailFor_Auto_4G63M4DE.add(new Detail("Шпилька", 250, "Bark_auto_dvig2_zap5", "Есть в наличии"));
////////////////////лодки
        ArrayList<Detail> detailFor_Boat_55FT = new ArrayList<>();        //лист Деталей двиг лодок(1)
        detailFor_Boat_55FT.add(new Detail("Шайбы лодочные", 1206, "Bark_boat_dvig1_zap1", "Есть в наличии"));
        detailFor_Boat_55FT.add(new Detail("Цапфа лодочная", 415, "Bark_boat_dvig1_zap2", "Есть в наличии"));
        detailFor_Boat_55FT.add(new Detail("Сальники лодочные", 550, "Bark_boat_dvig1_zap3", "Есть в наличии"));
        detailFor_Boat_55FT.add(new Detail("Крейцкопф лодочный", 234, "Bark_boat_dvig1_zap4", "Есть в наличии"));
        detailFor_Boat_55FT.add(new Detail("Шпилька лодочная", 250, "Bark_boat_dvig1_zap5", "Есть в наличии"));

        ArrayList<Detail> detailFor_Boat_99AS = new ArrayList<>();        //лист Деталей двиг лодок(2)
        detailFor_Boat_99AS.add(new Detail("Осушительный насос", 1700, "Bark_boat_dvig2_zap1", "Под заказ"));
        detailFor_Boat_99AS.add(new Detail("Компрессор", 1415, "Bark_boat_dvig2_zap2", "Нет в наличии"));
        detailFor_Boat_99AS.add(new Detail("Сальники лодочные", 1211, "Bark_boat_dvig2_zap3", "Есть в наличии"));
        detailFor_Boat_99AS.add(new Detail("Крейцкопф лодочный", 1112, "Bark_boat_dvig2_zap4", "Нет в наличии"));
        detailFor_Boat_99AS.add(new Detail("Бойлер", 955, "Bark_boat_dvig2_zap5", "Есть в наличии"));
///////////////////мопеды
        ArrayList<Detail> detailFor_Moped_alpha100 = new ArrayList<>();        //лист Деталей двиг мопедов(1)
        detailFor_Moped_alpha100.add(new Detail("Блок цилиндра", 30, "Bark_moped_dvig1_zap1", "Нет в наличии"));
        detailFor_Moped_alpha100.add(new Detail("Картер", 50, "Bark_moped_dvig1_zap2", "Под заказ"));
        detailFor_Moped_alpha100.add(new Detail("Сальник", 10, "Bark_moped_dvig1_zap3", "Есть в наличии"));
        detailFor_Moped_alpha100.add(new Detail("Кикстартер", 22, "Bark_moped_dvig1_zap4", "Есть в наличии"));

        ArrayList<Detail> detailFor_Moped_alpha700 = new ArrayList<>();        //лист Деталей двиг мопедов(2)
        detailFor_Moped_alpha700.add(new Detail("Блок цилиндра", 60, "Bark_moped_dvig2_zap1", "Есть в наличии"));
        detailFor_Moped_alpha700.add(new Detail("Картер", 100, "Bark_moped_dvig2_zap2", "Есть в наличии"));
        detailFor_Moped_alpha700.add(new Detail("Сальник", 20, "Bark_moped_dvig2_zap3", "Есть в наличии"));
        detailFor_Moped_alpha700.add(new Detail("Кикстартер", 44, "Bark_moped_dvig2_zap4", "Есть в наличии"));

        //лист Автомобильных Моторов
        ArrayList<Motor> AutosMotorList = new ArrayList<>();
        AutosMotorList.add(new Motor("Z18XEE", "140 л.с.", "V(1.4)", detailsFor_Auto_Z18XEE));
        AutosMotorList.add(new Motor("4G63M4DE", "180 л.с", "V(1.8)", detailFor_Auto_4G63M4DE));

        //лист Лодочных Моторов
        ArrayList<Motor> AutosBoatsList = new ArrayList<>();
        AutosBoatsList.add(new Motor("55FT", "110 л.с.", "V(1.1)", detailFor_Boat_55FT));
        AutosBoatsList.add(new Motor("99AS", "120 л.с", "V(1.2)", detailFor_Boat_99AS));

        //лист Мопедных Моторов
        ArrayList<Motor> AutosMopedsList = new ArrayList<>();
        AutosMopedsList.add(new Motor("alpha100", "40 л.с.", "V(0.4)", detailFor_Moped_alpha100));
        AutosMopedsList.add(new Motor("alpha700", "70 л.с", "V(0.7)", detailFor_Moped_alpha700));

        //лист Транспорта (parentList)
        ArrayList<Transport> transportList = new ArrayList<>();
        transportList.add(new Transport("Автомобили", AutosMotorList));
        transportList.add(new Transport("Лодки", AutosBoatsList));
        transportList.add(new Transport("Мопеды", AutosMopedsList));

        expandableCategoryRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(getApplicationContext(), transportList);

        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); //присвоение рец.вью лайоутМэнеджера

        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter); //присвоение рец.вью адаптера

    }


//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        expandableCategoryRecyclerViewAdapter.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        expandableCategoryRecyclerViewAdapter.onRestoreInstanceState(savedInstanceState);
//    }
}
