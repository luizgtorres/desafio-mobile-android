package com.luiztorres.desafio_mobile_android.presentation.di.modules;

import android.content.Context;

import com.luiztorres.desafio_mobile_android.presentation.application.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dindal on 10-Nov-17.
 */

@Module
public class MainModule {
    MainApplication mainApplication;

    public MainModule(MainApplication storeApplication) {
        this.mainApplication = storeApplication;
    }

    @Singleton
    @Provides
    Context providesContext() {
        return this.mainApplication;
    }
}
