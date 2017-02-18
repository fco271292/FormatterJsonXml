package com.fco271292.app

import com.fco271292.command.JSONCommand
import com.fco271292.util.FileManager
import com.fco271292.util.FormatterJSON

class App {

	static main(args) {
		
		String pathFile = "C:\\Users\\Gigabyte\\Documents\\workspace\\FormatterJsonXml\\src\\test\\groovy\\source\\jsonTest.json"
		def fileTest = new File(pathFile)
		def contentFile = new FileManager().readFile(fileTest.getPath())
		String headerJSON = new FormatterJSON().getHeaderJSON(contentFile)
		String bodyJSON = new FormatterJSON().getbodyJSON(contentFile)
		println "Header ${headerJSON} \n Body ${bodyJSON}"
		def jsonCommand = new JSONCommand(header: headerJSON,body: bodyJSON )
		//new FileManager().createFile(jsonCommand)
		println  "FIN..."
		//new FormatterJSON().formatterJSONPretty(bodyJSON)
		//new FormatterJSON().validateJSONInput(jsonInput)
	}

}
