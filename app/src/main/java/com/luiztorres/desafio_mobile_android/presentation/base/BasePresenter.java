package com.luiztorres.desafio_mobile_android.presentation.base;

/**
 * Created by Dindal on 10-Nov-17.
 */

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private T view;

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public T getView() {
        checkViewAttached();
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new ViewNotAttachedException();
        }
    }

    private boolean isViewAttached() {
        return view != null;
    }

}