<%@ page pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
	<title>Index</title>
</head>
<body>
	<h1>index.jsp</h1>	
	<input type="button" id="btnTxt" value="TXT"/> 
	<input type="button" id="btnJSON" value="JSON"/>

	<p><br>

	<form name="form1" id="form1" style="margin:0px;">
		<div>
		    <label for="fname">이름</label>
		        :
		    <input type="text" name="fname" id="fname" value="" />
		</div>
		 <div>
		    <label for="femail">이메일</label>
		    :
		    <input type="text" name="femail" id="femail" value="" />
		</div>
		<div>
		    <label for="sex">성별</label>
		    :
		    <input type="radio" name="sex" value="0" checked="checked" />여자
		    <input type="radio" name="sex" value="1" />남자
		 </div>
		<div>
		    <label for="job">직업</label>
		    :
		    <select name="job" id="job">
		    <option value="직업1">직업1</option>
		    <option value="직업2">직업2</option>
		    <option value="직업3">직업3</option>
		    </select>
		 </div>
		<div>
		    <input type="button" id="btnForm" value="HTML" />
		 </div>
	</form>

</body>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function(){		 
		
		$("#btnForm").click(function(){
			
			var paramForm = $("#form1").serialize(); 
			
			$.ajax({
				  url			: "/mybatis/home"
				, method		: "POST"
				, type 			: "html" 
 				, contentType 	: "application/x-www-form-urlencoded; charset=UTF-8"
				, data			: paramForm
				, success 		: function(data) {}
				, error			: function(request, status, error) {
					alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
				}
			});	
			
		});			
		
		$("#btnTxt").click(function(){
			
			var paramText = "fname=1&femail=2&sex=3&job=4";
			
			$.ajax({
				  url			: "/mybatis/home"
				, method		: "POST"
				, type 			: "text" 
 				, contentType 	: "application/x-www-form-urlencoded; charset=UTF-8"
				, data			: paramText
				, success 		: function(data) {}
				, error			: function(request, status, error) {
					alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
				}
			});
			
		});	
		
		$("#btnJSON").click(function(){
			
			var paramJson = { "gogaekNo" : "TC00014401" };
			
			$.ajax({
				  url			: "/mybatis/home1"
				, method		: "POST"
				, type 			: "json" 
 				, contentType 	: "application/json;charset=UTF-8"
				, data			: JSON.stringify(paramJson)
				, success 		: function(response) {
					if(response.error != null) {
						alert(response.error);
					} else {
						alert("success");
					}
				}
				, error			: function(request, status, error) {
					alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
				}
			});
			
		});		
	});		
</script>

</html>
