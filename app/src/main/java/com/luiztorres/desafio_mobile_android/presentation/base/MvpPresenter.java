package com.luiztorres.desafio_mobile_android.presentation.base;

/**
 * Created by Dindal on 10-Nov-17.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}