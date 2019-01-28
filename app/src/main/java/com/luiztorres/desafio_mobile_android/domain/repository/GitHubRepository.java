package com.luiztorres.desafio_mobile_android.domain.repository;

import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.ListRepositoriesResponse;
import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Dindal on 10-Nov-17.
 */

public interface GitHubRepository {
    Observable<Response<ListRepositoriesResponse>> listRepositories(Integer page);

    Observable<Response<ArrayList<PullRequest>>> listPullRequests(Integer page, String owner, String repositoryName);
}
