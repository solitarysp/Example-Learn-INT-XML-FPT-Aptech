package com.fpt.dom;/*
  By Chi Can Em  26-03-2018
 */


import com.fpt.model.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        File file = new File("buoi1/src/main/java/com/fpt/xml/file.xml");
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder1 = builderFactory.newDocumentBuilder();
            Document document = documentBuilder1.parse(file);
            NodeList nodeList = document.getElementsByTagName("student");
            System.out.println("all student " + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node temp = nodeList.item(i);
                NodeList childs = temp.getChildNodes();

                for (int j = 0; j < childs.getLength(); j++) {
                    if (!childs.item(j).getNodeName().equals("#text")) {
                        System.out.print(childs.item(j).getTextContent() + "\t\t");
                    }
                }
                System.out.println();
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
