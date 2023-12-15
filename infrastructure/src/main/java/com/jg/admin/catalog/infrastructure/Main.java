package com.jg.admin.catalog.infrastructure;

import com.jg.admin.catalog.application.UseCase;

public class Main {
    public static void main(String[] args) {

        System.out.println(new UseCase().execute());

    }
}