package com.luiztorres.desafio_mobile_android.data.di.modules;

import com.luiztorres.desafio_mobile_android.data.services.GitHubService;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

/**
 * Created by Dindal on 11-Nov-17.
 */

@Module
public class ServicesModule {

    @Provides
    @Reusable
    public GitHubService providesGitHubService(Retrofit retrofit) {
        return retrofit.create(GitHubService.class);
    }
}
