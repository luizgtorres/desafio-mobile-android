package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests;

import com.luiztorres.desafio_mobile_android.domain.usecase.PullRequestsUseCase;
import com.luiztorres.desafio_mobile_android.presentation.base.BasePresenter;
import com.luiztorres.desafio_mobile_android.presentation.util.HeaderResponseUtil;

import javax.inject.Inject;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequestsPresenter extends BasePresenter<PullRequestsContract.View> implements PullRequestsContract.Presenter {

    @Inject
    PullRequestsUseCase pullRequestsUseCase;

    private String ownerName, repositoryName;

    Integer pullRequestListPage = 0;

    public PullRequestsPresenter(PullRequestsUseCase pullRequestsUseCase) {
        this.pullRequestsUseCase = pullRequestsUseCase;
    }

    @Override
    public void requestPullRequests() {
        getView().showProgress();

        pullRequestsUseCase.listPullRequests(pullRequestListPage, ownerName, repositoryName)
                .subscribe(response -> {
                    Boolean hasNextPage = HeaderResponseUtil.hasNextPage(response.headers());

                    getView().showPullRequests(response.body(), hasNextPage);
                    getView().hideProgress();

                    pullRequestListPage++;
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

    @Override
    public void updateInfo(String owner, String repositoryName) {
        this.ownerName = owner;
        this.repositoryName = repositoryName;
    }
}
