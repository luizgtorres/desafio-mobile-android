package com.luiztorres.desafio_mobile_android.domain.entity.pullrequests;

import com.google.gson.annotations.SerializedName;
import com.luiztorres.desafio_mobile_android.domain.entity.listrepositories.Owner;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class PullRequest {
    public String title;

    @SerializedName("body")
    public String description;

    @SerializedName("user")
    public Owner owner;

    @SerializedName("html_url")
    public String url;
}
