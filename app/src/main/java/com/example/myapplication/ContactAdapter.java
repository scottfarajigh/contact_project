package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<String> contacts = new ArrayList<>();
    ItemViewListener itemViewListener;
    private static final String TAG = "ContactAdapter";
    ContactAdapter(ItemViewListener itemViewListener){
        this.itemViewListener = itemViewListener;
        contacts.add("Ali alipour");
        contacts.add("Ali bahmani") ;
        contacts.add("Bardia rezari")  ;
        contacts.add("Catlin jpour")  ;
        contacts.add("Dariosh akbari")  ;
        contacts.add("Elham hosseini");
        contacts.add("Farid rezaei");
        contacts.add("Fardin alipour");
        contacts.add("Gloshifte ahmadi") ;
        contacts.add("Habib faraji") ;
        contacts.add("Hadi faraji") ;
        contacts.add("Mailad atatei") ;
        contacts.add("Matin sinaei");
        contacts.add("Mohsen hasani");
        contacts.add("Karim zandi");
        contacts.add("Korosh gandi");
        contacts.add("Leyla karimi") ;
        contacts.add("Fershte sereshte");
        contacts.add("Azin miladi") ;
        contacts.add("Mohammad bibak") ;

    }
    public void addContact(String fullName){
        contacts.add(0,fullName);
        notifyItemInserted(0);
    }

    public void changeContact(String fullname , int position){
        contacts.set(position,fullname);
        notifyItemChanged(position);
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
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
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
            contactFullNameTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemViewListener.onItemClick(fullName,getAdapterPosition());
                    Toast.makeText(view.getContext(), fullName, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public interface ItemViewListener{
        public void onItemClick(String fullName , int position);
    }

}
