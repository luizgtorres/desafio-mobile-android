package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests;

import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;
import com.luiztorres.desafio_mobile_android.presentation.base.MvpPresenter;
import com.luiztorres.desafio_mobile_android.presentation.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Dindal on 12-Nov-17.
 */

public interface PullRequestsContract {
    interface View extends MvpView {
        void showPullRequests(ArrayList<PullRequest> pullRequestList, Boolean hasNextPage);
    }

    interface Presenter extends MvpPresenter<View> {
        void requestPullRequests();

        void updateInfo(String owner, String repositoryName);
    }
}
