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
						onSelect : function(dateText, inst) {
							var date1 = $.datepicker.parseDate(
									$.datepicker._defaults.dateFormat, $("#sd")
											.val());
							var date2 = $.datepicker.parseDate(
									$.datepicker._defaults.dateFormat, $("#ed")
											.val());
							if (!date1 || date2) {
								$("#sd").val(dateText);
								$("#ed").val("");
								$(this).datepicker("option", "minDate",
										dateText);
							} else {
								$("#ed").val(dateText);
								$(this).datepicker("option", "minDate", null);
							}
						}
					});
});
