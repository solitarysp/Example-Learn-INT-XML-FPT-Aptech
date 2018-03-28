package com.fpt.exampleCreateXMlWithDom;/*
  By Chi Can Em  28-03-2018
 */

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

public class Main {
    public static void main(String[] args) {
        File file = new File("fileXMl/file1.xml");
        Main main = new Main();
        Document document = main.doCreatData();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();

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


    public Document doCreatData() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            doc = documentBuilder.newDocument();

            //tạo thẻ cha
            Element rootElement = doc.createElement("ListStudent");
            doc.appendChild(rootElement);

            Element superStudent = doc.createElement("Student");
            rootElement.appendChild(superStudent);

            Attr attr = doc.createAttribute("class");
            attr.setValue("c1608g1");
            superStudent.setAttributeNode(attr);


            Element carname = doc.createElement("id");
            Attr attrType = doc.createAttribute("type");
            attrType.setValue("int");
            carname.setAttributeNode(attrType);
            carname.appendChild(doc.createTextNode("100"));
            superStudent.appendChild(carname);


            Element carname1 = doc.createElement("name");
            Attr attrType1 = doc.createAttribute("type");
            attrType1.setValue("String");
            carname1.setAttributeNode(attrType1);
            carname1.appendChild(doc.createTextNode("lethanh"));
            superStudent.appendChild(carname1);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
