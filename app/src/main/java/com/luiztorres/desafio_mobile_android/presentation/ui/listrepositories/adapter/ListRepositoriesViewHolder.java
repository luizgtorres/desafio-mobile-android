package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Dindal on 11-Nov-17.
 */

public class ListRepositoriesViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.listRepositoryName)
    public AppCompatTextView repositoryName;

    @BindView(R.id.listRepositoryDescription)
    public AppCompatTextView repositoryDescription;

    @BindView(R.id.listOwnerName)
    public AppCompatTextView ownerName;

    @BindView(R.id.listForkText)
    public AppCompatTextView forkCount;

    @BindView(R.id.listStarText)
    public AppCompatTextView starCount;

    @BindView(R.id.listPhotoOwner)
    public CircleImageView photoOwner;

    private OnClickCardListener onClickCardListener;

    private View view;

    public ListRepositoriesViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        this.view = view;
    }

    public void setOnClickCardListener(OnClickCardListener onClickCardListener, Integer position) {
        this.onClickCardListener = onClickCardListener;

        view.setOnClickListener(view1 -> onClickCardListener.cardClicked(position));
    }
}
