package com.sonim.gifproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sonim.gifproject.R;

/**
 * Created by rishikesh.p on 14-08-2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private int[] mImages;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, int[] images) {
        this.mImages = images;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder.mImageView != null)
            Glide.with(mContext).asGif().load(mImages[position]).into(holder.mImageView);
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private int mClickedPosition;


        protected ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
        }

        void bindData(final int position) {
            mClickedPosition = position;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mClickedPosition);
        }
    }

    public int getItem(int id) {
        return mImages[id];
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
