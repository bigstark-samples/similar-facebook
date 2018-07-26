package com.bigstark.similarfacebook.app.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigstark.similarfacebook.R;
import com.bigstark.similarfacebook.model.PictureModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private List<PictureModel> items = new ArrayList<>();


    public void setItems(List<PictureModel> pictures) {
        items.clear();
        items.addAll(pictures);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_home, parent, false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class HomeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_picture) ImageView ivPicture;

        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(PictureModel picture) {
            RequestOptions cropOptions = new RequestOptions().centerCrop();

            Glide.with(ivPicture)
                    .load(String.format("https://picsum.photos/300/200?image=%d", picture.getId()))
                    .apply(cropOptions)
                    .into(ivPicture);
        }

    }

}
