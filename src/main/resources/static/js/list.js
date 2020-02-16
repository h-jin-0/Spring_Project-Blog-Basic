/**
 * 
 */
$(".pagination a").on("click", function(event) {
	var jobForm = $("#jobForm");
	event.preventDefault();

	var targetPage = $(this).attr("href");

	jobForm.find("[name='page']").val(targetPage);
	jobForm.attr("action", "/post").attr("method", "get");
	jobForm.submit();
});