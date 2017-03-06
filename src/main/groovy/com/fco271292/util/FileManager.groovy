package com.fco271292.util

import com.fco271292.command.JSONCommand

import groovy.transform.CompileStatic

class FileManager {
	
	List<String> readFile(String filePath){
		
		def file = new File(filePath)
		List contentFile = file.readLines()
		
	}
	
	File createFile(String filePath,JSONCommand jsonCommand){
		
		Map<String,String> fileName = generateFileName(filePath)
		File fileJSON = new File("${fileName.name}.${fileName.fileFormat}")
		fileJSON << jsonCommand.header
		fileJSON << "\n"
		fileJSON << jsonCommand.body
		
	}
	
	Map<String,String> generateFileName(String filePath){
		
		Map<String,String> map = new HashMap<String, String>()
		File file = new File(filePath)
		String fileNameFull = file.name
		String name = fileNameFull.takeWhile {character->
			character != "."
		}
		name = "${name}_${new Date().format("YYYY_MM_dd")}"
		String fileFormat = fileNameFull.reverse().takeWhile {character->
			character != "."
		}
		map << ["name": name,"fileFormat":fileFormat.reverse()]
		
	}
	
	
}
