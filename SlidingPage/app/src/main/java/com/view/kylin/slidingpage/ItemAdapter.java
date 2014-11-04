package com.view.kylin.slidingpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kylin on 14-9-13.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    private int resourceId;
    public  ItemAdapter(Context context,int resourceId,List<Item> item){
        super(context,resourceId,item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView)view.findViewById(R.id.image);
            viewHolder.textView=(TextView)view.findViewById(R.id.text);
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.imageView.setImageResource(resourceId);
        viewHolder.textView.setText(item.getText());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
