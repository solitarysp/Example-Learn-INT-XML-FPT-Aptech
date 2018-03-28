package com.fpt.themdulieuvaofile;/*
  By Chi Can Em  28-03-2018
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "fileXMl/file1.xml";
        Document document = null;
        document = getDocumentXmlByPath(path);
        File file = new File(path);
        Element root = null;
        if (!file.exists()) {
            root = document.createElement("ListStudent");
        } else {
            root = document.getDocumentElement();
        }
        Element superStudent = document.createElement("Student");
        root.appendChild(superStudent);

        Attr attr = document.createAttribute("class");
        attr.setValue("c1608g1");
        superStudent.setAttributeNode(attr);


        Element carname = document.createElement("id");
        Attr attrType = document.createAttribute("type");
        attrType.setValue("int");
        carname.setAttributeNode(attrType);
        carname.appendChild(document.createTextNode("1002"));
        superStudent.appendChild(carname);


        Element carname1 = document.createElement("name");
        Attr attrType1 = document.createAttribute("type");
        attrType1.setValue("String");
        carname1.setAttributeNode(attrType1);
        carname1.appendChild(document.createTextNode("lethanh1"));
        superStudent.appendChild(carname1);

        if (!file.exists()) {
            document.appendChild(root);
        }

        saveFileDocment(path, document);

    }

    private static void saveFileDocment(String path, Document document) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            File file = new File(path);
            DOMSource domSource = new DOMSource(document);

            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static Document getDocumentXmlByPath(String path) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;

        try {
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            File file = new File(path);

            if (!file.exists()) {
                document = documentBuilder.newDocument();
            } else {
                document = documentBuilder.parse(file);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }


}
