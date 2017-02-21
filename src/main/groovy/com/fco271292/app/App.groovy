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
		def bodyJSONAdjust = formatterJSON.adjustJSON(bodyJSON)
		//println "Header ${headerJSON} \n Body ${bodyJSON}"
		def jsonCommand = new JSONCommand(header: headerJSON,body: bodyJSONAdjust )
		//println "BODY ${bodyJSONAdjust}"
		new FileManager().createFile(pathFile,jsonCommand)
		println  "FIN..."
		
	}

}
