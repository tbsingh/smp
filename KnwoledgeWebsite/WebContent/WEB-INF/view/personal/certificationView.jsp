<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<table width="100%" class='viewForm bordered'>
		<thead>
		<tr bgcolor="#ECE5B6">
				<td colspan="2" align="left"><title18>Certifications</title18></td>
		</tr>
		</thead>
		<c:forEach items="${certification.awards}" var="award">
			<thead>
			<tr bgcolor="#C9C299">
				<th colspan="2"><c:out value="${award.key}"/></th>
			</tr>
			</thead>
			 <c:set var="awardList" value="${award.value}" />
			 <c:forEach items="${awardList}" var="nextAward">
				<tr>
					<td width="30%"><c:out value="${nextAward.name}"/></td><td><a href="<c:url value="${nextAward.link}"/>"><font color="#0000A0">Click here to view certificate</font></a></td>
				</tr>
			 </c:forEach>
		</c:forEach>
	</table>

</body>
</html>
