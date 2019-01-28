package com.luiztorres.desafio_mobile_android.presentation.application;

import android.app.Application;

import com.luiztorres.desafio_mobile_android.data.di.modules.ManagerModule;
import com.luiztorres.desafio_mobile_android.data.di.modules.NetworkModule;
import com.luiztorres.desafio_mobile_android.data.di.modules.ServicesModule;
import com.luiztorres.desafio_mobile_android.domain.di.modules.UseCaseModules;
import com.luiztorres.desafio_mobile_android.presentation.di.components.ApplicationComponent;
import com.luiztorres.desafio_mobile_android.presentation.di.components.DaggerApplicationComponent;
import com.luiztorres.desafio_mobile_android.presentation.di.modules.MainModule;

/**
 * Created by Dindal on 10-Nov-17.
 */

public class MainApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjection();
    }

    private void initializeInjection() {

        applicationComponent = DaggerApplicationComponent.builder()
                .mainModule(new MainModule(this))
                .networkModule(new NetworkModule())
                .servicesModule(new ServicesModule())
                .managerModule(new ManagerModule())
                .useCaseModules(new UseCaseModules())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
