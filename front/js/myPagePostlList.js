


//on click 과 click의차이, on은 동적생성된 태에 이벤트가 바인딩된다.
//그냥click은 미리 생성된 태그에만 이벤트가 바인딩된다.
//$("#selector").on("click", "li", function(event){})
//$("#selector").click(function(){});
$(function(){

	$("#setPostTb").on('click', 'tbody tr', function () {
		var row = $("#setPostTb").DataTable().row($(this)).data();
		// 내가 쓴 글 선택했는지 플래그 값 체크
		if (row != null && row != "") {
			rowData = row;
			console.log(rowData.pNo);
			let pNo = rowData.pNo;
			location.href="myPostView?type=P&pNo="+pNo;
		} else {
			alert("게시물을 선택해 주세요.");
		}
	});

	$("#setTempTb").on('click', 'tbody tr', function () {
		var row = $("#setTempTb").DataTable().row($(this)).data();
		// 내가 쓴 임시 글 선택했는지 플래그 값 체크
		if (row != null && row != "") {
			rowData = row;
			console.log(rowData.ptempNo);
			let pNo = rowData.ptempNo;
			
			location.href="myPostView?type=T&pNo="+pNo;
		} else {
			alert("게시물을 선택해 주세요.");
		}
	});

	//post방식으로 임시목록 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{}
		, "myPageTempSelectList"			//ajax 호출하는 URL
		, fnAjaxTempCallBack	
	);


	//post방식으로 내가작성한 ajax를 호출한다.
	HyeJs.fnAjaxPost(
		{}
		, "myPagePostSelectList"			//ajax 호출하는 URL
		, fnAjaxPostCallBack	
	);
	
});


/****************************************
* @author hye
* @desc ajax가 성공 후 호출하는 콜백 함수
​*/    	

let fnAjaxPostCallBack = function(data){
	
	//ajax에서 받은 json형태의 결과값
	let list = data.response;
	
	/* 데이터테이블 옵션 셋팅, json타입의 결과 목록을 넣는다. */
	$('#setPostTb').DataTable({
		"data": list,
		"dataSrc": "",
		"columns": [
			{ 'data': 'pNo', "className": "text-center" },
			{ 'data': 'pTitle', "className": "text-center" },
			{ 'data': 'userNo', "className": "text-center" },
			{ 'data': 'pCreateday', "className": "text-center" }
		],
		"bLengthChange": false, // thought this line could hide the LengthMenu
		"pageLength": 5,
		"language": {
			"emptyTable": "데이터가 없습니다.",
			"info": "총 _TOTAL_건",
			"search": "검색 : ",
			"zeroRecords": "일치하는 데이터가 없습니다.",
			"paginate": {
				"first": "처음",
				"last": "마지막",
				"next": "다음",
				"previous": "이전"
			},
		}
	});
	
};


/****************************************
* @author hye
* @desc ajax가 성공 후 호출하는 콜백 함수
​*/    	
let fnAjaxTempCallBack = function(data){
	
	//ajax에서 받은 json형태의 결과값
	let list = data.response;

	/* 데이터테이블 옵션 셋팅, json타입의 결과 목록을 넣는다. */	
	$('#setTempTb').DataTable({
		"data": list,
		"dataSrc": "",
		"columns": [
			{ 'data': 'ptempNo', "className": "text-center" },
			{ 'data': 'ptempTitle', "className": "text-center" },
			{ 'data': 'userNo', "className": "text-center" },
			{ 'data': 'ptempCreateday', "className": "text-center" }
		],
		"bLengthChange": false, // thought this line could hide the LengthMenu
		"pageLength": 5,
		"language": {
			"emptyTable": "데이터가 없습니다.",
			"info": "총 _TOTAL_건",
			"search": "검색 : ",
			"zeroRecords": "일치하는 데이터가 없습니다.",
			"paginate": {
				"first": "처음",
				"last": "마지막",
				"next": "다음",
				"previous": "이전"
			},
		}
	});
	
};
