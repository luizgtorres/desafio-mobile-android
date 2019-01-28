package com.luiztorres.desafio_mobile_android.domain.entity.listrepositories;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dindal on 11-Nov-17.
 */

public class Owner {
    public String id;

    @SerializedName("avatar_url")
    public String photoUrl;

    @SerializedName("login")
    public String name;
}
