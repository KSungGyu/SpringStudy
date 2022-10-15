<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div class="container">
  <h2>Spring MVC03</h2>
  <div class="panel panel-default">
    <div class="panel-heading">ȸ������</div>
    <div class="panel-body">
      <form>
      	<table class="table table-bordered" style="text-align: center; border: 1px solid #dddddd;">
      		<tr>
      			<td style="width:110px; vertical-align: middle;">���̵�</td>
      			<td><input class="form-control" type="text" maxlength="20" placeholder="���̵� �Է��ϼ���."/></td>
      			<td style="width:110px;"><button class="btn btn-primary btn-sm">�ߺ�Ȯ��</button></td>
      		</tr>
      	</table>
      </form>
	</div>
    <div class="panel-footer">����1ź_�輺��</div>
  </div>
</div>

</body>
</html>
