package com.luiztorres.desafio_mobile_android.presentation.di.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Dindal on 10-Nov-17.
 */

@Scope
@Retention(RUNTIME)
public @interface PerView {
}