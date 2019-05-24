package com.wj.wandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * author wangjing
 * Date 2019/5/24
 * Description
 */
public class BaseFragment extends Fragment {
    private boolean isPrepared;
    private boolean isLazyLoaded;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
    }

    private void lazyLoad() {
        if(getUserVisibleHint()&&isPrepared&&!isLazyLoaded){
            onLazyLoad();
            isLazyLoaded = true;
        }
    }

    private void onLazyLoad() {


    }
}
