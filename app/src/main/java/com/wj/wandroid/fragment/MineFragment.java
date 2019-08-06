package com.wj.wandroid.fragment;

import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseLazyFragment;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class MineFragment extends BaseLazyFragment {
    @Override
    public int setContentViewId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View root) {
        ImmersionBar.setStatusBarView(this, root.findViewById(R.id.barView));
    }

    @Override
    protected void initData() {

    }
}
