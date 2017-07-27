package com.example.administrator.statusbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.administrator.statusbar.utils.StatusBarUtil;
import com.r0adkll.slidr.Slidr;

import java.util.Random;

/**
 * Created on 2017/7/27
 * Author 郑少鹏
 */

public class SwipeBackActivity extends BaseActivity {
    /*声明控件*/
    private Toolbar mToolbar;
    private Button mBtnChangeColor;
    /*声明颜色*/
    private int mColor = Color.GRAY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置右滑动返回
        Slidr.attach(this);
        setContentView(R.layout.swipe_back_activity);
        // 初始化控件
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnChangeColor = (Button) findViewById(R.id.btn_change_color);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setBackgroundColor(mColor);
        // 随机改变颜色
        mBtnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mColor = 0xff000000 | random.nextInt(0xffffff);
                mToolbar.setBackgroundColor(mColor);
                StatusBarUtil.setColorForSwipeBack(SwipeBackActivity.this, mColor, 38);
            }
        });
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setColorForSwipeBack(this, mColor, 38);
    }
}
