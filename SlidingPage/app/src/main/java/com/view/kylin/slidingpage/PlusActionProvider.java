package com.view.kylin.slidingpage;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import com.view.kylin.slidingpage.R;

/**
 * Created by kylin on 14-9-20.
 */
public class PlusActionProvider extends ActionProvider{
    private Context context;
    public PlusActionProvider(Context context){
        super(context);
        this.context=context;
    }
    @Override
    public View onCreateActionView() {
        return null;
    }
    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        subMenu.add(context.getString(R.string.action_add_friends)).setIcon(R.drawable.ofm_add_icon).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        subMenu.add(context.getString(R.string.action_feed_back)).setIcon(R.drawable.ofm_feedback_icon).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        subMenu.add(context.getString(R.string.action_settings)).setIcon(R.drawable.ofm_setting_icon).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        super.onPrepareSubMenu(subMenu);
    }
}
