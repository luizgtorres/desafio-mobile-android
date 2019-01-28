package com.luiztorres.desafio_mobile_android.domain.entity.listrepositories;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Dindal on 11-Nov-17.
 */

public class Repository {
    public Owner owner;

    public String name;

    public String description;

    @SerializedName("watchers_count")
    public Integer stars;

    @SerializedName("forks_count")
    public Integer forks;
}
