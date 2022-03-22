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
    	<script src="../js/markJS/mark.min.js"></script>
    	<script type="text/javascript">
			$(function(){
				$('#search_icon').click(function(){
					searchAjax();
				});
				// Enter event
				$('#search_input').keydown(function(evt){
				    if( evt.keyCode == 13 ) searchAjax();
				});
			});
			
			$(function() {

			  var mark = function() {

			    // Read the keyword
			    var keyword = $("input[name='keyword']").val();

			    // Determine selected options
			    var options = {};
			    $("input[name='opt[]']").each(function() {
			      options[$(this).val()] = $(this).is(":checked");
			    });

			    // Remove previous marked elements and mark
			    // the new keyword inside the context
			    $(".context").unmark({
			      done: function() {
			        $(".context").mark(keyword, options);
			      }
			    });
			  };

			  $("input[name='keyword']").on("input", mark);
			  $("input[type='checkbox']").on("change", mark);

			});
			
			let hasResult = false;
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
								if(response.length==0){
									alert('Not Exist Data');
// 									console.dir($("#search_input"));
// 									console.dir(document.getElementById('search_input'));

// 									document.getElementById('search_input').value = '';
									$("#search_input")[0].value="";
								}
								var result;
								if(hasResult){
									result="";
									console.dir($("#resultTable"));
									$("#resultTable").empty();
									$("#resultTable").append("<tr><td class=\"td_chapter\">Chapter</td><td>Contents</td></tr>");
								}
								var resLength = response.length;
								for(var i=0;i<resLength;i++){
									var data = response.pop();
// 									console.log(data.book_kor);
// 									console.log(data.chapter);
// 									console.log(data.verse);
// 									console.log(data.contents);
// 									console.log('----------------');
									result += "<tr><td class=\"td_chapter\">"+data.book_kor+" "+ data.chapter+"장"+data.verse+"절"+"</td><td>"+data.contents+"</td></tr>";
									hasResult = true;
								}
								$("#resultTable").append(result);

							}else{
								alert('FAIL');
							}
						}
					});
			}
			
			var StringBuffer = function() { this.buffer = new Array(); }; 
			StringBuffer.prototype.append = function(str) { this.buffer[this.buffer.length] = str; }; 
			StringBuffer.prototype.toString = function() { return this.buffer.join(""); };
			
			//TODO search highlight search_input in Contents 
			let highlightSearchInput = function(search_input, contents){
// 				let str = 'abcabcabc';
// 				let searchvalue = 'ab';
				let result = new StringBuffer();
				let ini_pos=0;
				let pos = 0;
				let searchInputLength = search_input.length;
				while (true) {
					let foundPos = contents.indexOf(search_input, pos);
					if (foundPos == -1) break;
					console.log( foundPos );
					result.append(contents.substring(ini_pos,foundPos)); //FIXME
					ini_pos = foundPos;
					pos = foundPos + 1;
				}
				
				return result.toString();
			}
		</script>
	</head>
	
	<body>
		<div class="container h-100">
	      <div class="d-flex justify-content-center h-100">
	        <div class="searchbar">
	          <input class="search_input" id="search_input" type="text" name="" placeholder="Search...">
	          <a class="search_icon" id="search_icon"><i class="fas fa-search"></i></a>
	        </div>
	      </div>
	      	<div class="search_result">
	      		<table id="resultTable">
	      			<tr>
	      				<td class="td_chapter">Chapter</td>
	      				<td>Contents</td>
	      			</tr>
	      			
	      		</table>
<!--         		<p>test</p> -->
        	</div>
    	</div>
    	
	</body>
</html>