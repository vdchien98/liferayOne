<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="portleta.caption"/></b>
</p>


<liferay-portlet:renderURL var="portletBURL" portletName="PortletB">
    <liferay-portlet:param name="javax.portlet.action" value="myAction" />
    <liferay-portlet:param name="myList" value="${myList}" />
</liferay-portlet:renderURL>