<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="<c:url value="/resources/theme1/css/jquery-ui-1.10.4.custom.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/theme1/js/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/resources/theme1/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/theme1/js/datePick.js" />"></script>
<link
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/ui-darkness/jquery-ui.min.css"
	rel="stylesheet">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript">
	
</script>
<style>
.dp-highlight .ui-state-default {
	background: #484;
	color: #FFF;
}
</style>
<!-- <script type="text/javascript">
	/* function send() {
		var person = {
			name : $('#name').val(),
			sd : $('#sd').val(),
			ed : $('#ed').val(),
			des : $('#des').val()
		}
		$.ajax({
			type : 'post',
			//url : "http://localhost:8080/HolidayReservation/store",
			url : "http://localhost:8081/holidayinfomsystem/test",
			contentType : 'application/json; charset=utf-8',
			traditional : true,
			crossDomain : true,
			data : JSON.stringify(person),
			dataType : 'json',
			complete : 'callback',
			success : function(data) {
				console.log(data);
			},

			error : function(e) {
				console.log(e);
			}
		});
	} */
	function sendPass() {
		var data = {}
		data[name] = $('#name').val();
		data[sd] = $('#sd').val();
		data[ed] = $('#ed').val();
		data[des] = $('#des').val();

		$.ajax({
			type : 'post',
			contentType : 'application/json; charset=utf-8',
			//url : "http://localhost:8080/HolidayReservation/store",
			url : "/store",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout: 600000,
			success : function(data) {
				console.log(data);
			},

			error : function(e) {
				console.log(e);
			}
		
		});
	}
</script>
 -->
<script type="text/javascript">
	/*working jQuery(document).ready(function($) {

		$("#btn-save").click(function(event) {

			var data = {}
			data[name] = $('#name').val();
			data[sd] = $('#sd').val();
			data[ed] = $('#ed').val();
			data[des] = $('#des').val();

			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "http://localhost:8081/holidayinfomsystem/store",
				data : JSON.stringify(data),
				dataType : 'json',
				timeout : 600000,
				success : function(data) {

					console.log(data);
				},
				error : function(e) {

					console.log(e);
				}
			});

		});

	}); */
	jQuery(document).ready(function($) {

		$("#btn-save").click(function(event) {

			var name = $('#name').val();
			var sd = $('#sd').val();
			var ed = $('#ed').val();
			var des = $('#des').val();
			//var date = $('#datepicker').datepicker({ dateFormat: 'dd-mm-yy' }).val();
			$.ajax({
				type : "POST",
				url : "http://localhost:8081/holidayinfomsystem/store",
				data : {
					"name" : name,
					"sd" : sd,
					"ed" : ed,
					"des" : des
				}

			});
		});
	});
</script>
</head>
<body>
	<%-- <form method="POST">
		<p>
			<input type="text" id="datepicker-13" />
		</p>
		<div id="divDialogNoEsc" title="Holiday Reservation"
			style="display: none;">

			<table>
				<tr>
					<td>Holiday Name:</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><input type="text" name="sd" id="sd" /></td>
				</tr>
				<tr>
					<td>End Date:</td>
					<td><input type="text" id="ed" name="ed" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea rows="4" cols="50" name="des" id="des"></textarea></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save" onclick="send();" /></td>
				</tr>
			</table>

		</div>
	</form> --%>

	<form:form method="post" modelAttribute="done">
		<p>
			<input type="text" id="datepicker-13" />
		</p>
	</form:form>
	<%-- <div id="divDialogNoEsc" title="Holiday Reservation"
		style="display: none;">

		<table>
			<tr>
				<td>Holiday Name:</td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>Start Date:</td>
				<td><form:input path="sd" name="sd" id="sd" /></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><form:input path="ed" id="ed" name="ed" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="4" cols="50" name="des" id="des"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" id="btn-save" /></td>
			</tr>
		</table>


	</div>
 --%>
	<div id="divDialogNoEsc" title="Holiday Reservation"
		style="display: none;">

		<table>
			<tr>
				<td>Holiday Name:</td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>Start Date:</td>
				<td><input type="text" name="sd" id="sd" /></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="text" id="ed" name="ed" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea rows="4" cols="50" name="des" id="des"></textarea></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save" id="btn-save" /></td>
			</tr>
		</table>

	</div>
</body>
</html>