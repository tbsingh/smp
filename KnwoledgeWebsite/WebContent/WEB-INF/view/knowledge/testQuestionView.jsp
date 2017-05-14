<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Page</title>
<script type="text/javascript">

	  var _gaq = _gaq || [];
		 _gaq.push(['_setAccount', 'UA-31480332-1']);
		 _gaq.push(['_setDomainName', 'test-cplusplus-skills.appspot.com']);
		 _gaq.push(['_trackPageview']);
		
		 (function() {
		   var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		   ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		   var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		 })();
 </script>
</head>
<body>
<form method="POST" name="questionForm">
  	<table width="100%">
		 <tr><td colspan="3" style="font-size:small; color:#0000FF"><c:out value="${command.questionTitle}"/></td></tr>
		 <c:forTokens items="${command.currentQuestion.qText}" delims="@" var="currentLine"  varStatus="status">
     		<tr><td colspan="3">
     		<font color="#151B8D"><c:out value="${currentLine}" escapeXml="false"/></font>
     		</td></tr>
    	 </c:forTokens>
		
		 <c:forEach items="${command.currentQuestion.qOptions}" var="nextOption">
		  <tr><td width="5%"><input type="checkbox" name="${nextOption.key}"></td>
		  	  <td width="4%"><c:out value="${nextOption.key}."/></td>
		      <td width="91%"><c:out value="${nextOption.value}" escapeXml="false"/></td>
		  </tr>
		 </c:forEach>
	</table>
	<hr/> 
	<table width="60%"><tr align="center"><td width="40%"><input type="submit"  class="text-button" name="submit" value="Submit"></td>
		     <td width="20%"></td>
		 	 <td width="40%"><input type="button"  class="text-button" name="return" value="Return" onclick="window.location = '/knowledge/knowledgeView.html';"></td>
		   </tr>
	</table>
	<input type="hidden" value="C++ Objective Questions" name="cppObjectiveQuestions"/> 
</form>
 </body>
</html>