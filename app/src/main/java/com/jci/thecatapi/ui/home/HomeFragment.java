package com.jci.thecatapi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jci.thecatapi.CatAdapter;
import com.jci.thecatapi.R;
import com.jci.thecatapi.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private HomeViewModel viewModel;
    private CatAdapter catAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModel = new HomeViewModel();

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

        View root = binding.getRoot();

        viewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.cats)
                    catAdapter.setList(viewModel.getCats());
            }
        });

        catAdapter = new CatAdapter(viewModel.getCats(), position -> viewModel.Selected(getContext(), viewModel.getCats().get(position)));

        RecyclerView listViewCats = (RecyclerView)root.findViewById(R.id.listViewCats);
        listViewCats.setHasFixedSize(true);
        listViewCats.setLayoutManager(new LinearLayoutManager(getContext()));
        listViewCats.setAdapter(catAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}