package com.company;

import java.util.Comparator;

class priceComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return Float.compare(o1.price, o2.price);
    }
}

class productComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return CharSequence.compare(o1.modelName, o2.modelName);
    }
}