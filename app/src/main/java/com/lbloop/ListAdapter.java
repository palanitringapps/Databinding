package com.lbloop;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lbloop.databinding.ListImageAloneBinding;
import com.lbloop.databinding.ListItemBinding;
import com.lbloop.databinding.ListNewItemBinding;
import com.lbloop.model.Movie;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(final int id, final Movie movie);
    }

    public static class AllViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        AllViewHolder(final ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        private final ListNewItemBinding binding;

        TextViewHolder(final ListNewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ListImageAloneBinding binding;

        ImageViewHolder(final ListImageAloneBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private final List<Movie> movies;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    public ListAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        switch (movies.get(i).getItemType()) {
            case 2:
                TextViewHolder textViewHolder = (TextViewHolder) viewHolder;
                textViewHolder.binding.setMovie(movies.get(i));
                textViewHolder.binding.setClicklistener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(i, movies.get(i));
                        }
                    }
                });
                break;
            case 3:
                ImageViewHolder holder = (ImageViewHolder) viewHolder;
                holder.binding.setMovie(movies.get(i));
                holder.binding.setClicklistener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(i, movies.get(i));
                        }
                    }
                });
                break;
            case 1:
            default:
                AllViewHolder allViewHolder = (AllViewHolder) viewHolder;
                allViewHolder.binding.setMovie(movies.get(i));
                allViewHolder.binding.setClicklistener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null) {
                            onItemClickListener.onItemClick(i, movies.get(i));
                        }
                    }
                });
                break;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        switch (i) {

            case 2:
                final ListNewItemBinding binding1 = DataBindingUtil.inflate(layoutInflater, R.layout.list_new_item, viewGroup, false);
                return new TextViewHolder(binding1);
            case 3:
                final ListImageAloneBinding binding2 = DataBindingUtil.inflate(layoutInflater, R.layout.list_image_alone, viewGroup, false);
                return new ImageViewHolder(binding2);
            case 1:
                //break the rule
            default:
                final ListItemBinding binding =
                        DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
                return new AllViewHolder(binding);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return movies.get(position).getItemType();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
