<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
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
<spring:hasBindErrors name="command">
  <div class="errorMessage"><fmt:message key="errors.global" /></div>
  <br />
  <spring:bind path="command">
    <div class="errorMessage"><c:out value="${status.errorMessage}" /></div>
    <br />
  </spring:bind>
</spring:hasBindErrors>

<form id="verifyForm" method="post">
<spring:nestedPath path="command">
<table class="viewForm">
  <tr align="center"><th COLSPAN="2">!!!!!SORRY....But You Need to Provide Below Information to View This Page!!!!</th>
  </tr>
  <tr></tr>
  <tr>
    <td> What is your pet name?</td>
    <td>
    <spring:bind path="petName">
        <input type="password" name="<c:out value="${status.expression}"/>"
        value="<c:out value="${status.value}"/>" size="20" onFocus="if(this.value=='First Name') this.value='';" />
        <span class="errorMessage"><c:out value="${status.errorMessage}" /></span>
    </spring:bind>
    </td>
  </tr>
   <tr>
    <td>What is your date of birth?</td>
    <td>
    <spring:bind path="dob">
       <input type="password" name="<c:out value="${status.expression}"/>"
        value="<c:out value="${status.value}"/>" size="20" onFocus="if(this.value=='Second Name') this.value='';" />
        <span class="errorMessage"><c:out value="${status.errorMessage}" /></span>
    </spring:bind>
    </td>
  </tr>
  <tr></tr>
  <tr>
  	<td align="center"><input type="submit" id="submit" value="Submit"/></td>
  	<td align="center"><input type="button" id="noThanks" value="No Thanks" onClick="window.location = 'http://tbsingh.appspot.com/';"/></td>
  </tr>
</table>

</spring:nestedPath>
<input type="hidden" value="Test Your C++ Skills" name="testYourCppSkills"/> 
</form>
</body>
</html>
