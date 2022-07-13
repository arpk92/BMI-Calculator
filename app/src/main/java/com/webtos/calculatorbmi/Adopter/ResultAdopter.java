package com.webtos.calculatorbmi.Adopter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.webtos.calculatorbmi.Model.ResultModel;
import com.webtos.calculatorbmi.R;

import java.util.ArrayList;

public class ResultAdopter extends RecyclerView.Adapter<ResultAdopter.view_Holder>{

        ArrayList <ResultModel> arrayList;
        Context context;

    public ResultAdopter(ArrayList<ResultModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public view_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.result_layout , parent , false);
        return new view_Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdopter.view_Holder holder, int position) {

        ResultModel resultModel  = arrayList.get(position);

        holder.textView_date.setText(resultModel.getDate());
        holder.textView_result.setText(resultModel.getResult());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class view_Holder extends RecyclerView.ViewHolder {

        TextView textView_date;
        TextView textView_result;
        public view_Holder(@NonNull View itemView) {



            super(itemView);

            textView_date =itemView.findViewById(R.id.textView_date);
            textView_result = itemView.findViewById(R.id.textView_final_result);
        }
    }


}



