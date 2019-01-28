package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories;

import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.Repository;
import com.luiztorres.desafio_mobile_android.presentation.base.MvpPresenter;
import com.luiztorres.desafio_mobile_android.presentation.base.MvpView;

import java.util.ArrayList;

/**
 * Created by Dindal on 10-Nov-17.
 */

public interface ListRepositoriesContract {
    interface View extends MvpView {
        void showRepoList(ArrayList<Repository> repositoryList, Boolean hasMoreItems);
    }

    interface Presenter extends MvpPresenter<View> {
        void requestRepoList();
    }
}
