package com.luiztorres.desafio_mobile_android.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.luiztorres.desafio_mobile_android.R;
import com.luiztorres.desafio_mobile_android.presentation.application.MainApplication;
import com.luiztorres.desafio_mobile_android.presentation.di.components.ApplicationComponent;

/**
 * Created by Dindal on 10-Nov-17.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {
    private RelativeLayout progressBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public abstract void injectDependencies();

    public ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    public ViewGroup getMainViewGroup() {
        return (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
    }

    public void addProgressBar() {
        progressBarLayout = (RelativeLayout) LayoutInflater.from(getMainViewGroup().getContext())
                .inflate(R.layout.layout_progress_bar, getMainViewGroup(), false);

        getMainViewGroup().addView(progressBarLayout);
    }

    @Override
    public void showProgress() {
        if (progressBarLayout != null)
            progressBarLayout.setVisibility(View.VISIBLE);
        else
            throw new ProgressBarNotAttachedExcpetion();
    }

    @Override
    public void hideProgress() {
        if (progressBarLayout != null)
            progressBarLayout.setVisibility(View.GONE);
        else
            throw new ProgressBarNotAttachedExcpetion();
    }

}
