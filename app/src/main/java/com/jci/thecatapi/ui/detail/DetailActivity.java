package com.jci.thecatapi.ui.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jci.thecatapi.CatModule;
import com.jci.thecatapi.R;
import com.jci.thecatapi.components.DaggerDetailActivityComponent;
import com.jci.thecatapi.databinding.ActivityDetailBinding;

import java.util.Objects;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {
    @Inject
    public DetailViewModel viewModel;
    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerDetailActivityComponent.builder().catModule(new CatModule(this)).build().inject(this);

        int catId = getIntent().getIntExtra("id", -1);
        if (catId == -1) {
            Toast.makeText(this, "Cat not found.", Toast.LENGTH_LONG).show();
            finish();
        }

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