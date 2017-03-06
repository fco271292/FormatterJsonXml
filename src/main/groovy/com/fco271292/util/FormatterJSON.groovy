package com.fco271292.util

import groovy.json.JsonOutput
import java.util.regex.Pattern

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
		String patternApostrophe = /.*=\"[^\",]/
		String patternDoubleApostrophe = /\\+"/

		jsonInput.eachLine {line->
			if (line =~ patternDoubleApostrophe ){
				line = line.replaceAll(patternDoubleApostrophe,"\"")
			}
			/*if (line =~ pattern){
				//if(line.count("\"")>2 && line.count("\"")<10)
					line = line.replaceAll(~/[^\"]\"[^,$]/ , "'")
			}*/
			else if(line.endsWith(":") && !line.startsWith("\""))
				line = "\"${line.split(":").join("")}\":"
			else if(line =~ patternApostrophe)
				line = line.replaceAll("[^\"]\"","'")
			
			outJSON += line
		}
		outJSON
		
	}
	
	String convertStringToJSON(String jsonInput){
		JsonOutput.toJson(jsonInput)
	}
	
	String getSubstringJSON(String jsonInput){
		jsonInput.substring(1, jsonInput.length()-1)
	}
	
	String replaceWithExpressionRegulate(String line,Pattern pattern,String replacement){
		line.replaceAll(~/${pattern}/, "${replacement}")
	}
	
	String prettyPrintJSON(String jsonInput){
		JsonOutput.prettyPrint(jsonInput)
	}
	
}
