package com.jci.thecatapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jci.thecatapi.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{

    public interface OnClickItemListener {
        void onClick(int position);
    }
    private List<Cat> list;
    OnClickItemListener clickListener;
    public CatAdapter(List<Cat> cats, OnClickItemListener clickListener){
        list = new ArrayList<>();
        this.list.addAll(cats);
        this.clickListener = clickListener;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewOrigin;
        ImageView imageViewPicture;
        View view;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewOrigin = itemView.findViewById(R.id.textViewOrigin);
            imageViewPicture = itemView.findViewById(R.id.imageViewPicture);
            view = itemView;
        }
    }

    public void setList(List<Cat> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_row, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {

        final int index = holder.getAdapterPosition();

        holder.textViewName.setText(list.get(position).getName());
        holder.textViewOrigin.setText(list.get(position).getOrigin());
        holder.imageViewPicture.setImageResource(list.get(position).getImageId());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
