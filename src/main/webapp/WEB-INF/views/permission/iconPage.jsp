<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript" src="<%=basePath%>js/common/permission/iconPage.js"></script>
 
 <input id="inconCode" name="inconCode" type="hidden" value="">
 
 <div class="easyui-layout" style="width:500px;height:290px;">

        <div id ='iconDiv' data-options="region:'center',noheader:true,iconCls:'icon-ok',border:false,collapsible:false">
          
          <c:forEach items="${list}" var="item">
             <span class="${item}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
          </c:forEach>
        </div>
        
        <div data-options="region:'south',noheader:true,collapsible:false" style="height:30px;">
           <div id="pp" style="background:#efefef;"></div>
        </div>
 
</div>
 

 

   