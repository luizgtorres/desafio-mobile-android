package com.luiztorres.desafio_mobile_android.data.manager;

import com.luiztorres.desafio_mobile_android.data.services.GitHubService;
import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.ListRepositoriesResponse;
import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;
import com.luiztorres.desafio_mobile_android.domain.repository.GitHubRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Dindal on 11-Nov-17.
 */

public class GitHubManager implements GitHubRepository {

    @Inject
    GitHubService gitHubService;

    public GitHubManager(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @Override
    public Observable<Response<ListRepositoriesResponse>> listRepositories(Integer page) {
        return gitHubService.listRepositories(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<Response<ArrayList<PullRequest>>> listPullRequests(Integer page, String owner, String repositoryName) {
        return gitHubService.listPullRequests(owner, repositoryName, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
