package com.xiangyao.train.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.xiangyao.train.view.PageStateView;

import xiangyao.yizhilu.com.studyjourny.R;


public class PageStateManager {

    private OnRetryClickListener onRetryClickListener;

    private PageStateView pageStateView;

    public void showLoading() {
        pageStateView.showLoading();
    }

    public void showError() {
        pageStateView.showError();
    }

    public void showContent() {
        pageStateView.showContent();
    }

    public void showEmpty() {
        pageStateView.showEmpty();
    }

    public PageStateManager(View container) {
        ViewGroup contentParent = (ViewGroup) (container.getParent());
        Context context = container.getContext();

        int childCount = contentParent.getChildCount();
        //get contentParent
        int index = 0;
        for (int i = 0; i < childCount; i++) {
            if (contentParent.getChildAt(i) == container) {
                index = i;
                break;
            }
        }
        contentParent.removeView(container);
        //set content layout
        PageStateView stateLayout = new PageStateView(context);

        ViewGroup.LayoutParams lp = container.getLayoutParams();
        contentParent.addView(stateLayout, index, lp);
        stateLayout.setContentView(container);
        //set loading,error,empty layout
        setLoadingLayout(stateLayout);
        setEmptyLayout(stateLayout);
        setErrorLayout(stateLayout);

        pageStateView = stateLayout;

        pageStateView.getErrorView().setOnClickListener(view -> {
            if (onRetryClickListener != null) {
                onRetryClickListener.OnRetryClick();
            }
        });
    }

    private void setLoadingLayout(PageStateView stateLayout) {
        stateLayout.setLoadingView(R.layout.base_state_loading_layout);
    }

    private void setEmptyLayout(PageStateView stateLayout) {
        stateLayout.setEmptyView(R.layout.base_state_empty_layout);
    }

    private void setErrorLayout(PageStateView stateLayout) {
        stateLayout.setErrorView(R.layout.base_state_error_layout);
    }

    public interface OnRetryClickListener {
        void OnRetryClick();
    }

    public void setOnRetryClickListener(OnRetryClickListener listener) {
        this.onRetryClickListener = listener;
    }

}
