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
<div class="container">
<jsp:include page="../common/header.jsp"/>
  <h2>Spring MVC03</h2>
  <div class="panel panel-default">
    <div class="panel-heading">ȸ������</div>
    <div class="panel-body">
      <form action="${contextPath}/memRegister.do" method="post">
      	<table class="table table-bordered" style="text-align: center; border: 1px solid #dddddd;">
      		<tr>
      			<td style="width:110px; vertical-align: middle;">���̵�</td>
      			<td><input id="memID" name="memID" class="form-control" type="text" maxlength="20" placeholder="���̵� �Է��ϼ���."/></td>
      			<td style="width:110px;"><button class="btn btn-primary btn-sm" onclick="registerCheck()">�ߺ�Ȯ��</button></td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">��й�ȣ</td>
      			<td colspan="2"><input id="memPassword1" name="memPassword1" onkeyup="passwordCheck()" class="form-control" type="password" maxlength="20" placeholder="��й�ȣ�� �Է��ϼ���."/></td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">��й�ȣȮ��</td>
      			<td colspan="2"><input id="memPassword2" name="memPassword2" onkeyup="passwordCheck()" class="form-control" type="password" maxlength="20" placeholder="��й�ȣ�� Ȯ���ϼ���."/></td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">����� �̸�</td>
      			<td colspan="2"><input id="memName" name="memName" class="form-control" type="text" maxlength="20" placeholder="�̸��� �Է��ϼ���."/></td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">����</td>
      			<td colspan="2"><input id="memAge" name="memAge" class="form-control" type="password" maxlength="20" placeholder="���̸� Ȯ���ϼ���."/></td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">����</td>
      			<td colspan="2">
      				<div class="form-gtoup" style="text-align: center; margin: 0 auto;">
      					<div class="btn-group" data-toggle="buttons">
      						<label class="btn btn-primary active">
      							<input type="radio" id="memGender" name="memGender" autocomplete="off" value="����" checked/>����
      						</label>
      						<label class="btn btn-primary">
      							<input type="radio" id="memGender" name="memGender" autocomplete="off" value="����"/>����
      						</label>
      					</div>
      				</div>
      			</td>
      		</tr>
      		<tr>
      			<td style="width:110px; vertical-align: middle;">�̸���</td>
      			<td colspan="2"><input id="memEmail" name="memEmail" class="form-control" type="password" maxlength="20" placeholder="�̸����� �Է��ϼ���."/></td>
      		</tr>
      		<tr>
      			<td colspan="3" style="text-align: left;">
      				<input type="submit" class="btn btn-primary btn-sm pull-right" value="���"/>
      			</td>
      		</tr>
      	</table>
      </form>
	</div>
    <div class="panel-footer">����1ź_�輺��</div>
  </div>
</div>

</body>
</html>
