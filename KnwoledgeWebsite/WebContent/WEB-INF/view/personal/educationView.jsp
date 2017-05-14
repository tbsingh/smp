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
				<td colspan="2" align="left"><title18>Educational Qualifications</title18></td>
		</tr>
		</thead>
		<c:forEach items="${education.certificates}" var="certificate">
			<thead>
			<tr bgcolor="#C9C299">
				<th colspan="2"><c:out value=""/><c:out value="${certificate.name}"/></th>
			</tr>
			</thead>
			<tr>
				<td width="30%"><c:out value="Institution/University"/></td><td><c:out value="${certificate.institution}"/></td>
			</tr>
			<tr>
				<td width="30%"><c:out value="Subject(s)"/></td><td><c:out value="${certificate.subjects}"/></td>
			</tr>
			<tr>
				<td width="30%"><c:out value="Grade"/></td><td><c:out value="${certificate.marks}"/></td>
			</tr>
			<tr>
				<td width="30%"><c:out value="Certificate"/></td><td><a href="<c:url value="/personal/certificateView.html"><c:param name="docLink" value="${certificate.link}"/></c:url>"><font color="#0000A0">Click here to view certificate</font></a></td>
			</tr>
		</c:forEach>
			
	
	</table>

</body>
</html>
