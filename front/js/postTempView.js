$(function(){


	//url에 있는 특정 
	let getPNo = HyeJs.fnGetUrlParam("pNo",location.href);
	console.log('getPNo');
	console.log(getPNo);
	
	//post방식으로 나의임시글 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{ pNo : getPNo }
		, "postTempSelectView"	//ajax 호출하는 URL
		, fnAjaxPostCallBack	
	);
	HyeJs.deletecallback(
		
	);
	
	
	$('#btnUpt').click(function(){
		location.href = "postTempUpdate?pNo="+getPNo;
		
			// 07.14 삭제추가
	$('#btnDel').click(function(){
		//post방식으로 나의임시글 삭제 ajax를 호출한다.
		HyeJs.fnAjaxPost(
			{ ptempNo : getPNo }
			, "postTempDelete"	//ajax 호출하는 URL
			, deleteCallback
			);
		});
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
	
	
/****************************************
* @author hye
* @desc 삭제 ajax가 성공 후 호출하는 콜백 함수
​*/    	
let deleteCallback = function(data){
	
	console.log('deleteCallback');
	console.log(data);
	
	if(data.response > 0){
		alert("삭제 완료");	
		location.href="myPagePostList";
	}else {
		alert("삭제 실패");
	}
};


	
