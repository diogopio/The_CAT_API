package com.jci.thecatapi.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.jci.thecatapi.R;
import com.jci.thecatapi.database.DatabaseClient;
import com.jci.thecatapi.databinding.ActivityDetailBinding;
import com.jci.thecatapi.services.CatService;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int catId = getIntent().getIntExtra("id", -1);
        if (catId == -1) {
            Toast.makeText(this, "Cat not found.", Toast.LENGTH_LONG).show();
            finish();
        }
        CatService catService = new CatService(DatabaseClient.getInstance(this).getAppDatabase());
        DetailViewModel viewModel = new DetailViewModel(catService);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setActionBar(toolbar);
        Objects.requireNonNull(getActionBar()).setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        toolbar.setNavigationOnClickListener(v -> finish());
        viewModel.loadCat(catId);
    }
}