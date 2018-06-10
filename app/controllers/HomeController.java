package controllers;

import play.mvc.*;
import play.libs.Json;
import play.cache.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	private static final Logger LOG = LoggerFactory.getLogger("msg");
    
    private SyncCacheApi cache;
    private SyncCacheApi requestCache;
    private SyncCacheApi tokenCache;

    @Inject
    public HomeController(SyncCacheApi cache, SyncCacheApi RequestCache, SyncCacheApi tokenCache) {
        this.cache = cache;
        this.requestCache = RequestCache;
        this.tokenCache = tokenCache;
    }
    

    public Result getToken(String username) {
    	String uuid = UUID.randomUUID().toString();
    	tokenCache.set(uuid,7 * 60 * 240);
    	ObjectNode result = Json.newObject();
    	result.put("username", username);
	    result.put("tok", uuid);
	    return ok(result);
    }
    @Security.Authenticated(ActionAuthenticator.class)
    public Result getSms(String from, String to , String text) {
    	
    	LOG.info("getSms {} {} {}", from, to, text);
    	ObjectNode result = Json.newObject();
    	HashMap<String,String> hashmap=new HashMap<String,String>();
		hashmap.put("from", from);
		hashmap.put("to", to);
		hashmap.put("text", text);
		hashmap = ValidateInput.CheckMissingParameter(hashmap);
		if(hashmap.isEmpty()) {
			//case where nothing is missing
	    	HashMap<String,String> invalidHashMap=new HashMap<String,String>();
	    	invalidHashMap.put("from", from);
	    	invalidHashMap.put("to", to);
	    	invalidHashMap.put("text", text);
			LOG.info("invalid hash map size {} ",invalidHashMap.size());
			invalidHashMap = ValidateInput.CheckValidity(invalidHashMap);
			if(invalidHashMap.isEmpty()) {
				// case where data is not missing and is valid
		        if(text.contains("STOP")) {
		        	cache.set(to,from,60 * 240);
		        }
		        String output = cache.get(to);
		        LOG.info("get cache {}", output);
		        result.put("message", "inbound sms is ok");
		        result.put("error", "");
		        return ok(result);
			}
			else {
				String invalidParameters = null;
				for(Iterator<HashMap.Entry<String,String>>it=invalidHashMap.entrySet().iterator();it.hasNext();){
				     HashMap.Entry<String, String> entry = it.next();
				     if(invalidParameters == null)
				    	 invalidParameters = entry.getKey();
				     else
				    	 invalidParameters = invalidParameters + " " + entry.getKey();
				 }
				result.put("message", "");
	            result.put("error", invalidParameters + " Parameter is invalid");
	            return ok(result);
			}
		}
		else {
			String missingParameter = null;
			for(Iterator<HashMap.Entry<String,String>>it=hashmap.entrySet().iterator();it.hasNext();){
			     HashMap.Entry<String, String> entry = it.next();
			     if(missingParameter == null)
			    	 missingParameter = entry.getKey();
			     else
			    	 missingParameter = missingParameter + " " + entry.getKey();
			 }
			result.put("message", "");
            result.put("error", missingParameter + " Parameter is Missing");
            return ok(result);
		}
    }
    @Security.Authenticated(ActionAuthenticator.class)
    public Result outboundSms(String from, String to , String text) {
    	LOG.info("outboundSms {} {} {}", from, to, text);
    	ObjectNode result = Json.newObject();
    	//caching check
    	if(requestCache.get(from) == null) {
    		requestCache.set(from,1,60);
    	}
    	else {
    		int count = requestCache.get(from);
    		count = count +1;
    		requestCache.set(from,count);
    		LOG.info("get Count in outboundSms {}", count);
    	}
    	
    	// Limit check
    	
    	if((int)requestCache.get(from) >50) {
    		result.put("message", "");
            result.put("error", "limit reached for from " + from);
            return ok(result);
    	}
    	
    	// missing check
    	HashMap<String,String> hashmap=new HashMap<String,String>();
		hashmap.put("from", from);
		hashmap.put("to", to);
		hashmap.put("text", text);
		hashmap = ValidateInput.CheckMissingParameter(hashmap);
		if(hashmap.isEmpty()) {
			//case where nothing is missing
	    	HashMap<String,String> invalidHashMap=new HashMap<String,String>();
	    	invalidHashMap.put("from", from);
	    	invalidHashMap.put("to", to);
	    	invalidHashMap.put("text", text);
			LOG.info("invalid hash map size {} ",invalidHashMap.size());
			invalidHashMap = ValidateInput.CheckValidity(invalidHashMap);
			if(invalidHashMap.isEmpty()) {
				// case where data is not missing and is valid
		        String output = cache.get(to);
		        LOG.info("get cache in outboundSms {}", output);
		        if(output != null && output.equals(from)) {
		        	result.put("message", "");
		            result.put("error", "sms from " + from + " and to " + to + " blocked by STOP request");
		            return ok(result);
		        }
		        result.put("message", "out bound sms is ok");
		        result.put("error", "");
		        return ok(result);
			}
			else {
				String invalidParameters = null;
				for(Iterator<HashMap.Entry<String,String>>it=invalidHashMap.entrySet().iterator();it.hasNext();){
				     HashMap.Entry<String, String> entry = it.next();
				     if(invalidParameters == null)
				    	 invalidParameters = entry.getKey();
				     else
				    	 invalidParameters = invalidParameters + " " + entry.getKey();
				 }
				result.put("message", "");
	            result.put("error", invalidParameters + " Parameter is invalid");
	            return ok(result);
			}
		}
		else {
			String missingParameter = null;
			for(Iterator<HashMap.Entry<String,String>>it=hashmap.entrySet().iterator();it.hasNext();){
			     HashMap.Entry<String, String> entry = it.next();
			     if(missingParameter == null)
			    	 missingParameter = entry.getKey();
			     else
			    	 missingParameter = missingParameter + " " + entry.getKey();
			 }
			result.put("message", "");
            result.put("error", missingParameter + " Parameter is Missing");
            return ok(result);
		}    

    }
}
