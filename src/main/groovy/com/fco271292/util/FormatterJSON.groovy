package com.fco271292.util

import groovy.json.JsonOutput

class FormatterJSON {
	
	String formatterJSONPretty(String inputJSON){
		String json = JsonOutput.prettyPrint(inputJSON)
		//println "JSON ${json}"
	}
	
	def validateJSONInput(List<String> inputJSON){
		//println inputJSON
		String firtsParenthesis = inputJSON.find{character->
			character.contains('{')
		}
		println "Encontro ${firtsParenthesis}"
	}
	
	String getHeaderJSON(List<String> inputJSON){
		
		String headerJSON = ""
		headerJSON = inputJSON.toString().takeWhile {character->
			character != "{"			
		}
		
		headerJSON
	}
	
	String getbodyJSON(List<String> inputJSON){
		String bodyJSON = ""
		Integer indexOfParenthesis = inputJSON.toString().indexOf("{")
		Integer lastIndexOfParenthesis = inputJSON.toString().indexOf("}")
		bodyJSON = inputJSON.toString().subSequence(indexOfParenthesis,inputJSON.size())
		//println "Salida body ${bodyJSON}"
		bodyJSON
	}
}
