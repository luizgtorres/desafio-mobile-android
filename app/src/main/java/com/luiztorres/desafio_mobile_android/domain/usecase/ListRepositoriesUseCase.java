package com.luiztorres.desafio_mobile_android.domain.usecase;

import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.ListRepositoriesResponse;
import com.luiztorres.desafio_mobile_android.domain.repository.GitHubRepository;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Dindal on 11-Nov-17.
 */

public class ListRepositoriesUseCase {

    @Inject
    public GitHubRepository gitHubManager;

    public ListRepositoriesUseCase(GitHubRepository gitHubManager) {
        this.gitHubManager = gitHubManager;
    }

    public Observable<Response<ListRepositoriesResponse>> listRepositories(Integer page) {
        return gitHubManager.listRepositories(page);
    }
}
