<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="resources/theme1/js/jquery.min.js"></script>
<script src="resources/theme1/js/bootstrap.min.js"></script>
<script src="resources/theme1/js/jquery.min.js"></script>
<script src="resources/theme1/js/jquery-3.1.1.js"></script>
<script src="resources/theme1/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="resources/theme1/js/jquery.easyui.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/jquery-ui.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/easyui.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/icon.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="resources/theme1/css/holiday.css">
<!-- Javascript -->
<script type="text/javascript" src="resources/theme1/js/holiday.js"></script>
</head>

<body>


	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<h2 class="ht">
			<center>Holiday Information System</center>
		</h2>
	</div>



	<div class="navbar navbar-inverse navbar-fixed-left">
		<u class="u"><p>
				<left class="l">Holiday Information System</left>
			</p></u>
	</div>
	<!-- Fixed navbar -->

	<!-- Begin page content -->
	<div class="container"></div>

	<div id="footer">
		<h5 class="hf">
			<center>holiday information system</center>
		</h5>
		<div class="container"></div>
	</div>
	<div id="datepicker-container">
		<div id="datepicker-center">
			<div id="datepicker-5"></div>
		</div>
	</div>
	<div class="tview">
		<table id="dg"></table>
	</div>
	<br>
	<div style="width: 100%" align="center">
		<input type="button" value="Delete leave(s)" id="del-leave" />
	</div>
	<div id="divDialogNoEsc" title="Holiday Reservation"
		style="display: none;">

		<table>
			<tr class="o">
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
	<div id="dialog-confirm"></div>
</body>
</html>

