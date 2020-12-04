package com.example.gym_application.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gym_application.Models.MyListDataDitails;
import com.example.gym_application.R;


public class MyListAdapterDitails extends RecyclerView.Adapter<MyListAdapterDitails.ViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(MyListDataDitails item, int adapterPosition);
    }

    private MyListDataDitails[] listdata;
    private Context context;
    private final OnItemClickListener listener;

    // RecyclerView recyclerView;
    public MyListAdapterDitails(MyListDataDitails[] listdata, Context context, OnItemClickListener listener) {
        this.listdata = listdata;
        this.context = context;
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.ditials_mylist, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(listdata[position],  listener);

//        final MyListDataDitails myListData = listdata[position];
//        holder.textView1.setText(listdata[position].getDescription());
//        holder.textView2.setText(listdata[position].getSize());
//        holder.imageView1.setImageResource(listdata[position].getImgId());
//        holder.imageView2.setImageResource(listdata[position].getExeimage());
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                    Toast.makeText(view.getContext(), "click on item: " + myListData.getDescription(), Toast.LENGTH_LONG).show();
//            }
//        });
    }





    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView1,imageView2;
        public TextView textView1,textView2;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView1 = (ImageView) itemView.findViewById(R.id.eaual_sign);
            this.imageView2 = (ImageView) itemView.findViewById(R.id.animate_image);
            this.textView1 = (TextView) itemView.findViewById(R.id.text_ditals_list);
            this.textView2 = (TextView) itemView.findViewById(R.id.pixle_number);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout1);

//            final float scale = relativeLayout.getContext().getResources().getDisplayMetrics().density;
//            int pixels = (int) (150 * scale + 0.5f);
//
//            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, pixels));


        }

        public void bind(final MyListDataDitails listdatum, final OnItemClickListener listener) {
            getAdapterPosition();
            textView1.setText(listdatum.getDescription());
            textView2.setText(listdatum.getSize());
            imageView1.setImageResource(listdatum.getImgId());
            imageView2.setImageResource(listdatum.getExeimage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(listdatum,getAdapterPosition());
                }
            });
        }


//        public void bind(final MyListDataDitails listdatum, final OnItemClickListener listener) {
//            textView1.setText(listdatum.getDescription());
//            textView2.setText(listdatum.getSize());
//            imageView1.setImageResource(listdatum.getImgId());
//            imageView2.setImageResource(listdatum.getExeimage());
//
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                    listener.onItemClick(listdatum);
//                }
//            });
//        }
    }
}