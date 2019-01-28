package com.luiztorres.desafio_mobile_android.presentation.util;

import okhttp3.Headers;

/**
 * Created by Dindal on 12-Nov-17.
 */

public class HeaderResponseUtil {
    public static Boolean hasNextPage(Headers header) {
        if (header.get("Link") == null)
            return false;

        String[] fields = header.get("Link").split(",");

        for (String field : fields) {
            if (field.contains("rel=\"next\"")) {
                return true;
            }
        }

        return false;
    }
}
