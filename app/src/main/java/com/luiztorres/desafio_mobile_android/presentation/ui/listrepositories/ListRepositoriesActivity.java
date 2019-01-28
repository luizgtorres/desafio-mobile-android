package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.Repository;
import com.luiztorres.desafio_mobile_android.presentation.base.BaseActivity;
import com.luiztorres.desafio_mobile_android.presentation.base.listeners.OnClickCardListener;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.adapter.ListRepositoriesAdapter;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.di.component.DaggerListRepositoriesComponent;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.di.modules.ListRepositoriesModule;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsActivity.PULL_REQUEST_REPOSITORY_NAME;
import static com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsActivity.PULL_REQUEST_REPOSITORY_OWNER_NAME;

public class ListRepositoriesActivity extends BaseActivity implements ListRepositoriesContract.View, OnClickCardListener {

    @Inject
    ListRepositoriesContract.Presenter presenter;

    @BindView(R.id.listRepositoriesRecyclerView)
    RecyclerView listRecyclerView;

    @BindView(R.id.listRepositoriesToolbar)
    Toolbar toolbar;

    private boolean loadingRepoList = false, hasMoreItems = true;

    Integer firstItemVisible = 0, visibleItemCount, totalItemCount;

    private ListRepositoriesAdapter listAdapter;
    private LinearLayoutManager listManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositories);
        ButterKnife.bind(this);
        setupListRepositoriesRecyclerView();
        addProgressBar();

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle("Github JavaPop");
        }

        presenter.requestRepoList();
    }

    @Override
    public void injectDependencies() {
        DaggerListRepositoriesComponent.builder()
                .applicationComponent(getApplicationComponent())
                .listRepositoriesModule(new ListRepositoriesModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void showRepoList(ArrayList<Repository> repositoryList, Boolean hasMoreItems) {
        listAdapter.updateRepositoryList(repositoryList);
        listAdapter.notifyDataSetChanged();
        loadingRepoList = false;
        this.hasMoreItems = hasMoreItems;
    }

    @Override
    public void cardClicked(Integer position) {
        Intent pullRequestIntent = new Intent(this, PullRequestsActivity.class);
        pullRequestIntent.putExtra(PULL_REQUEST_REPOSITORY_NAME, listAdapter.getRepositoryAtPosition(position).name);
        pullRequestIntent.putExtra(PULL_REQUEST_REPOSITORY_OWNER_NAME, listAdapter.getRepositoryAtPosition(position).owner.name);
        startActivity(pullRequestIntent);
    }

    void setupListRepositoriesRecyclerView() {
        listRecyclerView.setHasFixedSize(true);

        listManager = new LinearLayoutManager(this);
        listRecyclerView.setLayoutManager(listManager);

        listAdapter = new ListRepositoriesAdapter(this);
        listRecyclerView.setAdapter(listAdapter);

        listRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = listManager.getChildCount();
                    totalItemCount = listManager.getItemCount();
                    firstItemVisible = listManager.findFirstVisibleItemPosition();

                    if (!loadingRepoList && hasMoreItems) {
                        if ((visibleItemCount + firstItemVisible) >= (totalItemCount * 0.7)) {
                            loadingRepoList = true;
                            presenter.requestRepoList();
                        }
                    }
                }
            }
        });
    }
}
