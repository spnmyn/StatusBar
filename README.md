# StatusBar
设置状态栏颜色和透明度、更换窗体背景图片、碎片、抽屉、右滑页面。
=========
说明：为App设置状态栏的工具类， 可在4.4及以上系统实现沉浸式状态栏/状态栏变色，支持设置状态栏透明度。
---------
### 具体方法：
* 设置状态栏颜色

        StatusBarUtil.setColor(Activity activity, int color)

* 设置状态栏半透明

        StatusBarUtil.setTranslucent(Activity activity, int statusBarAlpha)

* 设置状态栏全透明

        StatusBarUtil.setTransparent(Activity activity)

* 为包含DrawerLayout界面设置状态栏颜色（也可设置半透明和全透明）

        StatusBarUtil.setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color)

* 为使用ImageView作为头部界面设置状态栏透明

        StatusBarUtil.setTranslucentForImageView(Activity activity, int statusBarAlpha, View needOffsetView)

* 在Fragment中使用。详见运行

* 为滑动返回界面设置状态栏颜色

    推荐配合<https://github.com/bingoogolapple/BGASwipeBackLayout-Android> Android Activity返回库一起使用

        StatusBarUtil.setColorForSwipeBack(Activity activity, @ColorInt int color, int statusBarAlpha)

* 通过传入```statusBarAlpha```参数，可以改变状态栏的透明度值，默认值是112

### 如何使用
* 在```build.gradle```文件中添加依赖,```StatusBarUtil```已经发布在```JCenter```

        compile 'com.jaeger.statusbarutil:library:1.4.0'

* 在```setContentView()```之后调用所需方法，例如:

        setContentView(R.layout.main_activity);
             ...
             StatusBarUtil.setColor(MainActivity.this, mColor);

* 在包含```DrawerLayout```界面中使用，你需在布局文件中为```DrawerLayout```添加```android:fitsSystemWindows="true"```属性

        <android.support.v4.widget.DrawerLayout
            xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:id="@+id/drawer_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:fitsSystemWindows="true">
            ...
        </android.support.v4.widget.DrawerLayout>

* 为滑动返回界面设置状态栏颜色

    推荐配合<https://github.com/bingoogolapple/BGASwipeBackLayout-Android> Android Activity返回库一起使用

        StatusBarUtil.setColorForSwipeBack(Activity activity, @ColorInt int color, int statusBarAlpha)

* 设置```statusBarAlpha```值时，该值需要在```0 ~ 255```之间

* 在```Fragment```中使用可参照```UseInFragmentActivity.java```来实现
