package com.fpt.exampleThayLinh;/*
  By Chi Can Em  28-03-2018
 */

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DomCreate {
    public static void main(String[] args) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
