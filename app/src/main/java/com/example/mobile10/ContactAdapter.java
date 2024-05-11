package com.example.mobile10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<Contact> contacts;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameTextView;
        private final TextView phoneTextView;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.contact_name);
            phoneTextView = view.findViewById(R.id.contact_phone);
        }

        public void bind(Contact contact) {
            nameTextView.setText(contact.getName());
            phoneTextView.setText(contact.getPhone());
        }
    }

    public ContactAdapter(ArrayList<Contact> contacts) {
        if (contacts == null) {
            throw new IllegalArgumentException("Contacts list cannot be null");
        }
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> newContacts) {
        if (newContacts == null) {
            throw new IllegalArgumentException("Contacts list cannot be null");
        }
        this.contacts = newContacts;
        notifyDataSetChanged();
    }

}
