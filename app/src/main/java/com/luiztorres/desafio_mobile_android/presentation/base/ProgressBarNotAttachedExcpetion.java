package com.luiztorres.desafio_mobile_android.presentation.base;

/**
 * Created by Dindal on 10-Nov-17.
 */

public class ProgressBarNotAttachedExcpetion extends RuntimeException {
    public ProgressBarNotAttachedExcpetion() {
        super("Progress bar not attached");
    }
}
