<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Виктор
  Date: 16.10.2014
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit employee</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css"  rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css"  rel="stylesheet">

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="/resources/editEmployerViewer.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <h1>Edit employee ${employer.firstName} ${employer.lastName}</h1>
            <div id="EmployerFromResponse"></div>
            <form:form  id="editEmployerForm" method="post" action="${pageContext.request.contextPath}/edit/${employer.id}" commandName="employer" class="form-horizontal">
                <div class="control-group">
                    <form:label path="id" cssClass="control-label">Id:</form:label>
                    <div class="controls">
                        <form:input path="id" disabled="true"/>
                    </div>
                </div>
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
                    <form:label path="age" cssClass="control-label">Age:</form:label>
                    <div class="controls">
                        <form:input path="age"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="experience" cssClass="control-label">Experience:</form:label>
                    <div class="controls">
                        <form:input path="experience"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="description" cssClass="control-label">Description:</form:label>
                    <div class="controls">
                        <form:input path="description"/>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="submit" value="Save Employee" class="btn">
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>

