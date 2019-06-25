package com.wj.wandroid.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wj.wandroid.R;
import com.wj.wandroid.base.BaseLazyFragment;

import q.rorbin.badgeview.QBadgeView;

/**
 * author wangjing
 * Date 2019/6/24
 * Description
 */
public class HomePageFragment extends BaseLazyFragment {
    private Button button;
    private TextView textView;

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
        textView = root.findViewById(R.id.textView);
    }

    @Override
    protected void initData() {
        //测试 BadgeView
        new QBadgeView(getContext()).bindTarget(textView).setBadgeNumber(5).setBadgeBackgroundColor(Color.RED);
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
