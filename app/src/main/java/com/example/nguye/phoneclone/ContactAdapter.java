package com.example.nguye.phoneclone;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguye on 22-Nov-17.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ContactModel> contacts;

    public ContactAdapter(Context context, ArrayList<ContactModel> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = null;
        if(view == null){
            LayoutInflater  inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(R.layout.contact_item, viewGroup, false);
            ViewHolder holder = new ViewHolder();
            holder.imgAvatar = rowView.findViewById(R.id.img_contact_avatar);
            holder.txtName = rowView.findViewById(R.id.txt_contact_name);
            holder.txtPhone = rowView.findViewById(R.id.txt_contact_phone);
            rowView.setTag(holder);
        } else {
            rowView = view;
        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        if(contacts.get(i).getAvatar() != null){
            holder.imgAvatar.setImageURI(contacts.get(i).getAvatar());
        } else {
            holder.imgAvatar.setImageResource(R.drawable.ic_default_avatar);
        }
        holder.txtName.setText(contacts.get(i).getName());
        holder.txtPhone.setText(contacts.get(i).getPhone());
        return rowView;
    }
    class ViewHolder{
        ImageView imgAvatar;
        TextView txtName;
        TextView txtPhone;
    }

}
