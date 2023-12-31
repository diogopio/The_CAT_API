package com.jci.thecatapi.ui.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jci.thecatapi.BR;
import com.jci.thecatapi.CatAdapter;
import com.jci.thecatapi.CatModule;
import com.jci.thecatapi.R;
import com.jci.thecatapi.components.DaggerHomeFragmentComponent;
import com.jci.thecatapi.databinding.FragmentHomeBinding;
import com.jci.thecatapi.model.Cat;
import com.jci.thecatapi.ui.detail.DetailActivity;

import javax.inject.Inject;

public class HomeFragment extends Fragment {
    @Inject
    public HomeViewModel viewModel;
    private CatAdapter catAdapter;
    private FragmentHomeBinding binding;
    private RecyclerView listViewCats;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DaggerHomeFragmentComponent.builder().catModule(new CatModule(requireContext())).build().inject(this);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        View root = binding.getRoot();
        listViewCats = root.findViewById(R.id.listViewCats);
        listViewCats.setHasFixedSize(true);
        listViewCats.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.search){
                    viewModel.loadCats();
                }
                if (propertyId == BR.cats) {
                    requireContext().getMainExecutor().execute(() -> {
                        if (catAdapter == null) {
                            catAdapter = new CatAdapter(viewModel.getCats(), onCatClicked);
                        } else
                            catAdapter.setList(viewModel.getCats());
                        listViewCats.setAdapter(catAdapter);
                    });
                }
            }
        });
        return root;
    }

    CatAdapter.OnClickItemListener onCatClicked = new CatAdapter.OnClickItemListener() {
        @Override
        public void onClick(int position) {
            Cat cat = catAdapter.get(position);
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra("id", cat.getCatId());
            requireContext().startActivity(intent);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        viewModel.loadCats();
    }

    @Override
    public void onDestroyView() {
        viewModel = null;
        catAdapter = null;
        binding = null;
        listViewCats = null;
        super.onDestroyView();
    }
}