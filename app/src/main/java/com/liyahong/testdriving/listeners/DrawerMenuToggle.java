package com.liyahong.testdriving.listeners;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by liyahong0327 on 2017/6/21.
 * 侧滑菜单状态监听
 */

public class DrawerMenuToggle extends ActionBarDrawerToggle {

    private Activity activity;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private int openDrawerContentDescRes;
    private int closeDrawerContentDescRes;

    /**
     *
     * @param activity
     * @param drawerLayout ：就是加载的DrawerLayout容器组件
     * @param toolbar    : 要使用的ActionBar左上角的指示图标
     * @param openDrawerContentDescRes
     * @param closeDrawerContentDescRes
     */
    public DrawerMenuToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
        this.activity=activity;
        this.drawerLayout=drawerLayout;
        this.toolbar=toolbar;
        this.openDrawerContentDescRes=openDrawerContentDescRes;
        this.closeDrawerContentDescRes=closeDrawerContentDescRes;
    }

    /**
     * 当侧滑菜单达到完全关闭的状态时，回调这个方法
     * @param drawerView
     */
    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        activity.getActionBar().setTitle("哈哈");
    }

    /**
     * 当侧滑菜单打开时，回调这个方法
     * @param drawerView
     */
    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        activity.getActionBar().setTitle("你好");


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



}
