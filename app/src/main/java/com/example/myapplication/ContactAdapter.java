package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    String[] contacts = new String[20];
    private static final String TAG = "ContactAdapter";
    ContactAdapter(){
        contacts[0] ="Ali alipour";
        contacts[1]="Ali bahmani";
        contacts[2]="Bardia rezari";
        contacts[3]="Catlin jpour";
        contacts[4]="Dariosh akbari";
        contacts[5]="Elham hosseini";
        contacts[6]="Farid rezaei";
        contacts[7]="Fardin alipour";
        contacts[8]="Gloshifte ahmadi";
        contacts[9]="Habib faraji";
        contacts[10]="Hadi faraji";
        contacts[11]="Mailad atatei";
        contacts[12]="Matin sinaei";
        contacts[13]="Mohsen hasani";
        contacts[14]="Karim zandi";
        contacts[15]="Korosh gandi";
        contacts[16]="Leyla karimi";
        contacts[17]="Fershte sereshte";
        contacts[18]="AAzin miladi";
        contacts[19]="Mohammad bibak";
        contacts[19]="Mohammad bibak";
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: موقعیت ==> " + position);
        holder.bindContact(contacts[position]);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView firstCharacterTv;
        TextView contactFullNameTv;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            firstCharacterTv=itemView.findViewById(R.id.firstCharacterTv);
            contactFullNameTv=itemView.findViewById(R.id.contactFullNamreTv);
        }

        public void bindContact(String fullName){
            firstCharacterTv.setText(fullName.substring(0,1));
            contactFullNameTv.setText(fullName);
        }
    }

}
