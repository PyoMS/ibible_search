<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/com/header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Search Bible Contents</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    	<link href="../css/Search.css" rel="stylesheet">
    	<script type="text/javascript">
			$(function(){
				$('#search_icon').click(function(){
					alert('success - ' + $('#search_input').val());
					searchAjax();
				});
				// Enter event
				$('#search_input').keydown(function(evt){
				    if( evt.keyCode == 13 ) searchAjax();
				});
			});
			
			let searchAjax = function(){
					var params = $('#search_input').val();
					$.ajax({
						type: 'GET'
					    ,url: "../getContents/"+params
					    ,param: params
						,contentType: 'application/json; charset=utf-8'
						,dataType: 'json'
						,success : function(response){
							if(response){
								var resLength = response.length;
								for(var i=0;i<resLength;i++){
									var data = response.pop();
									console.log(data.book_kor);
									console.log(data.chapter);
									console.log(data.verse);
									console.log(data.contents);
									console.log('----------------');
								}
							}else{
								alert('FAIL');
							}
						}
					});
			}
			//TODO add Enter event 
		</script>
	</head>
	
	<body>
		<div class="container h-100">
	      <div class="d-flex justify-content-center h-100">
	        <div class="searchbar">
	          <input class="search_input" id="search_input" type="text" name="" placeholder="Search...">
	          <a class="search_icon" id="search_icon"><i class="fas fa-search"></i></a>
	        </div>
	        <div id="search_result">
	        	<table class="d-flex justify-content-center h-100">
					<tr>
					  <th>Chapter</th>
					  <th>Contents</th>
					</tr>
				</table>
	        </div>
	      </div>
    	</div>
	</body>
</html>