$(function(){
	var url_path = window.location.pathname;
	var url_pats = url_path.split("/");
	var module = url_pats[1];
	$("#top_" + module).addClass("active");
});