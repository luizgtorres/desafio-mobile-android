package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.di.modules;

import com.luiztorres.desafio_mobile_android.domain.usecase.PullRequestsUseCase;
import com.luiztorres.desafio_mobile_android.presentation.di.scopes.PerView;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsContract;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dindal on 12-Nov-17.
 */

@Module
public class PullRequestsModules {
    PullRequestsContract.View view;

    public PullRequestsModules(PullRequestsContract.View view) {
        this.view = view;
    }

    @PerView
    @Provides
    PullRequestsContract.Presenter providesPullRequestsPresenter(PullRequestsUseCase pullRequestsUseCase) {
        PullRequestsContract.Presenter presenter = new PullRequestsPresenter(pullRequestsUseCase);
        presenter.attachView(view);
        return presenter;
    }
}
