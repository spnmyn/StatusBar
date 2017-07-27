package com.example.administrator.statusbar;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
    /*声明控件*/
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private CheckBox chb_change_background_picture;
    private Button btn_set_color;
    private Button btn_set_background_picture;
    private Button btn_set_alpha;
    private Button btn_set_alpha_for_image_view;
    private Button btn_use_in_fragment;
    private Button btn_set_color_for_slideBack_page;
    private ViewGroup contentLayout;
    private SeekBar mSbChangeAlpha;
    private TextView mTvStatusAlpha;
    /*声明颜色、透明度变量*/
    private int mStatusBarColor;
    private int mAlpha = com.jaeger.library.StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        contentLayout = (ViewGroup) findViewById(R.id.main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        chb_change_background_picture = (CheckBox) findViewById(R.id.chb_change_background_picture);
        btn_set_color = (Button) findViewById(R.id.btn_set_color);
        btn_set_background_picture = (Button) findViewById(R.id.btn_set_background_picture);
        btn_set_alpha = (Button) findViewById(R.id.btn_set_alpha);
        btn_set_alpha_for_image_view = (Button) findViewById(R.id.btn_set_alpha_for_image_view);
        btn_use_in_fragment = (Button) findViewById(R.id.btn_use_in_fragment);
        btn_set_color_for_slideBack_page = (Button) findViewById(R.id.btn_set_color_for_slideBack_page);
        mSbChangeAlpha = (SeekBar) findViewById(R.id.sb_change_alpha);
        mTvStatusAlpha = (TextView) findViewById(R.id.tv_status_alpha);

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        btn_set_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ColorStatusBarActivity.class);
                startActivity(intent);
            }
        });

        btn_set_background_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageStatusBarActivity.class);
                intent.putExtra(ImageStatusBarActivity.EXTRA_IS_TRANSPARENT, true);
                startActivity(intent);
            }
        });

        btn_set_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageStatusBarActivity.class);
                intent.putExtra(ImageStatusBarActivity.EXTRA_IS_TRANSPARENT, false);
                startActivity(intent);
            }
        });

        btn_set_alpha_for_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });

        btn_use_in_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UseInFragmentActivity.class);
                startActivity(intent);
            }
        });

        btn_set_color_for_slideBack_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SwipeBackActivity.class);
                startActivity(intent);
            }
        });

        chb_change_background_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chb_change_background_picture.isChecked()) {
                    contentLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.monkey));
                    com.jaeger.library.StatusBarUtil.setTranslucentForDrawerLayout(MainActivity.this, mDrawerLayout, mAlpha);
                    mToolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                } else {
                    contentLayout.setBackgroundDrawable(null);
                    mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    com.jaeger.library.StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout, getResources().getColor(R.color.colorPrimary), mAlpha);
                }
            }
        });

        mSbChangeAlpha.setMax(255);
        mSbChangeAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mAlpha = progress;
                if (chb_change_background_picture.isChecked()) {
                    com.jaeger.library.StatusBarUtil.setTranslucentForDrawerLayout(MainActivity.this, mDrawerLayout, mAlpha);
                } else {
                    com.jaeger.library.StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawerLayout, mStatusBarColor, mAlpha);
                }
                mTvStatusAlpha.setText(String.valueOf(mAlpha));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSbChangeAlpha.setProgress(com.jaeger.library.StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
    }

    @Override
    protected void setStatusBar() {
        mStatusBarColor = getResources().getColor(R.color.colorPrimary);
        com.jaeger.library.StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
    }
}
