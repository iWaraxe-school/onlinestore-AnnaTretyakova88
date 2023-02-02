package com.coherentsolutions.store.sorting;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

   public static Map<String, SortingOptions> readAndParseXML() throws ParserConfigurationException, IOException, SAXException {

      final Map<String, SortingOptions> sortingMap = new LinkedHashMap<>();

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document configDoc = db.parse(new File("config.xml"));

      Node mainTag = configDoc.getElementsByTagName("sort").item(0);
      NodeList sortMethods = mainTag.getChildNodes();

      for (int i = 0; i < sortMethods.getLength(); i++) {
         //check if item from doc has proper type - Element (it's equal to tag)
         if (sortMethods.item(i).getNodeType() == Node.ELEMENT_NODE) {
            //need to custom by Element type since sort.methods.item() return ElementNode type
            Element tagElement = (Element) sortMethods.item(i);
            //define tag name as key for map
            String key = tagElement.getTagName();
            //define tag text as value for map
            SortingOptions value = SortingOptions.valueOf(tagElement.getTextContent().toUpperCase());
            // put obtained key and values into map
            sortingMap.put(key, value);
         }
      }
      return sortingMap;
   }
}