package com.wcs.vaadin.cdi.internal;

import com.wcs.vaadin.cdi.NormalUIScoped;

@NormalUIScoped
public class MyBean {
    private static int counter = 0;

    private final int id = counter++;

    public MyBean() {
        System.out.println("Created MyBean with id " + id);
    }

    public int getBeanId() {
        return id;
    }
}
