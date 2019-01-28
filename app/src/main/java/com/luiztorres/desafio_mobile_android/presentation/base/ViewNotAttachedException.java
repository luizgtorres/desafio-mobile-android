package com.luiztorres.desafio_mobile_android.presentation.base;

/**
 * Created by Dindal on 10-Nov-17.
 */

public class ViewNotAttachedException extends RuntimeException {
    public ViewNotAttachedException() {
        super("View not attached to presenter");
    }
}
