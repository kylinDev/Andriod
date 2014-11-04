package com.view.kylin.slidingpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import static android.widget.FrameLayout.LayoutParams;

/**
 * Created by kylin on 14-9-8.
 */
public class CFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View view=new View(getActivity());
        view.setLayoutParams(params);
        return view;
    }
}
