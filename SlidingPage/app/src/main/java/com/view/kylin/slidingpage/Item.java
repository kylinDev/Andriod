package com.view.kylin.slidingpage;

import android.support.v4.app.Fragment;

/**
 * Created by kylin on 14-9-13.
 */
public class Item {
    private int imageId;
    private String text;

    public Item(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
