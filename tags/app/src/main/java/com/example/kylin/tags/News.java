package com.example.kylin.tags;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kylin on 14-8-11.
 */
public class News extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View news=inflater.inflate(R.layout.news,container,false);
        return news;
    }
}
