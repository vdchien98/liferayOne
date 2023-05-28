package PortletB.portlet;

import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
public class CustomWebCacheItem implements WebCacheItem {

    private static final long ACCESS_TOKEN_EXPIRATION_TIME = Time.SECOND * 86400; // 1 day
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = Time.SECOND * 2592000; // 30 days

    private String methodName;

//    PortletRequest portletRequest = PortalUtil.getHttpServletRequest(renderRequest);
//    PortletSession portletSession = portletRequest.getPortletSession();
//    List<Map.Entry<String, Integer>> myList = (List<Map.Entry<String, Integer>>) portletSession.getAttribute("myList", PortletSession.APPLICATION_SCOPE);
    
    private List<Map.Entry<String, Integer>> myList;

    
    public CustomWebCacheItem(String methodName, List<Map.Entry<String, Integer>> myList) {
        this.methodName = methodName;
        this.myList = myList;
    }

    @Override
    public Object convert(String key) throws WebCacheException {
    	if(methodName.equals("access_token_key")) {
    		return myList  ;
    	}
			return null;
         }

    @Override
    public long getRefreshTime() {
          // Default refresh time
        return _REFRESH_TIME;
    }

    private static final long _REFRESH_TIME = Time.SECOND * 2592000;
}
