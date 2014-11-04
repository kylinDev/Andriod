package com.view.kylin.slidingpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kylin.beans.Site;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kylin on 14-9-13.
 */
public class Man extends ListFragment {
    private  View view;
    private ArrayList<String> data=new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_list_view,container,false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendRequest();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
        sendRequest();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
    private void sendRequest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    HttpClient httpClient=new DefaultHttpClient();
                    HttpGet httpGet=new HttpGet("http://10.0.2.2/data.json");
                    HttpResponse httpResponse=httpClient.execute(httpGet);
                    if(httpResponse.getStatusLine().getStatusCode()==200){
                        HttpEntity httpEntity=httpResponse.getEntity();
                        String response= EntityUtils.toString(httpEntity,"utf-8");
                        parseJson(response);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void parseJson(String json){
        Gson gson=new Gson();
        List<Site> siteList=gson.fromJson(json,new TypeToken<List<Site>>(){}.getType());
        for (Site s:siteList){
            data.add(s.getIntroduce());
            data.add(s.getSitename());
        }
    }
}