package com.example.quizappvi.ui.fragments.settings;


import android.view.LayoutInflater;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quizappvi.databinding.ListThemeBinding;

import java.util.List;



public class ListThemeAdapter extends RecyclerView.Adapter<ListThemeAdapter.Holder> {
    private List<ThemeModel> list;
    private ThemeListener lister;

    public ListThemeAdapter(List<ThemeModel> list) {

        this.list = list;
    }

    public void setListener(ThemeListener lister){
        this.lister =lister;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListThemeBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                .inflate(com.example.quizappvi.R.layout.list_theme, parent, false));
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ListThemeBinding binding;

        public Holder(ListThemeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void onBind(ThemeModel model) {
            binding.checkbox.setChecked(model.isItCheckout());
            binding.image.setBackgroundResource(model.getColor());
            binding.checkbox.setOnCheckedChangeListener((compoundButton, b) -> {
               lister.onClick(getAdapterPosition());
            });
        }
    }
}
