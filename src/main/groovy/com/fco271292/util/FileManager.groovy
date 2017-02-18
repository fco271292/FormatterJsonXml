package com.fco271292.util

import com.fco271292.command.JSONCommand

import groovy.transform.CompileStatic

class FileManager {
	
	List<String> readFile(String filePath){
		def file = new File(filePath)
		List contentFile = file.readLines()
		println "Archivo ${contentFile}"
		contentFile
	}
	
	File createFile(JSONCommand jsonCommand){
		File fileJSON = new File("test.json")
		fileJSON << jsonCommand.header
		fileJSON << "\n"
		fileJSON << new FormatterJSON().formatterJSONPretty(jsonCommand.body)
	}
	
	
}
