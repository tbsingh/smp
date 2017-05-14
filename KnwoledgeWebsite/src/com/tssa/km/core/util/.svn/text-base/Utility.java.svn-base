package com.tssa.km.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Stack;

import com.tssa.km.domain.Question;

public class Utility {
	
	public static String preserveFormating(String qText) {
		StringBuffer buffer = new StringBuffer();
		String []lines = qText.split("\n");
		for(int i=0; i<lines.length; i++){
			String line = lines[i].replaceAll("&", "&amp;");
			line=line.replaceAll("\"", "&quot;");
			line=line.replaceAll("<", "&lt;");
			line=line.replaceAll(">", "&gt;");
			buffer.append(lines[i]);
			buffer.append("@");
		}
		return doIntendation(buffer.toString());
	}
	public static String doIntendation(String text) {
		StringBuffer buffer = new StringBuffer();
		Stack<String> stack = new Stack<String>();
		String space="&nbsp;&nbsp;&nbsp;";
		String spaces="";
		String lines[]=text.split("@");
		for(int i=0; i<lines.length; i++){
			String line=lines[i];
			if(line.trim().endsWith("{")){
				text="open";
				stack.push("{");
			}
			else if((line.trim().endsWith("}") && !line.contains("{")) || (line.trim().endsWith(";") && line.contains("}"))  ){
				if(stack.size() !=0){
					stack.pop();
					text="close";
				}else{
					System.out.println("There is mismatch of curly bracketd in question "+text);
				}
			}

				if(text.equals("open")){
					buffer.append(spaces+line);	
				    spaces="";
				    for(int j=0; j<stack.size(); j++){
					    spaces=spaces+space;
				    }
				    text="";
				}
				else if(text.equals("close")){
					
					spaces="";
					for(int k=0; k<stack.size(); k++){
						spaces=spaces+space;
					}
					buffer.append(spaces+line);	
					
					text="";
				}
				else{
					buffer.append(spaces+line);	
				}
				buffer.append("@");

		}
		//System.out.println(buffer);
		return buffer.toString();
	}
	public static String questionToString(List<Question>qlist){
		StringBuffer strQList = new StringBuffer();
		for (int i=0; i<qlist.size(); i++){
			if(i==0){
				strQList.append(i+"="+qlist.get(i).getqNo());
			}else{
				strQList.append(","+i+"="+qlist.get(i).getqNo());
			}
		}
		return strQList.toString();
	}
}
