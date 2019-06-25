package com.wj.wandroid.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseLazyFragment;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomePageFragment extends BaseLazyFragment {
    private Button button;

    //需要无参构造方法
    public HomePageFragment() {
    }

    @Override
    public int setContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View root) {
        button = root.findViewById(R.id.button);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void setEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "44444", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
