// JavaScript Document
function toPage(url,event){
	$('.main-content').load(url);

    event = event || window.event;
	$("li").removeClass("active");
    $(event.parentElement).addClass("active");
}
