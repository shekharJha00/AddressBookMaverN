package com.bridgelabz.util;

import java.util.Comparator;

public enum sortOptions {
    NAME(Comparator.comparing(Person::getFirstName)),
    CITY(Comparator.comparing(Person::getCity)),
    STATE(Comparator.comparing(Person::getState)),
    ZIP(Comparator.comparing(Person::getZip));

    public final Comparator <? super Person> comparator;

    sortOptions(Comparator <? super Person> comparator) {
        this.comparator = comparator;
    }
}