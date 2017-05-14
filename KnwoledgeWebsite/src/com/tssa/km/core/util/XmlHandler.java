package com.tssa.km.core.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import personal.website.km.test.cpp.QuestionGenerator;

public class XmlHandler {
	private Document document=null;
	
	private static XmlHandler instance=null;
	public Document getDocument() {
		return document;
	}
	public XmlHandler(String xmlName){
		readXmlFile(xmlName);
	}
	private Document readXmlFile(String xmlName){
		try{
			File xmlFile = new File(xmlName);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilderFactory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			document = docBuilder.parse(xmlFile);			
		}catch(ParserConfigurationException e){
			e.printStackTrace();			
		}catch(SAXException e){
			e.printStackTrace();			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();			
		}	
		return document;
	}
	public Element getXmlElment(String xmlName, String xmlElement){
		return null;
	}
	public Map<String, LinkedHashMap<String, String>> getXmlElment(String xmlElement){
		Element element=null;
		NodeList nodeList=null;
		Map<String, LinkedHashMap<String, String>> elementDetail = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		if(xmlElement.contains("/")){
			//System.out.println("xmlElement "+xmlElement);
			String []xmlElementParts=xmlElement.split("/");
			//System.out.println("xmlElementParts is "+xmlElementParts[0] );
			NodeList tempList= document.getElementsByTagName(xmlElementParts[0]);
			Element parentElement = (Element)tempList.item(0);
			nodeList=parentElement.getElementsByTagName(xmlElementParts[1]);
		}
		else{
			nodeList=document.getElementsByTagName(xmlElement);
		}
		for(int index=0; index<nodeList.getLength(); index++){
			LinkedHashMap<String, String> data=new LinkedHashMap<String, String>();
			element = (Element)nodeList.item(index);
			NodeList children = element.getChildNodes();
			for(int childIndex=0; childIndex<children.getLength(); childIndex++){
				Node childNode = children.item(childIndex);
				Element childElement=null;
				if(childNode.getNodeType()==Node.ELEMENT_NODE){
					childElement=(Element)childNode;
					data.put(childElement.getAttribute("name"), childElement.getTextContent());
				}
			}
			elementDetail.put(element.getAttribute("name"), data);
		}
		return elementDetail;
	}
//	public static void main(String[] args) {
//		QuestionGenerator qGen = new QuestionGenerator("");
//		qGen.populateQList("");
//		qGen.printQList(qGen.generateQList(25));
//	}

}
