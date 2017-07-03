package com.liyahong.testdriving.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyahong.testdriving.R;
import com.liyahong.testdriving.bean.MenuSettingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyahong0327 on 2017/6/21.
 */

public class SettingFragmentAdapter extends BaseAdapter {
    private Context context;
    private List<MenuSettingFragment> list=new ArrayList<>();

    public SettingFragmentAdapter(Context context) {
        this.context = context;
        list.add(new MenuSettingFragment(R.mipmap.ic_launcher,""));
        list.add(new MenuSettingFragment(R.mipmap.home_left_message,"我的消息"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_down,"教学视频"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_exam,"我的成绩"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_xuecheriji,"学车日记"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_souchang,"文章收藏"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_foot,"文章足迹"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_coach,"教员中心"));
        list.add(new MenuSettingFragment(R.mipmap.home_left_setting,"设置"));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_setting_fragment,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.setView(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.menuImage.setImageResource(list.get(position).getMenuImage());
        viewHolder.menuTitle.setText(list.get(position).getMenuTitle());
        return convertView;
    }

    class ViewHolder{
        private ImageView menuImage;
        private TextView menuTitle;
        private void setView(View v){
            menuImage= (ImageView) v.findViewById(R.id.item_setting_fragment_menu_image);
            menuTitle= (TextView) v.findViewById(R.id.item_setting_fragment_menu_title);
        }
    }
}
