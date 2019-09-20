package com.company.comparators;

import com.company.Note;

import java.util.Comparator;

public class DateComparator implements Comparator<Note> {
    @Override
    public int compare(Note o1, Note o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
