package com.view.kylin.slidingpage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kylin on 14-9-18.
 */
public class Test extends Activity {
    private String[] data={"Apple","Orange","Hello","World"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_list_view);
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(Test.this,android.R.layout.simple_list_item_1,data);
       // ListView listView=(ListView)findViewById(R.id.list);
        //listView.setAdapter(adapter);
    }
}
