package com.nology.performancedemo;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;


class Key implements Comparable<Key> {
    public String email;
    public String firebaseId;

    public Key(String email, String firebaseId) {
        this.email = email;
        this.firebaseId = firebaseId;
    }

    @Override
    public int hashCode() {
      //  return (email + " " + firebaseId).hashCode();
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Key k) {
            return k.email.equals(email) && k.firebaseId.equals(firebaseId);
        }
        return false;
    }

    @Override
    public int compareTo(Key o) {
        if (email.compareTo(o.email) > 0) {
            return 1;
        }
        if (email.compareTo(o.email) < 0) {
            return -1;
        }

        return firebaseId.compareTo(o.firebaseId);
    }
}

public class DataStructures {
    public static void main(String[] args) {
        HashSet<Key> hashSet = new HashSet<>();
        TreeMap<Key, String> treeMap = new TreeMap<>();

        Key keyA = new Key("A@gmail.com", "A");
        Key keyB = new Key("B@gmail.com", "B");
        Key keyC = new Key("C@gmail.com", "C");

        hashSet.add(keyA);
        hashSet.add(keyB);
        hashSet.add(keyC);

        System.out.println(hashSet.size());

        Key query = new Key("A@gmail.com", "A");
        System.out.println(hashSet.contains(query));

        Key query2 = new Key("missing@gmail.com", "missing");
        System.out.println(hashSet.contains(query2));

        System.out.println("Hash code of A: " + keyA.hashCode());
        System.out.println("Hash code of B: " + keyB.hashCode());
        System.out.println("Hash code of C: " + keyC.hashCode());
        System.out.println("Hash code of query: " + query.hashCode());
    }
}
