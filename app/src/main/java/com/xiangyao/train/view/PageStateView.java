package com.xiangyao.train.view;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class PageStateView extends FrameLayout {
    private View loadingView;
    private View errorView;
    private View contentView;
    private View emptyView;
    private LayoutInflater inflater;

    public PageStateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflater = LayoutInflater.from(context);
    }

    public PageStateView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PageStateView(Context context) {
        this(context, null);
    }

    public void showLoading() {
        if (loadingView != null) {
            loadingView.setVisibility(View.VISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
        if (contentView != null) {
            contentView.setVisibility(View.GONE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
    }

    public void showContent() {
        if (contentView != null) {
            contentView.setVisibility(View.VISIBLE);
        }
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
    }

    public void showEmpty() {
        if (emptyView != null) {
            emptyView.setVisibility(View.VISIBLE);
        }
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
        if (errorView != null) {
            errorView.setVisibility(View.GONE);
        }
        if (contentView != null) {
            contentView.setVisibility(View.GONE);
        }
    }

    public void showError() {
        if (errorView != null) {
            errorView.setVisibility(View.VISIBLE);
        }
        if (loadingView != null) {
            loadingView.setVisibility(View.GONE);
        }
        if (contentView != null) {
            contentView.setVisibility(View.GONE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
    }

    public View setLoadingView(int layoutId) {
        return setLoadingView(inflater.inflate(layoutId, this, false));
    }

    public View setEmptyView(int layoutId) {
        return setEmptyView(inflater.inflate(layoutId, this, false));
    }

    public View setErrorView(int layoutId) {
        return setErrorView(inflater.inflate(layoutId, this, false));
    }

    private View setLoadingView(View view) {
        View v = loadingView;
        removeView(v);
        addView(view);
        loadingView = view;
        return loadingView;
    }

    private View setEmptyView(View view) {
        View v = emptyView;
        removeView(v);
        addView(view);
        emptyView = view;
        return emptyView;
    }

    private View setErrorView(View view) {
        View retryView = errorView;
        removeView(retryView);
        addView(view);
        errorView = view;
        return errorView;

    }

    public View setContentView(View view) {
        View v = contentView;
        removeView(v);
        addView(view);
        contentView = view;
        return contentView;
    }

    public View getErrorView() {
        return errorView;
    }


}
