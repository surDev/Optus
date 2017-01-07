package com.wipro.optus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wipro.optus.R;
import com.wipro.optus.interfaces.OnRecyclerItemClickListener;

/**
 * Created by SO356253 on 02-Jan-17.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    Context context;
    OnRecyclerItemClickListener onRecyclerItemClickListener;

    public ItemAdapter(Context context) {
        this.context = context;
        this.onRecyclerItemClickListener = (OnRecyclerItemClickListener) context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.view_item, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != onRecyclerItemClickListener){
                    onRecyclerItemClickListener.onRecyclerItemSelected(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_item);
        }
    }
}
