<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Result</title>
 <script type="text/javascript">
	     var _gaq = _gaq || [];
         _gaq.push(['_setAccount', 'UA-31480332-1']);
         _gaq.push(['_trackPageview']);
         (function() {
             var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
             ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
             var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
         })();

       </script>
</head>
<body>
<table>
<tr><th> <c:out value=" Congratulations!!! your Test Score is ${command.score}%"/></th></tr>
</table>
<table width="100%" class='viewForm bordered'>
	
	<c:forEach items="${command.result}" var="resultPart">
		  <tr>
		   <td width="60%"><c:out value="${resultPart.key}"/></td>
		   <td width="20%"><c:out value="${resultPart.value}%"/></td>
		   <td align="center"><a href="<c:url value="/knowledge/testResultDetailView.html?category=${resultPart.key}" />" target="_blank"><font color="#25383C"/>View Result Detail</a></td>
		  </tr>
	</c:forEach>
</table>
</body>
</html>