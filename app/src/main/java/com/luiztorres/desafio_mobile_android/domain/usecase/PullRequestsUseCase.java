package com.luiztorres.desafio_mobile_android.domain.usecase;

import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;
import com.luiztorres.desafio_mobile_android.domain.repository.GitHubRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequestsUseCase {

    @Inject
    GitHubRepository gitHubManager;

    public PullRequestsUseCase(GitHubRepository gitHubManager) {
        this.gitHubManager = gitHubManager;
    }

    public Observable<Response<ArrayList<PullRequest>>> listPullRequests(Integer page, String owner, String repoName) {
        return gitHubManager.listPullRequests(page, owner, repoName);
    }


}
