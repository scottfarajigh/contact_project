package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ItemViewListener {
    int editingItemPosition;
    ContactAdapter adapter;
    ImageView addContactBtn;
    EditText addContactFullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView =findViewById(R.id.newMainRv);
        adapter = new ContactAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        addContactFullName =findViewById(R.id.edAddContact);
        addContactBtn=findViewById(R.id.addBtn);
        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addContactFullName.length() > 0){
                    if (editingItemPosition  > -1){
                        adapter.changeContact(addContactFullName.getText().toString(),editingItemPosition);
                        editingItemPosition = -1;
                        addContactBtn.setImageResource(R.drawable.ic_baseline_person_add_alt_1_24);
                    }else{
                        adapter.addContact(addContactFullName.getText().toString());
                        recyclerView.smoothScrollToPosition(0);
                    }

                }
                addContactFullName.setText("");
            }
        });

    }

    @Override
    public void onItemClick(String fullName, int position) {
        addContactFullName.setText(fullName);
        editingItemPosition=position;
        addContactBtn.setImageResource(R.drawable.ic_baseline_done_24);

    }
}