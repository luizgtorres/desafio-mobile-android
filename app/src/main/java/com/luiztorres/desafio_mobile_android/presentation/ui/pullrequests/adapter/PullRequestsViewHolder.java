package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequestsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.pullRequestsName)
    public AppCompatTextView pullRequestName;

    @BindView(R.id.pullRequestsDescription)
    public AppCompatTextView pullRequestDescription;

    @BindView(R.id.pullRequestsOwnerName)
    public AppCompatTextView pullRequestOwnerName;

    @BindView(R.id.pullRequestsPhotoOwner)
    public CircleImageView pullRequestPhotoOwner;

    private OnClickCardListener onClickCardListener;

    private View view;

    public PullRequestsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        this.view = view;
    }

    public void setOnClickCardListener(OnClickCardListener onClickCardListener, Integer position) {
        this.onClickCardListener = onClickCardListener;

        view.setOnClickListener(view1 -> onClickCardListener.cardClicked(position));
    }
}
