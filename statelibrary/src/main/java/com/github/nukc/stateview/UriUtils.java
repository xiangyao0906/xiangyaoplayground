package com.github.nukc.stateview;

import android.content.Context;
import android.net.Uri;

/**
 * Created by Administrator on 2017/09/19.
 */

public class UriUtils {
    private static Uri uri;
    private static String path = Constant.STRINGDEFAULT;
    private static int resId = Constant.INTDEFAULT;

    public static Uri getUri(int mode, String url, Context context) {
        path = url;
        return UriTool(mode, context);
    }

    public static Uri getUri(int mode, int localResource, Context context) {
        resId = localResource;
        return UriTool(mode, context);
    }

    public static Uri UriTool(int mode, Context context) {
        if (mode == Constant.ONLINEPIC && path != Constant.STRINGDEFAULT) {
            uri = Uri.parse(path);
        } else if (mode == Constant.LOCALRESOURCE && resId != Constant.INTDEFAULT) {
            uri = Uri.parse("res://" + context.getPackageName() + "/" + resId);
        }

        return uri;
    }

}
