package com.luiztorres.desafio_mobile_android.data.services;

import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.ListRepositoriesResponse;
import com.luiztorres.desafio_mobile_android.domain.entity.pullrequests.PullRequest;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dindal on 10-Nov-17.
 */

public interface GitHubService {
    @GET("search/repositories?q=language:Java&sort=stars")
    Observable<Response<ListRepositoriesResponse>> listRepositories(@Query("page") Integer page);

    @GET("repos/{owner}/{repo}/pulls")
    Observable<Response<ArrayList<PullRequest>>> listPullRequests(@Path("owner") String owner, @Path("repo") String repositoryName, @Query("page") Integer page);
}
