$(document).ready(function($) {
	var selectedDates;
	var selectedDateMap;
	var oldStartDate;
	var oldEndDate;
	var month;
	var year;

	var d = new Date();
	setMonth(d.getMonth() + 1);
	setYear(d.getFullYear());

	var cal = getCurrentCalendar();

	drawDatePicker(cal.month, cal.year);



});

function setSelectedDates(selectedDates) {
	this.selectedDates = selectedDates;
}

function getSelectedDates() {
	return this.selectedDates;
}

function setSelectedDateMap(selectedDateMap) {
	this.selectedDateMap = selectedDateMap;
}

function getSelectedDateMap() {
	return this.selectedDateMap;
}

function getMonth() {
	return this.month;
}

function getYear() {
	return this.year;
}

function setMonth(month) {
	this.month = month;
}

function setYear(year) {
	this.year = year;
}

function getCurrentCalendar() {
	var d = new Date();
	return {
		month : d.getMonth() + 1,
		year : d.getFullYear()
	};
}

function drawDatePicker(month, year) {
	console.log("inside draw - " + month + " - year - " + year);

	$.when(fetchDates(month, year)).done(function(data, status, jqHR) {
		/* var startDateArray = data.startDate;
		var endDateArray = data.endDate;
		dates = data; */

		setSelectedDates(data.selectedDates);
		setSelectedDateMap(data.selectedDateMap);
		console.log('month - ' + month + " - year - " + year);
		console.log(selectedDates);
		//$( "#datepicker-5" ).datepicker( "option", "minDate", selected )
		//$("#datepicker-5").datepicker('destroy');

		$("#datepicker-5").datepicker({
			//minDate : 0,
			dateFormat : 'yy-mm-dd',
			beforeShowDay : function(date) {

				var formattedDate = $.datepicker.formatDate("yy-mm-dd", date);

				var currentFormattedDate = $.datepicker.formatDate("yy-mm-dd", new Date());

				var selectedDateWindow = getSelectedDateMap()[formattedDate];

				//if (($.inArray(formattedDate, startDateArray) || $.inArray(formattedDate, endDateArray)) > -1) {
				if ($.inArray(formattedDate, getSelectedDates()) > -1) {

					return [
						true, 'css-class-to-highlight', selectedDateWindow.des
					];
				} else {
					// default
					return [
						true, '', ''
					];
				}
			},

			onSelect : function(selected, dateText) {

				var currentFormattedDate = $.datepicker.formatDate("yy-mm-dd", new Date());

				var cal = getCurrentCalendar();

				var selectedDateWindow = getSelectedDateMap()[selected];

				if (selected < currentFormattedDate) {
					return;
				}

				/*var date = $(this).datepicker('getDate');
				var month = date.getMonth() + 1;
				console.log(month);
				var year = date.getFullYear();
				console.log(year);*/
				if (selectedDateWindow) {
					oldStartDate = selectedDateWindow.sd;
					oldEndDate = selectedDateWindow.ed;
					console.log(new Date(selectedDateWindow.sd));
					$("#sd").val(selectedDateWindow.sd);
					$("#ed").val(selectedDateWindow.ed);
					$('#name').val(selectedDateWindow.name);
					$('#des').val(selectedDateWindow.des);
					$("#btn-save").val('Update');
					$("#ed").datepicker({
						dateFormat : "yy-mm-dd",
						"minDate" : new Date(selectedDateWindow.sd)
					});
				} else {
					$("#sd").val(selected);
					$("#ed").val('');
					$('#name').val('');
					$('#des').val('');

					$("#ed").datepicker({
						dateFormat : "yy-mm-dd",
						"minDate" : new Date(dateText.currentYear, dateText.currentMonth, dateText.currentDay)
					});
					//$("#ed").datepicker("option", "dateFormat", "yy-mm-dd");
					/*var sd = $('#sd').val();
					$('#name').val('');
					$('#des').val('');*/
					$("#btn-save").val('Save');
				}

				$(function() {

					$("#divDialogNoEsc").dialog({
						maxWidth : 500,
						maxHeight : 400,
						width : 500,
						height : 400,
					});

				});

			},
			onChangeMonthYear : function(year, month, inst) {
				setMonth(month);
				setYear(year);
				drawDatePicker(month, year);
			}
		});

		$("#datepicker-5").datepicker('refresh');

		$('#dg').datagrid({
			data : data.listCbean,
			columns : [
				[
					{
						field : 'check',
						checkbox : true
					}, {
						field : 'name',
						title : 'Name',
						width : 100
					}, {
						field : 'sd',
						title : 'Start Date',
						width : 100
					}, {
						field : 'ed',
						title : 'End Date',
						width : 100
					}, {
						field : 'des',
						title : 'Description',
						width : 100
					}
				]
			]
		});

	});
}

function fetchDates(month, year) {
	return $.ajax({
		type : "POST",
		url : "http://localhost:8080/holidayinfomsystem/om",
		contentType : "application/json",
		data : JSON.stringify({
			"month" : month,
			"year" : year
		}),
		error : function(data) {
			console.log(data);
		}
	});
}

function deleteLeaves() {
	var table = $('#dg');
	var selRecords = table.datagrid('getSelections');

	return $.ajax({
		type : "POST",
		contentType : "application/json",
		url : "http://localhost:8080/holidayinfomsystem/deleteRecords",
		data : JSON.stringify(selRecords)
	});
}

function save() {
	if (this.oldStartDate != null) {
		if(!confirm("Do you want to override the dates?")) {
			return false;
		}
		/*$("#dialog-confirm").html("Do you want to override the dates?");

		// Define the Dialog and its properties.
		$("#dialog-confirm").dialog({
			resizable : false,
			modal : true,
			title : "Confirmation",
			height : 150,
			width : 200,
			buttons : [ {
				text : "Yes",
				click : function() {
					$(this).dialog('close');
					console.log('save it');
				}
			}, {
				text : "No",
				click : function() {
					$(this).dialog('close');
					console.log('Dont save');
					return;
				}
			} ]
		});*/
	}

	var name = $('#name').val();
	var sd = $('#sd').val();
	var ed = $('#ed').val();
	var des = $('#des').val();

	return $.ajax({
		type : "POST",
		contentType : "application/json",
		url : "http://localhost:8080/holidayinfomsystem/store",
		data : JSON.stringify({
			"name" : name,
			"sd" : sd,
			"ed" : ed,
			"des" : des,
			"oldStartDate" : this.oldStartDate,
			"oldEndDate" : this.oldEndDate
		})
	});
}

jQuery(document).ready(function($) {

	$("#btn-save").click(function(event) {

		var firstname = $('#name').val();
		var enddate = $('#ed').val();
		var descrip = $('#des').val();
		var name_regex = /^[a-zA-Z]+$/;

		if (firstname.length == 0) {
			alert("* All fields are mandatory *");
			$("#name").focus();
			return false;
		}
		// Validating Name Field.
		else if (!firstname.match(name_regex) || firstname.length == 0) {
			alert("* For your name please use alphabets only *");
			$("#name").focus();
			return false;
		} else if (enddate.length == 0) {
			alert("enter valid endDate");
			return false;
		} else if (descrip.length == 0) {
			alert("enter holiday description");
			return false;
		}

		$.when(save()).done(function(data, status, jqxhr) {
			if(data) {
				alert("Data saved successfully!!");
				$("#divDialogNoEsc").dialog('close');
				$("#ed").datepicker('destroy');
				drawDatePicker(getMonth(), getYear());
			}
		});

	});

	$("#del-leave").click(function(event) {

		$.when(deleteLeaves()).done(function(data, status, jqxhr) {
			console.log('inside done function');
			var table = $('#dg');
			var selRecords = table.datagrid('getSelections');

			$(selRecords).each(function(index) {
				table.datagrid('deleteRow', table.datagrid('getRowIndex', selRecords[index]))
			});
			drawDatePicker(getMonth(), getYear());
		});

	});
});

function customConfirm(customMessage) {
	var d = new $.Deferred();
	$("#popUp").html(customMessage);
	$("#popUp").dialog({
		resizable : false,
		height : 300,
		modal : true,
		buttons : {
			"Yes" : function() {
				$(this).dialog("close");
				d.resolve()
			},
			"No" : function() {
				$(this).dialog("close");
				d.reject();
			}
		}
	});
	return d.promise();
}