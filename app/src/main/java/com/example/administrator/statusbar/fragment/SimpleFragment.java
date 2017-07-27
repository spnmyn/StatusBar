package com.example.administrator.statusbar.fragment;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.statusbar.R;

/**
 * Created on 2017/7/27
 * Author 郑少鹏
 */

public class SimpleFragment extends Fragment {
    /*声明控件*/
    private TextView tv_title;
    private View fake_status_bar;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragement_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 初始控件
        tv_title = view.findViewById(R.id.tv_title);
        fake_status_bar = view.findViewById(R.id.fake_status_bar);
    }

    /*
    * 设置标题栏、状态栏背景颜色
    * */
    public void setTitleBackgroundColor(@ColorInt int color) {
        tv_title.setBackgroundColor(color);
        fake_status_bar.setBackgroundColor(color);
    }
}
