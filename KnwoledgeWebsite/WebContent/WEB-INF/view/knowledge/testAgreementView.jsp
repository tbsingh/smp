<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Terms and Conditions</title>
 <script type="text/javascript">
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
<form method="post">
	 <table><tr><td>The information published on this website is provided by <a href="<c:url value="http://tbsingh.appspot.com/"/>"><font color="#0000A0">www.tssa.co.in</font></a>, and while I, Tejbir Singh endeavour to keep the information </td></tr> 
	 		<tr><td> up to date and correct, I make no representations or warranties of any kind, express or implied, about the completeness, accuracy, reliability, suitability </td></tr>
	 		<tr><td> or availability with respect to the website or the information, products, or related graphics contained on the website for any purpose. In no event will</td></tr>
	 		<tr><td> I be liable for any loss or damage including without limitation, indirect or consequential loss or damage, or any loss or damage whatsoever arising from </td></tr>
			<tr><td> loss of data or profits arising out of, or in connection with, the use of this website.</td></tr>
			<tr><td></td></tr>
	</table>
	<table width="70%">
	<tr> 
 	<td align="center"><a  id="accepted" href="<c:url value="/knowledge/accepted.html"> <c:param name="accepted" value="Accepted"/></c:url>"><font color="#0000A0">Accept</font></a></td>
    <td align="center"><a id="decline" href="<c:url value="/knowledge/knowledgeView.html"/>"><font color="#0000A0">Decline</font></a></td>
	</tr>
	</table>
	<input type="hidden" value="C++ Test" name="cppTest"/> 
</form>
</body>
</html>