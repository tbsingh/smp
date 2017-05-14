<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Detail</title>
<style type="text/css" media="print"> 
	@media print { 
	body { display:none } 
	} 
</style> 
 <link rel="stylesheet" type="text/css" href="../css/test-style.css" />
 <script>
      //below javascript is used for Disabling right-click on HTML page
      document.oncontextmenu=new Function("return false");//Disabling right-click
      //below javascript is used for Disabling text selection in web page
      document.onselectstart=new Function ("return false"); //Disabling text selection in web page
      if (window.sidebar){
        	document.onmousedown=new Function("return false"); 
	       	document.onclick=new Function("return true") ; 
	       	//Disable Cut into HTML form using Javascript 
	       	document.oncut=new Function("return false"); 
	       	//Disable Copy into HTML form using Javascript 
	       	document.oncopy=new Function("return false"); 
	       	//Disable Paste into HTML form using Javascript  
	       	document.onpaste=new Function("return false"); 
      }
</script>
</head>
<body>
<table width="100%">
   <tr><td><p style="font-size:large; color:#0000FF"><c:out value="${command.category}"/></p></td></tr>
</table>
<table width="100%" class='viewForm bordered'>
 <tr><th width="40%" align="justify">Question</th>
	<th width="10%" align="justify">Correct Answer</th>
	<th width="10%" align="justify">Your Answer</th>
	<th width="40%" align="justify">Brief Detail</th>
 </tr>
	<c:forEach items="${command.questions}" var="question">
	<tr><td width="40%" align="justify">
	  <c:forTokens items="${question.qText}" delims="@" var="currentLine"  varStatus="status">
     		<c:out value="${currentLine}" escapeXml="false"/> <br />
      </c:forTokens>
	  <c:forEach items="${question.qOptions}" var="option">
			<c:out value="${option.key}."/><c:out value="${option.value}" escapeXml="false"/><br/>
		</c:forEach>
		</td>
		<td width="10%" align="justify"><c:out value="${question.qAnswer}"/></td>
		<td width="10%" align="justify"><c:out value="${question.userAnswer}"/></td>
		<td width="40%" align="justify"><c:out value="${question.qAnswerText}" escapeXml="false"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>