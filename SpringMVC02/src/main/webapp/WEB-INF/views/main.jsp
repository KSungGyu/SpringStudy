<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC02</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		loadList();
  	});
  	function loadList(){
  		//서버와 통신 : 게시판 리스트 가져오기
  		$.ajax({
  			url : "boardList.do",
  			type : "get",
  			dataType : "json",
  			success : makeView,
  			error : function(){ alert("error"); }
  		});
  	}						 //	  	   0    1    2
  	function makeView(data){ // data=[{ }, { }, { } ,,, ]
  		var listHtml="<table class='table table-bordered'>";
  		listHtml+="<tr>"
  		listHtml+="<td>번호</td>";
  		listHtml+="<td>제목</td>";
  		listHtml+="<td>작성자</td>";
  		listHtml+="<td>작성일</td>";
  		listHtml+="<td>조회수</td>";
  		listHtml+="</tr>";
  		$.each(data, function(index,obj ){  // obj={"idx":5, "title":"게시판"~~~~}
  		listHtml+="<tr>"
  		listHtml+="<td>"+obj.idx+"</td>";
  		listHtml+="<td id='t"+obj.idx+"'><a href='javascript:goContent("+obj.idx+")'>"+obj.title+"</a></td>";
  		listHtml+="<td>"+obj.writer+"</td>";
  		listHtml+="<td>"+obj.indate+"</td>";
  		listHtml+="<td>"+obj.count+"</td>";
  		listHtml+="</tr>";
  		
  		listHtml+="<tr id='c"+obj.idx+"' style='display:none'>";
  		listHtml+="<td>내용</td>";
  		listHtml+="<td colspan='4'>";
  		listHtml+="<textarea id='ta"+obj.idx+"' readonly rows='7' class='form-control'>"+obj.content+"</textarea>";
  		listHtml+="<br/>";
  		listHtml+="<span id='ub"+obj.idx+"'><button class='btn btn-success btn-sm' onclick='goUpdateForm("+obj.idx+")'>수정화면</button></span>&nbsp;";
  		listHtml+="<button class='btn btn-warning btn-sm' onclick='goDelete("+obj.idx+")'>삭제</button>";
  		listHtml+="</td>";
  		listHtml+="</tr>";
  		});
  		
  		listHtml+="<tr>";
  		listHtml+="<td colspan='5'>";
  		listHtml+="<button class='btn btn-primary btn-sm' onclick='goForm()'>글쓰기</button>";
  		listHtml+="</td>";
  		listHtml+="</tr>";
  		listHtml+="</table>";
  		$("#view").html(listHtml);
  		
  		$("#view").css("display","block"); // 보이기
  		$("#wform").css("display","none"); // 감추기
  	}
  	function goForm(){
  		$("#view").css("display","none"); // 감추기
  		$("#wform").css("display","block"); // 보이기
  	}
  	function goList(){
  		$("#view").css("display","block"); // 보이기
  		$("#wform").css("display","none"); // 감추기
  	}
  	function goInsert(){
  		//var title=$("#title").val();
  		//var title=$("#content").val();
  		//var title=$("#writer").val();
  		
  		var fData=$("#frm").serialize();
  		// alert(fData);
  		$.ajax({
  			url : "boardInsert.do",
  			type : "post",
  			data : fData,
  			success : loadList,
  			error : function() {alert("error"); }
  		});
  		//폼 초기화
  		// $("#title").val("");
  		// $("#content").val("");
  		// $("#writer").val("");
  		$("#fclear").trigger("click");
  	}
  	function goContent(idx){ // idx=11, 10, 9
  		if($("#c"+idx).css("display")=="none"){
  			$("#c"+idx).css("display","table-row"); //보이게
  			$("#ta"+idx).attr("readonly",true)
  		}else{
  			$("#c"+idx).css("display","none"); //감추게
  		}
  	}
  	function goDelete(idx){
  		$.ajax({
  			url : "boardDelete.do",
  			type : "get",
  			data : {"idx":idx},
  			success : loadList,
  			error : function(){ alert("error"); }
  		})
  	}
  	function goUpdateForm(idx){ // idx=11, 8, 7
  		$("#ta"+idx).attr("readonly",false);
  	
  		var title=$("#t"+idx).text();
  		var newInput="<input type='text' id='nt"+idx+"' class='form-control' value='"+title+"'/>";
  		$("#t"+idx).html(newInput);
  		
  		var newButton="<button class='btn btn-primary btn-sm' onclick='goUpdate("+idx+")'>수정</button>";
  		$("#ub"+idx).html(newButton);
  	}
  	function goUpdate(idx){
  		var title=$("#nt"+idx).val();
  		var content=$("#ta"+idx).val();
  		$.ajax({
  			url : "boardUpdate.do",
  			type : "post",
  			data : {"idx":idx,"title":title,"content":content},
  			success : loadList,
  			error : function(){ alert("error"); }
  		});
  	}
  </script>
</head>
<body>
 
<div class="container">
  <h2>Spring MVC02</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body" id="view">Panel Content</div>
    <div class="panel-body" id="wform" style="display:none">Panel Content
    <form id="frm">
      <table class="table">
         <tr>
           <td>제목</td>
           <td><input type="text" id="title" name="title" class="form-control"/></td>
         </tr>
         <tr>
           <td>내용</td>
           <td><textarea rows="7" class="form-control" id="content" name="content"></textarea> </td>
         </tr>
         <tr>
           <td>작성자</td>
           <td><input type="text" id="writer" name="writer" class="form-control"/></td>
         </tr>
         <tr>
           <td colspan="2" align="center">
               <button type="button" class="btn btn-success btn-sm" onclick="goInsert()">등록</button>
               <button type="reset" class="btn btn-warning btn-sm" id="fclear">취소</button>
               <button type="button" class="btn btn-info btn-sm" onclick="goList()">리스트</button>
           </td>
         </tr>
      </table>
     </form>
    </div>
    <div class="panel-footer">김성규</div>
  </div>
</div>

</body>
</html>