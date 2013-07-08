


var URL = "plot.xml";
var dom = new ActiveXObject("Microsoft.XMLDOM");
dom.async = true;

dom.load(URL);
dom.onreadystatechange = new function LoadedSales(){
	
	var txt = "";
	if(dom.readyState == 4){
		if(dom.parseError.errorCode!=0){
			txt="err";
		}
	}else {
		var point = dom.documentElement.selectNodes("point");
		if(point!=null && point.length>0){
			for(var i = 0; i < point.length; i ++){
				txt+="x="+point[i].getAttribute("x");
			}
		}
	}
	
	alert("fdsf");
	
	document.write(txt);
	
}