package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories;

import com.luiztorres.desafio_mobile_android.domain.usecase.ListRepositoriesUseCase;
import com.luiztorres.desafio_mobile_android.presentation.base.BasePresenter;
import com.luiztorres.desafio_mobile_android.presentation.util.HeaderResponseUtil;

import javax.inject.Inject;

/**
 * Created by Dindal on 10-Nov-17.
 */

public class ListRepositoriesPresenter extends BasePresenter<ListRepositoriesContract.View> implements ListRepositoriesContract.Presenter {

    @Inject
    ListRepositoriesUseCase listRepositoriesUseCase;

    Integer listRepositoriesPage = 1;

    public ListRepositoriesPresenter(ListRepositoriesUseCase listRepositoriesUseCase) {
        this.listRepositoriesUseCase = listRepositoriesUseCase;
    }

    @Override
    public void requestRepoList() {
        if (listRepositoriesPage == 1) {
            getView().showProgress();
        }

        listRepositoriesUseCase.listRepositories(listRepositoriesPage)
                .subscribe(response -> {
                    Boolean hasMoreItems = HeaderResponseUtil.hasNextPage(response.headers());

                    getView().showRepoList(response.body().items, hasMoreItems);
                    getView().hideProgress();

                    listRepositoriesPage++;
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }
}
