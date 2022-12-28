package com.coherentsolutions.store.sorting;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class XMLParser {
   private final Map<String, Enum> sortingMap = new LinkedHashMap<>();

   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
   DocumentBuilder db = dbf.newDocumentBuilder();
   Document configDoc = db.parse(new File("config.xml"));
   Node sortParent = configDoc.getParentNode();
   NodeList sortMethods = sortParent.getChildNodes();



   public XMLParser() throws ParserConfigurationException, IOException, SAXException {
   }
}