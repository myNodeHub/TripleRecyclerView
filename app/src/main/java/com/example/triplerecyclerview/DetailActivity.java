package com.example.triplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView detailNameLast, detailCost, detailBarcode, detailAvailability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Информация о товаре");

        detailNameLast = findViewById(R.id.detailNameLast);
        detailCost = findViewById(R.id.detailCost);
        detailBarcode = findViewById(R.id.detailBarcode);
        detailAvailability = findViewById(R.id.detailAvailability);



        Bundle arguments = getIntent().getExtras();
        final Detail detail;
        if (arguments != null) {
            detail = arguments.getParcelable("detail");

            detailNameLast.setText("Название: " + detail.getDetailName());
            detailCost.setText("Цена: " + detail.getDetailCost());
            detailBarcode.setText("Штрихкод: " + detail.getDetailBarcode());
            detailAvailability.setText("Наличие: " + detail.getDetailAvailability());

        }
    }
}
