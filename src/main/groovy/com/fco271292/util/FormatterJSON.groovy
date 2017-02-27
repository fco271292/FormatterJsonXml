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
	
	String removeDash(String inputJSON){
		String bodyJSON = inputJSON.replaceAll("-","")
	}
	
	def adjustApostrophe(String jsonInput){
		
		String outJSON = ""
		String pattern = /",$/
		
		jsonInput.eachLine {line->
			if (line =~ pattern){
				line = line.replaceAll(~/[^\"]\"[^,$]/ , "'")
			}
			else if(line.endsWith(":") && !line.startsWith("\""))
				line = "\"${line.split(":").join("")}\":"
			outJSON += line
		}
		outJSON
		
	}
	
}
