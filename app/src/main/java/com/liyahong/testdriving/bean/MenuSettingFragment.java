package com.liyahong.testdriving.bean;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class MenuSettingFragment {
    private int menuImage;
    private String menuTitle;

    public MenuSettingFragment(int menuImage, String menuTitle) {
        this.menuImage = menuImage;
        this.menuTitle = menuTitle;
    }

    public int getMenuImage() {
        return menuImage;
    }

    public String getMenuTitle() {
        return menuTitle;
    }
}
