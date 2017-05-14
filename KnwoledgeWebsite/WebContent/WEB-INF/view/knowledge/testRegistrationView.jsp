<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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

<form method="post" >
<spring:nestedPath path="command">
<table class="viewForm">
  <tr><th COLSPAN="2">Welcome to the online Skill Management Platform. Hope you will enjoy the information published on this website. Before starting, can I ask you to provide below information about you. 
  					  Please note, the registration information is just to letting us know about you in brief.</th>
  </tr>
  <tr>
    <td>First Name:</td>
    <td>
    <spring:bind path="firstName">
        <input type="text" name="<c:out value="${status.expression}"/>"
        value="<c:out value="${status.value}"/>" size="20" onFocus="if(this.value=='First Name') this.value='';" />
        <span class="errorMessage"><c:out value="${status.errorMessage}" /></span>
    </spring:bind>
    </td>
  </tr>
   <tr>
    <td>Second Name:</td>
    <td>
    <spring:bind path="secondName">
       <input type="text" name="<c:out value="${status.expression}"/>"
        value="<c:out value="${status.value}"/>" size="20" onFocus="if(this.value=='Second Name') this.value='';" />
        <span class="errorMessage"><c:out value="${status.errorMessage}" /></span>
    </spring:bind>
    </td>
  </tr>
  <tr>
    <td>Email Address:</td>
    <td>
    <spring:bind path="emailAddress">
      <input type="text" name="<c:out value="${status.expression}"/>"
             value="<c:out value="${status.value}"/>" size="20" onFocus="if(this.value=='Email Address') this.value='';" />
      <span class="errorMessage"><c:out value="${status.errorMessage}" /></span>
    </spring:bind>
     
    </td>
  </tr>
  <tr></tr>
  <tr>
  	<td align="center"><input type="submit" name="submit" value="Submit"/></td>
  	<td align="center"><input type="button" name="noThanks" value="No Thanks" onClick="window.location = '/knowledge/knowledgeView.html';"/></td>
  </tr>
</table>

</spring:nestedPath>
<input type="hidden" value="Test Your C++ Skills" name="testYourCppSkills"/> 
</form>
</body>
</html>
