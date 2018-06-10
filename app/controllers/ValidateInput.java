package controllers;

import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateInput {
	
	private static final Logger LOG = LoggerFactory.getLogger("msg");
	
	public static HashMap<String,String> CheckValidity(HashMap<String,String> hashmap) {
		
		for(Iterator<HashMap.Entry<String,String>>it=hashmap.entrySet().iterator();it.hasNext();){
	   	     HashMap.Entry<String, String> entry = it.next();
	   	     if(entry.getKey().equals("text")) {
		    	if(validText(entry.getValue())) {
		    		it.remove();
		    	}
	   	     }
	   	     else {
	   	    	 if(validNumber(entry.getValue())) {
	   	    		 it.remove();
	   	    	 }
	   	     }
	   	 }
	   	
	   	return hashmap;
	}

public static HashMap<String,String> CheckMissingParameter(HashMap<String,String> hashmap) {

	for(Iterator<HashMap.Entry<String,String>>it=hashmap.entrySet().iterator();it.hasNext();){
	     HashMap.Entry<String, String> entry = it.next();
	     if (entry.getValue() != null) {
	          it.remove();
	     }
	 }
	
	return hashmap;	
		
	}

public static boolean validNumber(String s){
    if(s != null && s.length() >=6 && s.length() <=16){
        return true;
    }
    return false;
}

public static boolean validText(String s){
    if(s != null && s.length() >=1 && s.length() <=120){
        return true;
    }
    return false;
}
}
