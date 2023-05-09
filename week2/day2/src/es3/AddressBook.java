package es3;

import java.util.HashMap;

public class AddressBook extends HashMap<String, String> {
    public AddressBook() {
        super();
    }

    @Override
    public String put(String key, String value) {
        return super.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return super.remove(key);
    }

    public String getName(String phoneNumber) {
        for (String name : this.keySet()) {
            if (this.get(name).equals(phoneNumber)) {
                return name;
            }
        }
        return null;
    }

    @Override
    public String get(Object key) {
        return super.get(key);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
