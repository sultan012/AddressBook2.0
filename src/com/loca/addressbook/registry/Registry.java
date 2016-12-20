package com.loca.addressbook.registry;

import com.loca.addressbook.exceptions.InvalidContactId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 2016-12-20.
 */
public class Registry {

    List<Contact> localRegistry = new ArrayList<>();
    List<Contact> tempRegistry = new ArrayList<>();


    public void addContact(String firstName, String lastName, String email) {

        localRegistry.add(new LocalContact(firstName, lastName, email, UniqueIdGenerator.generateUUID() ));
    }

    public List<Contact> getContacts() {
        return this.localRegistry;
    }

    public void deleteContact(String uuid) throws InvalidContactId {

        int i = 0;
        for (Contact contact : localRegistry) {
            if (contact.getId().equals(uuid)) {
                localRegistry.remove(i);
                return;
            }
           i++;
        }
        throw new InvalidContactId();

    }

    public List<Contact> search(String search) {

    }

    public void load() {

    }
}
