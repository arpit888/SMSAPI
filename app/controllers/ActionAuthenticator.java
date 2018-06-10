package controllers;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.cache.*;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class ActionAuthenticator extends Security.Authenticator {  
    private SyncCacheApi tokenCache;
    private static final Logger LOG = LoggerFactory.getLogger("msg");
    
    @Inject
    public ActionAuthenticator(SyncCacheApi tokenCache) {
        this.tokenCache = tokenCache;
    }
    
	
	@Override
    public String getUsername(Http.Context ctx) {
        String token = getTokenFromHeader(ctx);
        LOG.info("get Token from header {} ", token);
        if (token != null && tokenCache.get(token) != null) {
            return token;
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context context) {
        return super.onUnauthorized(context);
    }

    private String getTokenFromHeader(Http.Context ctx) {
        String[] authTokenHeaderValues = ctx.request().headers().get("tok");
        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
            return authTokenHeaderValues[0];
        }
        return null;
    }
}