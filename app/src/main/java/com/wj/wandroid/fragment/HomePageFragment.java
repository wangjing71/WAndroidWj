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
        testQBadgeView();
    }

    private void testQBadgeView() {
        //测试 BadgeView
        /*setBadgeNumber	设置Badge数字
        setBadgeText	设置Badge文本
        setBadgeTextSize	设置文本字体大小
        setBadgeTextColor	设置文本颜色
        setExactMode	设置是否显示精确模式数值
        setBadgeGravity	设置Badge相对于TargetView的位置
        setGravityOffset	设置外边距
        setBadgePadding	设置内边距
        setBadgeBackgroundColor	设置背景色
        setBadgeBackground	设置背景图片
        setShowShadow	设置是否显示阴影
        setOnDragStateChangedListener	打开拖拽消除模式并设置监听
        stroke	描边
        hide	隐藏Badge*/
        new QBadgeView(getContext()).bindTarget(textView).setBadgeText("+").setBadgeTextSize(15,true).setBadgeBackgroundColor(Color.RED);
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
