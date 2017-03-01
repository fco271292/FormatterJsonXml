package com.fco271292.app

import com.fco271292.command.JSONCommand
import com.fco271292.util.FileManager
import com.fco271292.util.FormatterJSON

class App {

	static main(args) {
		
		FormatterJSON formatterJSON = new FormatterJSON()
		FileManager fileManager  = new FileManager()
		File file = new File("")
		
		String pathFile = "${file.absolutePath}\\src\\test\\groovy\\source\\jsonTest.json"
		
		def contentFile =fileManager.readFile(pathFile)
		String contentFileString = contentFile.join("\n")
		String headerJSON = formatterJSON.getHeaderJSON(contentFileString)
		String bodyJSON = formatterJSON.getbodyJSON(contentFileString)
		
		def adjustApostrophe = formatterJSON.adjustApostrophe(bodyJSON)
		def removeDash = formatterJSON.removeDash(adjustApostrophe)
		println "BODY ${removeDash}"
		
		def jsonCommand = new JSONCommand(header: headerJSON,body: removeDash )
		
		new FileManager().createFile(pathFile,jsonCommand)
		println  "FIN..."
		
	}

}
