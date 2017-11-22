package com.example.nguye.phoneclone;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvContacts;
    private ArrayList<ContactModel> contacts;
    private ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        lvContacts = findViewById(R.id.lv_contacts);
        contacts = new ArrayList<ContactModel>();
        contactAdapter = new ContactAdapter(this, contacts);
        lvContacts.setAdapter(contactAdapter);
        readAllContacts(contacts);
        contactAdapter.notifyDataSetChanged();
    }

    private void readAllContacts(ArrayList<ContactModel> contacts){
        contacts.clear();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC"
        );
        while (cursor.moveToNext()){
            String colName = ContactsContract.Contacts.DISPLAY_NAME;
            int colNameIndex = cursor.getColumnIndex(colName);
            String name = cursor.getString(colNameIndex);

            String colPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int colPhoneIndex = cursor.getColumnIndex(colPhone);
            String phone = cursor.getString(colPhoneIndex);

            String colId = ContactsContract.Data.CONTACT_ID;
            int colIdIndex = cursor.getColumnIndex(colId);
            String id = cursor.getString(colIdIndex);
            Uri person = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long
                    .parseLong(id));
            Uri uId = Uri.withAppendedPath(person, ContactsContract.Contacts.Photo.CONTENT_DIRECTORY);

            contacts.add(new ContactModel(name, phone, uId));
        }
    }
}
