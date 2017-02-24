package com.fco271292.util

import groovy.json.JsonOutput

class FormatterJSON {
	
	String formatterJSONPretty(String inputJSON){
		
		String json = JsonOutput.prettyPrint(inputJSON)
		
	}
	
	String getHeaderJSON(String inputJSON){
		
		String headerJSON = ""
		headerJSON = inputJSON.takeWhile {character->
			character != "{"			
		}
		
		headerJSON
	}
	
	String getbodyJSON(String inputJSON){
		
		String bodyJSON = ""
		Integer indexOfParenthesis = inputJSON.toString().indexOf("{")
		Integer lastIndexOfParenthesis = inputJSON.toString().indexOf("}")
		bodyJSON = inputJSON.toString().subSequence(indexOfParenthesis,inputJSON.toString().length())
		
	}
	
	String adjustJSON(String inputJSON){
		String bodyJSON = inputJSON.replaceAll("-","")
	}
	
	String addQuotes(String inputJSON){
		String outJSON = ""
		inputJSON.eachLine{line->
			if(line.endsWith(":") && !line.startsWith("\""))
				line = "\"${line.split(":").join("")}\":"
			else{
				//print line
				//println "_"*5
			}
			outJSON += line
		}
		outJSON
	}
	
	def outJSON(String jsonInput){
		def object = JsonOutput.toJson(jsonInput)
		def json = object.replaceAll(~/\\n/,"")
		println json
		//println formatterJSONPretty(json)
		//formatterJSONPretty(json)
	}
	
}
