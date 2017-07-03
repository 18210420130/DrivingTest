package com.liyahong.testdriving.controllers;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.liyahong.testdriving.activitys.MainActivity;
import com.liyahong.testdriving.adapter.SettingFragmentAdapter;
import com.liyahong.testdriving.bean.MenuSettingFragment;
import com.liyahong.testdriving.databinding.FragmentSettingBinding;
import com.liyahong.testdriving.fragments.SettingFragment;

/**
 * Created by liyahong0327 on 2017/6/20.
 */

public class SettingFragmentController {
    private SettingFragment fragment;
    private FragmentSettingBinding binding;
    private final SettingFragmentAdapter adapter;

    public SettingFragmentController(final SettingFragment fragment, final FragmentSettingBinding binding) {
        this.fragment = fragment;
        this.binding = binding;
        adapter = new SettingFragmentAdapter(fragment.getContext());
        binding.fragmentSettingListView.setAdapter(adapter);

        binding.fragmentSettingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MenuSettingFragment item = (MenuSettingFragment) adapter.getItem(position);
                Toast.makeText(fragment.getContext(),item.getMenuTitle(),Toast.LENGTH_LONG).show();
               MainActivity activity= (MainActivity) fragment.getContext();
                activity.closeDrawer();
            }
        });





    }
}
