package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;
import com.luiztorres.desafio_mobile_android.presentation.base.BaseActivity;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.adapter.PullRequestsAdapter;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.di.component.DaggerPullRequestsComponent;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.di.modules.PullRequestsModules;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequestsActivity extends BaseActivity implements PullRequestsContract.View, OnClickCardListener {

    @Inject
    PullRequestsContract.Presenter presenter;

    @BindView(R.id.pullRequestsRecyclerView)
    RecyclerView listRecyclerView;

    @BindView(R.id.pullRequestsToolbar)
    Toolbar toolbar;

    @BindView(R.id.pullRequestEmptyList)
    AppCompatTextView pullRequestEmptyList;

    private boolean loadingPullRequestList = false, hasMoreItems = true;
    Integer firstItemVisible = 0, visibleItemCount, totalItemCount;

    private PullRequestsAdapter listAdapter;
    private LinearLayoutManager listManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);
        ButterKnife.bind(this);
        setupPullRequestListRecyclerView();
        addProgressBar();

        setSupportActionBar(toolbar);

        String repositoryName = getIntent().getStringExtra(PULL_REQUEST_REPOSITORY_NAME);
        String ownerName = getIntent().getStringExtra(PULL_REQUEST_REPOSITORY_OWNER_NAME);

        presenter.updateInfo(ownerName, repositoryName);
        presenter.requestPullRequests();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(repositoryName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void cardClicked(Integer position) {
        Uri uri = Uri.parse(listAdapter.getPullRequestURLAtPosition(position));
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browserIntent);
    }

    @Override
    public void showPullRequests(ArrayList<PullRequest> pullRequestList, Boolean hasMoreItems) {
        if (pullRequestList.isEmpty()) {
            pullRequestEmptyList.setVisibility(View.VISIBLE);
            return;
        }

        listAdapter.updatePullRequestList(pullRequestList);
        listAdapter.notifyDataSetChanged();
        loadingPullRequestList = false;
        this.hasMoreItems = hasMoreItems;
    }

    @Override
    public void injectDependencies() {
        DaggerPullRequestsComponent.builder()
                .applicationComponent(getApplicationComponent())
                .pullRequestsModules(new PullRequestsModules(this))
                .build()
                .inject(this);
    }

    void setupPullRequestListRecyclerView() {
        listRecyclerView.setHasFixedSize(true);

        listManager = new LinearLayoutManager(this);
        listRecyclerView.setLayoutManager(listManager);

        listAdapter = new PullRequestsAdapter(this);
        listRecyclerView.setAdapter(listAdapter);

        listRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = listManager.getChildCount();
                    totalItemCount = listManager.getItemCount();
                    firstItemVisible = listManager.findFirstVisibleItemPosition();

                    if (!loadingPullRequestList && hasMoreItems) {
                        if ((visibleItemCount + firstItemVisible) >= (totalItemCount * 0.7)) {
                            loadingPullRequestList = true;
                            presenter.requestPullRequests();
                        }
                    }
                }
            }
        });
    }

    public static String PULL_REQUEST_REPOSITORY_NAME = "pullRequestsRepositoryName";
    public static String PULL_REQUEST_REPOSITORY_OWNER_NAME = "pullRequestsRepositoryOwnerName";
}
