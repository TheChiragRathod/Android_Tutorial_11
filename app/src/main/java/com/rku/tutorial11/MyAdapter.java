package com.rku.tutorial11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyAdapter extends BaseAdapter
{
    JSONArray itemJSONArray;
    Context contaxt;

    public MyAdapter(Context contaxt, JSONArray itemJSONArray)
    {
        this.itemJSONArray=itemJSONArray;
        this.contaxt=contaxt;
    }


    @Override
    public int getCount() {
        return itemJSONArray.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView = LayoutInflater.from(contaxt).inflate(R.layout.layout_user,parent,false);
        }

        TextView textFormula=(TextView) convertView.findViewById(R.id.txtName);
        TextView textUrl=(TextView)convertView.findViewById(R.id.txtEmail);

        JSONObject Onobj=null;

        try{
            Onobj=itemJSONArray.getJSONObject(position);
            textFormula.setText(Onobj.getString("name"));
            textUrl.setText(Onobj.getString("email"));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return convertView;
    }
}
