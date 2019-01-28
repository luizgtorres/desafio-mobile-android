package com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.di.component;

import com.luiztorres.desafio_mobile_android.presentation.di.components.ApplicationComponent;
import com.luiztorres.desafio_mobile_android.presentation.di.scopes.PerView;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.PullRequestsActivity;
import com.luiztorres.desafio_mobile_android.presentation.ui.pullrequests.di.modules.PullRequestsModules;

import dagger.Component;

/**
 * Created by Dindal on 12-Nov-17.
 */

@PerView
@Component(dependencies = ApplicationComponent.class, modules = PullRequestsModules.class)
public interface PullRequestsComponent {
    void inject(PullRequestsActivity activity);
}
