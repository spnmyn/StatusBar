package com.example.administrator.statusbar;

import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;

/**
 * Created on 2017/7/26
 * Author 郑少鹏
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }
}
