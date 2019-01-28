package com.luiztorres.desafio_mobile_android.data.di.modules;

import android.content.Context;

import com.luiztorres.desafio_mobile_android.data.manager.GitHubManager;
import com.luiztorres.desafio_mobile_android.data.manager.LocalManager;
import com.luiztorres.desafio_mobile_android.data.services.GitHubService;
import com.luiztorres.desafio_mobile_android.domain.repository.GitHubRepository;
import com.luiztorres.desafio_mobile_android.domain.repository.LocalRepository;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

/**
 * Created by Dindal on 11-Nov-17.
 */

@Module
public class ManagerModule {

    @Provides
    @Reusable
    public GitHubRepository providesGitHubManager(GitHubService gitHubService) {
        return new GitHubManager(gitHubService);
    }

    @Provides
    @Reusable
    public LocalRepository providesLocalManager(Context context) {
        return new LocalManager(context);
    }
}
