package PortletA.portlet;

import PortletA.constants.PortletAPortletKeys;
import PortletB.portlet.CustomWebCacheItem;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portal.kernel.webcache.WebCachePoolUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import java.util.AbstractMap.SimpleEntry;
/**
 * @author vudan
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PortletA", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + PortletAPortletKeys.PORTLETA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PortletAPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
          
//		WebCacheItem wca = new CustomWebCacheItem("access_token_key");
//		WebCachePoolUtil.get("access_token_key", wca);
//		System.out.println("WebCachePoolUtil.get(keys, wci)***" + WebCachePoolUtil.get("access_token", wca));
//		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		renderRequest.setAttribute("userId", userId);
		// System.out.println("userId viewGioLam "+userId);

		
		List<Map.Entry<String, Integer>> myList = new ArrayList<>();

        // Thêm các cặp key-value vào danh sách
        myList.add(new SimpleEntry<>("portletA", 11));
        myList.add(new SimpleEntry<>("portletB", 22));
        WebCacheItem customWebCacheItem = new CustomWebCacheItem("access_token_key", myList);
        WebCachePoolUtil.get("access_token_key", customWebCacheItem);
        System.out.println("WebCachePoolUtil.get(keys, wci)***" + WebCachePoolUtil.get("access_token_key", customWebCacheItem));
        
        
        
        // In danh sách
//        for (Map.Entry<String, Integer> entry : myList) {
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//        }
//      
//        PortletSession portletSession = renderRequest.getPortletSession();
//        portletSession.setAttribute("myList", myList, PortletSession.APPLICATION_SCOPE);
        
        
		super.render(renderRequest, renderResponse);
	}

}