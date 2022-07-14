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
	
	//수정하기 버튼
	$('#btnUpt').click(function(){
		
		//form 태그의 모든 값을 json 형태로 만든다.
		let serializedValues = $('#frm').serializeObject()

		HyeJs.fnAjaxPost(
			serializedValues		//form 태그의 모든 값을 json 형태로 만든다.
			, "postTempUpdate"		//ajax 호출하는 URL
			, updateCallBack	
		);
	});

	//저장하기 버튼
	$('#btnSave').click(function(){

		//form 태그의 모든 값을 json 형태로 만든다.
		let serializedValues = $('#frm').serializeObject()
		
		HyeJs.fnAjaxPost(
			serializedValues	//form 태그의 모든 값을 json 형태로 만든다.
			, "postTempInsert"	//ajax 호출하는 URL
			, saveCallBack	
		);
	});
	
});

/****************************************
* @author hye
* @desc ajax가 성공 후 호출하는 콜백 함수
​*/    	
let fnAjaxPostCallBack = function(data){
	
	console.log(data);

	let _obj = data.response;
	
	HyeJs.fnElementValueSet(_obj);
	
}

/****************************************
* @author hye
* @desc 저장하기 ajax 콜백함수
​*/ 
let saveCallBack = function(data){
	
	console.log('saveCallBack');
	console.log(data);
	
	if(data.response > 0){
		alert("저장 완료");	
		location.href="myPagePostList";
	}else {
		alert("수정 실패");
	}
	
}

/****************************************
* @author hye
* @desc 수정하기 ajax 콜백함수
​*/ 
let updateCallBack = function(data){

	console.log('updateCallBack');
	console.log(data);
	
	if(data.response > 0){
		alert("수정 완료");		
	}else {
		alert("수정 실패");
	}
	
}


