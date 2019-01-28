package com.luiztorres.desafio_mobile_android.domain.repository;

import io.realm.RealmObject;

/**
 * Created by Dindal on 12-Nov-17.
 */

public interface LocalRepository {
    <T extends RealmObject> void saveData(T data);

    <T extends RealmObject> T getData(Class neededClass);
}
