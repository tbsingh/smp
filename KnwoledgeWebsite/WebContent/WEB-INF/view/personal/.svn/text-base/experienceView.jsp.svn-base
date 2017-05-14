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
				<td colspan="2" align="left"><title18>Professional Experience</title18></td>
		</tr>
		</thead>
		<c:forEach items="${experience.companies}" var="company">
			<thead>
			<tr bgcolor="#C9C299">
				<th colspan="2"><c:out value="${company.name}(${company.fromDate}"/><c:out value="-"/><c:out value="${company.toDate})"/></th>
			</tr>
			</thead>
			<tr>
				<td width="30%"><c:out value="Role"/></td><td><c:out value="${company.role}"/></td>
			</tr>
			<tr>
				<td width="30%"><c:out value="Technologies Used"/></td><td><c:out value="${company.workedWith}"/></td>
			</tr>
			<tr>
				<td width="30%"><c:out value="Experience Cetificate"/></td><td><a href="<c:url value="${company.expCertificate}"/>"><font color="#0000A0">Click here to view certificate</font></a></td>
			</tr>
		</c:forEach>
			
	
	</table>

</body>
</html>
