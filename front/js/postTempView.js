$(function(){

	//url에 있는 특정 
	let getPNo = HyeJs.fnGetUrlParam("pNo",location.href);

	//파라미터에 #이 붙어 있을 때 처리
	getPno = $.trim(getPNo.replace("#",""));

	console.log('getPNo');
	console.log(getPNo);
	
	//post방식으로 나의임시글 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{ pNo : getPNo }
		, "postTempSelectView"	//ajax 호출하는 URL
		, fnAjaxPostCallBack	
	);
	
	
	$('#btnUpt').click(function(){
		location.href = "postTempUpdate?pNo="+getPNo;
	});

	// 07.14 삭제추가
	$('#btnDel').click(function(){
		
		Swal.fire({
		   title: '정말로 삭제하시겠습니까?',
		   icon: 'warning',
		   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
		   confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
		   cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
		   confirmButtonText: '승인', // confirm 버튼 텍스트 지정
		   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
		   reverseButtons: true, // 버튼 순서 거꾸로
		}).then(result => {
		   // 만약 Promise리턴을 받으면,
		   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
			//post방식으로 나의임시글 삭제 ajax를 호출한다.
			HyeJs.fnAjaxPost(
				{ ptempNo : getPNo}
				, "postTempDelete"	//ajax 호출하는 URL
				, deleteCallback
			);
		   }
		});
		
	});

	//글올리기 버튼
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
	
	console.log('data');
	console.log(data);

	let _obj = data.response;
	
	HyeJs.fnElementValueSet(_obj);
	
}

/****************************************
* @author hye
* @desc 삭제 ajax가 성공 후 호출하는 콜백 함수
​*/    	
let deleteCallback = function(data){
	
	console.log('deleteCallback');
	console.log(data);
	
	if(data.response > 0){
	 	Swal.fire({
	    	icon: 'success', // Alert 타입 
	        title: '삭제성공', // Alert 제목 
	 	});
		location.href="myPagePostList";
	}else {
	 	Swal.fire({
	    	icon: 'warning', // Alert 타입 
	        title: '삭제실패', // Alert 제목 
	 	});
	}
	
}

/****************************************
* @author hye
* @desc 저장하기 ajax 콜백함수
​*/ 
let saveCallBack = function(data){
	
	console.log('saveCallBack');
	console.log(data);
	
	if(data.response > 0){
	 	Swal.fire({
	    	icon: 'success', // Alert 타입 
	        title: '저장완료', // Alert 제목 
	 	});

		location.href="myPagePostList";
	}else {
	 	Swal.fire({
	    	icon: 'warning', // Alert 타입 
	        title: '저장실패', // Alert 제목 
	 	});
	}
	
}
	
	

