package com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.di.component;

import com.luiztorres.desafio_mobile_android.presentation.di.components.ApplicationComponent;
import com.luiztorres.desafio_mobile_android.presentation.di.scopes.PerView;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.ListRepositoriesActivity;
import com.luiztorres.desafio_mobile_android.presentation.ui.listrepositories.di.modules.ListRepositoriesModule;

import dagger.Component;

/**
 * Created by Dindal on 10-Nov-17.
 */

@PerView
@Component(dependencies = ApplicationComponent.class, modules = ListRepositoriesModule.class)
public interface ListRepositoriesComponent {
    void inject(ListRepositoriesActivity listRepositoriesitoriesActivity);
}
