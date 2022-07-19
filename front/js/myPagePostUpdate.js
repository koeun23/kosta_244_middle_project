$(function(){

	//url에 있는 특정 
	let getPNo = HyeJs.fnGetUrlParam("pNo",location.href);
	console.log('getPNo');
	console.log(getPNo);
	
	//post방식으로 나의임시글 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{ pNo : getPNo }
		, "myPagePostSelectView"	//ajax 호출하는 URL
		, fnAjaxPostCallBack	
	);
	
	//수정하기 버튼
	$('#btnUpt').click(function(){
		
		//form 태그의 모든 값을 json 형태로 만든다.
		let serializedValues = $('#frm').serializeObject()

		HyeJs.fnAjaxPost(
			serializedValues			//form 태그의 모든 값을 json 형태로 만든다.
			, "myPagePostUpdate"		//ajax 호출하는 URL
			, updateCallBack	
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
* @desc 수정하기 ajax 콜백함수
​*/ 
let updateCallBack = function(data){

	console.log('updateCallBack');
	console.log(data);
	
	if(data.response > 0){
	 	Swal.fire({
	    	icon: 'success', // Alert 타입 
	        title: '수정완료', // Alert 제목 
	 	});	
	}else {
	 	Swal.fire({
	    	icon: 'warning', // Alert 타입 
	        title: '수정실패', // Alert 제목 
	 	});
	}
	
}

