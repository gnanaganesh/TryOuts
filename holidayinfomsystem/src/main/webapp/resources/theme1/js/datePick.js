$(function() {
	$("#datepicker-13")
			.datepicker(

					{
						beforeShowDay : function(date) {
							var date1 = $.datepicker.parseDate(
									$.datepicker._defaults.dateFormat, $("#sd")
											.val());
							var date2 = $.datepicker.parseDate(
									$.datepicker._defaults.dateFormat, $("#ed")
											.val());
							return [
									true,
									date1
											&& ((date.getTime() == date1
													.getTime()) || (date2
													&& date >= date1 && date <= date2)) ? "dp-highlight"
											: "" ];

						},

						onSelect : function(dateText, inst, selectedDate) {
							
							$("#sd").val(dateText);
							$(function() {
							
								$("#divDialogNoEsc").dialog({

									buttons : {
										'Close' : function() {

											$(this).dialog('close');
										},

									}
								});

							});

						}

					});

});

$(document).ready(function() {
	$("#sd").datepicker({

		numberOfMonths : 1,
		onSelect : function(selected) {
		
			$("#ed").datepicker("option", "minDate", selected)
		}

	});

	$("#ed").datepicker({
		numberOfMonths : 1,
		onSelect : function(selected) {
			$("#sd").datepicker("option", "maxDate", selected)
		}
	});
});
