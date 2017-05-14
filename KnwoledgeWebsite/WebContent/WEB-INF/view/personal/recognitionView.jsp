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
				<td colspan="2" align="left"><title18>Recognitions</title18></td>
		</tr>
		</thead>
		<c:forEach items="${recognition.awards}" var="award">
			<thead>
			<tr bgcolor="#C9C299">
				<th colspan="2"><c:out value="${award.key}"/></th>
			</tr>
			</thead>
			 <c:set var="awardList" value="${award.value}" />
			 <c:forEach items="${awardList}" var="nextAward">
				<tr>
					<c:choose>
					<c:when test="${nextAward.name == 'Link'}">
						<td colspan="2"><a href="<c:url value="${nextAward.value}"/>"><font color="#0000A0">Click here to view certificate</font></a></td>
					</c:when>
					<c:otherwise>
						<td width="30%"><c:out value="${nextAward.name}"/></td><td><c:out value="${nextAward.value}"/></td>
					</c:otherwise>
					</c:choose>
				</tr>
			 </c:forEach>
		</c:forEach>
	</table>

</body>
</html>
