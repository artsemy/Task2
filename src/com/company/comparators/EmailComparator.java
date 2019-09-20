package com.company.comparators;

import com.company.notes.Note;

import java.util.Comparator;

public class EmailComparator implements Comparator<Note> {
    @Override
    public int compare(Note o1, Note o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
