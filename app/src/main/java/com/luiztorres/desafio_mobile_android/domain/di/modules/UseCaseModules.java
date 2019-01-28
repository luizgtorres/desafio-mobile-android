package com.luiztorres.desafio_mobile_android.domain.di.modules;

import com.luiztorres.desafio_mobile_android.domain.repository.GitHubRepository;
import com.luiztorres.desafio_mobile_android.domain.usecase.ListRepositoriesUseCase;
import com.luiztorres.desafio_mobile_android.domain.usecase.PullRequestsUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dindal on 11-Nov-17.
 */

@Module
public class UseCaseModules {

    @Provides
    public ListRepositoriesUseCase providesListRepositoriesitoriesUseCase(GitHubRepository gitHubManager) {
        return new ListRepositoriesUseCase(gitHubManager);
    }

    @Provides
    public PullRequestsUseCase providesPullRequestsUseCase(GitHubRepository gitHubManager) {
        return new PullRequestsUseCase(gitHubManager);
    }
}
