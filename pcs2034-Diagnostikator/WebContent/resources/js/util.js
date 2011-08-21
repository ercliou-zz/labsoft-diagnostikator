//nao tirar comentario que ta embaixo, for backward compatibility
//<![CDATA[
           
function loadToContent(which) {
	var w = window.innerWidth - 200;
	var h = window.innerHeight - 180;
	document.getElementById('content').innerHTML = '<object width="'+w+'" height="'+h+'" id="contentContainer" type="text/html" data="'+which.href+'"><\/object>';
}


function initializeSizes(){
	var h = window.innerHeight - 150;
	$("#sidebar").css("height",h);
	$("#middle").css("height",h);
	$("#content").css("height",h);
	
}

function loadDatePickers(){
	
	
}
//]]>