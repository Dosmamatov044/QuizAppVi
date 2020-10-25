package com.example.AdapterHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizappvi.ui.fragments.History.History;
import com.example.quizappvi.R;

import java.util.List;

public class AdapterH  extends RecyclerView.Adapter<AdapterH.ViewHolderH>  {
    private List<History> list ;
Listener listener;
public AdapterH(Listener listener) {
        this.listener = listener;
    }



    public void updateList(List<History> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View layoutInflater=  LayoutInflater.from(parent.getContext()).inflate(R.layout.listh,parent,false);


        return new ViewHolderH(layoutInflater,listener)  ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderH holder, final int position) {

        holder.historyBind(list.get(position));

        /*         list.remove(position);
                 notifyItemRemoved(position);
                 notifyItemRangeChanged(position,list.size());*/



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class ViewHolderH extends RecyclerView.ViewHolder {






        private TextView textClock;
        private TextView textCorrectAnswers;
        private TextView textDifficulty;
        private TextView textEasy;
    private ImageButton imageButton;
        TextView textCategory;

    private static  final String TAG="MyViewHolder";
RelativeLayout relativeLayout;
public Context context;


        Listener listener;
        public ViewHolderH(@NonNull View itemView,Listener listener) {
            super(itemView);
           this.listener=listener;

             textCategory = itemView.findViewById(R.id.category);

            textClock=itemView.findViewById(R.id.clock);
            textCorrectAnswers=itemView.findViewById(R.id.correct_answers);
            textDifficulty=itemView.findViewById(R.id.difficulty);
            textEasy=itemView.findViewById(R.id.easy);
             relativeLayout=itemView.findViewById(R.id.rel);
imageButton=itemView.findViewById(R.id.menu_dots);

imageButton=itemView.findViewById(R.id.menu_dots);
                imageButton.setOnClickListener(v -> listener.onClick(v,getAdapterPosition())); }

        public void historyBind(History history) {

            textCategory.setText(history.getCategory());
           textCorrectAnswers.setText(history.getCorrectAnswer() + "/" + history.getAmount());
            textDifficulty.setText(history.getDifficulty());
            textClock.setText(history.getCreateAt().toLocaleString());
        }
    }

    public interface Listener {
        void onClick(View view, int id);
    }}
