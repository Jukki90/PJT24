package com.example.tests;

import com.thoughtworks.xstream.XStream;

public class Hello {
    public static void main(String[] args) {

        XStream xstream = new XStream();

        String salutation = "Hello, World!";

        String xml = xstream.toXML(salutation);

        System.out.print(xml);
    }

}