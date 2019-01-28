package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.di.modules;

import com.luiztorres.desafio_mobile_android.domain.usecase.ListRepositoriesUseCase;
import com.luiztorres.desafio_mobile_android.presentation.di.scopes.PerView;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.ListRepositoriesContract;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.ListRepositoriesPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dindal on 10-Nov-17.
 */

@Module
public class ListRepositoriesModule {
    ListRepositoriesContract.View view;

    public ListRepositoriesModule(ListRepositoriesContract.View view) {
        this.view = view;
    }

    @Provides
    @PerView
    public ListRepositoriesContract.Presenter providesPresenter(ListRepositoriesUseCase listRepositoriesUseCase) {

        ListRepositoriesContract.Presenter presenter = new ListRepositoriesPresenter(listRepositoriesUseCase);
        presenter.attachView(view);
        return presenter;
    }
}
