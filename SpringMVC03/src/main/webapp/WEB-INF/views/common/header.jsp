<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextPath}/">����1ź</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextPath}/">Home</a></li>
        <li><a href="boardMain.do">�Խ���</a></li>
        <li><a href="#">Page 2</a></li>
        </ul>
       <c:if test="${empty mvo}">
        <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">�����ϱ� <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">�α���</a></li>
            <li><a href="${contextPath}/memJoin.do">ȸ������</a></li>
          </ul>
        </li>
      </ul>
     </c:if>
     <c:if test="${!empty mvo}">
        <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">ȸ������ <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">ȸ����������</a></li>
            <li><a href="#">�����ʻ������</a></li>
            <li><a href="#">�α׾ƿ�</a></li>
          </ul>
        </li>
      </ul>
     </c:if>
    </div>
  </div>
</nav>