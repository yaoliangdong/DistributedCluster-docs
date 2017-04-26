function toPage(url){
	document.getElementById("page").src = url;
}
function logout(url){
	location.href="logout.do?service="+url;
}