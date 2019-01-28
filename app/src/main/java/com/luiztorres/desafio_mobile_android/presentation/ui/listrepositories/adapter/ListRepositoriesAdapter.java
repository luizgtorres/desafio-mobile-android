package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.Repository;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;

import java.util.ArrayList;

/**
 * Created by Dindal on 11-Nov-17.
 */

public class ListRepositoriesAdapter extends RecyclerView.Adapter<ListRepositoriesViewHolder> {
    private ArrayList<Repository> repositoryList = new ArrayList<>();
    private OnClickCardListener onClickCardListener;

    public ListRepositoriesAdapter(OnClickCardListener onClickCardListener) {
        this.onClickCardListener = onClickCardListener;
    }

    @Override
    public ListRepositoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_repositories, parent, false);

        return new ListRepositoriesViewHolder(itemView);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(ListRepositoriesViewHolder holder, int position) {
        Repository repositoryItem = repositoryList.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.placeholder(R.drawable.ic_owner_placeholder);

        Glide.with(holder.ownerName.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(repositoryItem.owner.photoUrl)
                .into(holder.photoOwner);

        holder.ownerName.setText(repositoryItem.owner.name);
        holder.repositoryDescription.setText(repositoryItem.description);
        holder.repositoryName.setText(repositoryItem.name);
        holder.forkCount.setText(String.valueOf(repositoryItem.forks));
        holder.starCount.setText(String.valueOf(repositoryItem.stars));

        holder.setOnClickCardListener(onClickCardListener, position);
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public void updateRepositoryList(ArrayList<Repository> repositoryList) {
        if (repositoryList.isEmpty())
            this.repositoryList = repositoryList;
        else
            this.repositoryList.addAll(repositoryList);
    }

    public Repository getRepositoryAtPosition(Integer position) {
        return repositoryList.get(position);
    }
}
