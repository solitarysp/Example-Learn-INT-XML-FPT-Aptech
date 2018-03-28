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

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        String name = "thanh";
        File file = new File("buoi1/src/main/java/com/fpt/xml/file.xml");
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder1 = builderFactory.newDocumentBuilder();
            Document document = documentBuilder1.parse(file);
            NodeList nodeList = document.getElementsByTagName("student");


            for (int i = 0; i < nodeList.getLength(); i++) {
                String text = nodeList.item(i).getTextContent();
                text = text.trim();
                if (text.startsWith(name) || text.endsWith(name)) {
                    Node node = nodeList.item(i).getParentNode();
                    nodes.add(node);
                }
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
