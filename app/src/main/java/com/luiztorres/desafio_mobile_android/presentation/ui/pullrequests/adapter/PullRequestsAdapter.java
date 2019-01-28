package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;

import java.util.ArrayList;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequestsAdapter extends RecyclerView.Adapter<PullRequestsViewHolder> {
    private ArrayList<PullRequest> pullRequestsList = new ArrayList<>();
    private OnClickCardListener onClickCardListener;

    public PullRequestsAdapter(OnClickCardListener onClickCardListener) {
        this.onClickCardListener = onClickCardListener;
    }

    @Override
    public PullRequestsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_pull_requests, parent, false);

        return new PullRequestsViewHolder(itemView);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(PullRequestsViewHolder holder, int position) {
        PullRequest pullRequestItem = pullRequestsList.get(position);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.placeholder(R.drawable.ic_owner_placeholder);

        Glide.with(holder.pullRequestName.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(pullRequestItem.owner.photoUrl)
                .into(holder.pullRequestPhotoOwner);

        holder.pullRequestOwnerName.setText(pullRequestItem.owner.name);
        holder.pullRequestDescription.setText(pullRequestItem.description);
        holder.pullRequestName.setText(pullRequestItem.title);

        holder.setOnClickCardListener(onClickCardListener, position);
    }

    @Override
    public int getItemCount() {
        return pullRequestsList.size();
    }

    public String getPullRequestURLAtPosition(Integer position) {
        return pullRequestsList.get(position).url;
    }

    public void updatePullRequestList(ArrayList<PullRequest> pullRequestsList) {
        this.pullRequestsList = pullRequestsList;
    }
}
