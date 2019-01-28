package com.luiztorres.desafio_mobile_android.data.manager;

import android.content.Context;

import com.luiztorres.desafio_mobile_android.domain.repository.LocalRepository;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class LocalManager implements LocalRepository {

    @Inject
    Context context;

    Realm realm;

    public LocalManager(Context context) {
        this.context = context;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public <T extends RealmObject> void saveData(T data) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(data);
        realm.commitTransaction();
    }

    @Override
    public <T extends RealmObject> T getData(Class neededClass) {
        return (T) realm.where(neededClass).findFirst();
    }
}
