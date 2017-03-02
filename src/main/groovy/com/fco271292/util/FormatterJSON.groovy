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
		String patternApostrophe = /\w*=\"[^\"]/
		String patternDoubleApostrophe = /\\"/

		jsonInput.eachLine {line->
			if (line =~ pattern){
				if(line.count("\"")>2 && line.count("\"")<10)
					line = line.replaceAll(~/[^\"]\"[^,$]/ , "'")
			}
			else if(line.endsWith(":") && !line.startsWith("\""))
				line = "\"${line.split(":").join("")}\":"
			else if(line =~ patternApostrophe)
				line = line.replaceAll("[^\"]\"","'")
			if (line =~ patternDoubleApostrophe ){
				line = line.replaceAll(patternDoubleApostrophe,"\"")				
			}
			outJSON += line
		}
		outJSON
		
	}
	
}
