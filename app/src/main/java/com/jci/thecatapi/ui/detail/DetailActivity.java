package com.jci.thecatapi.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.jci.thecatapi.R;
import com.jci.thecatapi.database.CatDatabase;
import com.jci.thecatapi.databinding.ActivityDetailBinding;
import com.jci.thecatapi.model.Cat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int catId = getIntent().getIntExtra("id", 0);

        Cat cat = CatDatabase.GetById(catId);

        DetailViewModel viewModel = new DetailViewModel(cat);

        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}