package com.luiztorres.desafio_mobile_android.presentation.di.components;

import android.content.Context;

import com.luiztorres.desafio_mobile_android.data.di.modules.ManagerModule;
import com.luiztorres.desafio_mobile_android.data.di.modules.NetworkModule;
import com.luiztorres.desafio_mobile_android.data.di.modules.ServicesModule;
import com.luiztorres.desafio_mobile_android.domain.di.modules.UseCaseModules;
import com.luiztorres.desafio_mobile_android.domain.usecase.ListRepositoriesUseCase;
import com.luiztorres.desafio_mobile_android.domain.usecase.PullRequestsUseCase;
import com.luiztorres.desafio_mobile_android.presentation.di.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dindal on 10-Nov-17.
 */

@Singleton
@Component(modules = {MainModule.class, ServicesModule.class, UseCaseModules.class, ManagerModule.class, NetworkModule.class})
public interface ApplicationComponent {
    Context getContext();

    ListRepositoriesUseCase getListRepositoriesUseCase();

    PullRequestsUseCase getPullRequestsUseCase();
}
