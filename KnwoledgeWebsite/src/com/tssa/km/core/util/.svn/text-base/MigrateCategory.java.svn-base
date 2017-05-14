package com.tssa.km.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class MigrateCategory {
	
	public static void main(String[] args) {
		new MigrateCategory().migrate();
		
	}
	void migrate(){
		Properties catProp = new Properties();
		int id=0;
		try {
			catProp.load(new FileInputStream(new File("E:\\workspaces\\KnowledgeWebsite\\WebContent\\conf\\category.properties")));
			PrintWriter  sqlFileWriter = new PrintWriter (new File("E:\\workspaces\\KnowledgeWebsite\\WebContent\\conf\\category.sql"));
			sqlFileWriter.write("INSERT INTO kmp_questions_category (id, name, description, created_ts)VALUES\n");
			for(Object key : catProp.keySet()){
				String sqlRow=null;
				id++;
				if(id==catProp.size()){
					// for migration purpose
					sqlFileWriter.write("qCategoryMap.put(\""+key+"\","+id+");\n");
					//sqlRow = "('"+id+"','"+key+"','"+catProp.getProperty((String) key)+"',now());\n";
				}else{
					sqlFileWriter.write("qCategoryMap.put(\""+key+"\","+id+");\n");
					//sqlRow = "('"+id+"','"+key+"','"+catProp.getProperty((String) key)+"',now()),\n";
				}
				//sqlFileWriter.write(sqlRow);
			}
			sqlFileWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blocker
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
