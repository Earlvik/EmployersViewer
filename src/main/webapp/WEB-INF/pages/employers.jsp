<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css"  rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css"  rel="stylesheet">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="/resources/EmployerViewer.js"></script>
</head>
<div class="container">
    <div class="row">
        <div class="span8 offset2">

            <h1>Add new employee</h1>
            <form:form action="add" method="get">
                <input type="submit" class="btn" value="Add new employee"/>
            </form:form>
            <form:form id="findEmployerForm" action="${pageContext.request.contextPath}/find" method="get" commandName="employer">
                <div class="control-group">
                    <form:label path="firstName" cssClass="control-label">First name:</form:label>
                    <div class="controls">
                        <form:input path="firstName"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="secondName" cssClass="control-label">Second name:</form:label>
                    <div class="controls">
                        <form:input path="secondName"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="lastName" cssClass="control-label">Last name:</form:label>
                    <div class="controls">
                        <form:input path="lastName"/>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="submit" value="Find Employees" class="btn">
                    </div>
                </div>
            </form:form>
            <div id="employerFromResponse"></div>
            <c:if test="${!empty employers}">
                <h3>Employees</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Experience</th>
                        <th>Description</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employers}" var="employer" varStatus="loop">
                        <tr>
                            <td>${employer.firstName} ${employer.secondName} ${employer.lastName}</td>
                            <td>${employer.age}</td>
                            <td>${employer.experience}</td>
                            <td>${employer.description}</td>
                            <td>
                                <input type="submit" class="btn btn-danger btn-min" onclick="deleteEmployer(${employer.id})" value="Delete">
                            </td>
                            <td><form:form action="edit/${employer.id}" method="get">
                                <input type="submit" class="btn btn-min" value="Edit">
                            </form:form> </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>