package com.example.kylin.tags;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class MyActivity extends Activity implements View.OnClickListener{

    private FragmentManager fragmentManager;

    private  Message message;
    private  View    messageView;
    private  TextView messageText;
    private  ImageView messageImage;

    private  Contacts contacts;
    private  View contactsView;
    private  TextView contactsText;
    private  ImageView contactsImage;

    private  Setting setting;
    private  View settingView;
    private  TextView settingText;
    private  ImageView settingImage;

    private  News news;
    private  View newsView;
    private  TextView newsText;
    private  ImageView newsImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        initViews();
        fragmentManager=getFragmentManager();
        setTabSelection(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.message_layout:
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                setTabSelection(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initViews(){
        messageView=findViewById(R.id.message_layout);
        messageImage=(ImageView)findViewById(R.id.message_image);
        messageText=(TextView)findViewById(R.id.message_text);

        contactsView=findViewById(R.id.contacts_layout);
        contactsImage=(ImageView)findViewById(R.id.contacts_image);
        contactsText=(TextView)findViewById(R.id.contacts_text);

        settingView=findViewById(R.id.setting_layout);
        settingImage=(ImageView)findViewById(R.id.setting_image);
        settingText=(TextView)findViewById(R.id.setting_text);

        newsView=findViewById(R.id.news_layout);
        newsImage=(ImageView)findViewById(R.id.news_image);
        newsText=(TextView)findViewById(R.id.news_text);

        messageView.setOnClickListener(this);
        contactsView.setOnClickListener(this);
        settingView.setOnClickListener(this);
        newsView.setOnClickListener(this);
    }
    private void setTabSelection(int index){
        clearSelection();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if(message==null){
                    message=new Message();
                    transaction.add(R.id.content,message);
                }else{
                    transaction.show(message);
                }
                break;
            case 1:
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactsText.setTextColor(Color.WHITE);
                if (contacts==null){
                    contacts=new Contacts();
                    transaction.add(R.id.content,contacts);
                }else{
                    transaction.show(contacts);
                }
                break;
            case 2:
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (news==null){
                    news=new News();
                    transaction.add(R.id.content,news);
                }else{
                    transaction.show(news);
                }
                break;
            case 3:
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if(setting==null){
                    setting=new Setting();
                    transaction.add(R.id.content, setting);
                }else{
                    transaction.show(setting);
                }
        }
        transaction.commit();
    }
    private void clearSelection(){
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));

    }
    private void hideFragments(FragmentTransaction transaction){
        if(message!=null){
            transaction.hide(message);
        }
        if(news!=null){
            transaction.hide(news);
        }
        if (contacts!=null){
            transaction.hide(contacts);
        }
        if (setting!=null){
            transaction.hide(setting);
        }
    }
}
