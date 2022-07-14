$(function(){

	//url에 있는 특정 
	let getPNo = HyeJs.fnGetUrlParam("pNo",location.href);
	console.log('getPNo');
	console.log(getPNo);
	
	//post방식으로 임시목록 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{ pNo : getPNo }
		, "myPagePostSelectView"	//ajax 호출하는 URL
		, fnAjaxPostCallBack	
	);
	
});

/****************************************
* @author hye
* @desc ajax가 성공 후 호출하는 콜백 함수
​*/    	
let fnAjaxPostCallBack = function(data){
	
	console.log('data');
	console.log(data);

	let _obj = data.response;

	HyeJs.fnElementValueSet(_obj);
	
};
