
$(function(){
	let queryString=location.search;
    //
	$.ajax({
		url: '/project1/projectView'+ queryString,
		method: 'get',
		success: function(jsonObj){
			var content = document.getElementById('p_content');
			content.value = jsonObj.project.p_content;
			$("input[name=p_no]").attr('value',jsonObj.project.p_no);
			$("input[name=user_no]").attr('value',jsonObj.project.user_no);
			$("input[name=p_title]").attr('value',jsonObj.project.p_title);
			$("input[name=p_view]").attr('value',jsonObj.project.p_view);
			$("input[name=deadlineDay]").attr('value',jsonObj.project.p_deadlineday);
		
		},
		error:function(jqXHR){
                alert('오류:'+jqXHR.status);
            }
	});
	//수정하기 눌렀을때
	$("input[name='projectupdateview']").click(function(){
		alert("test");
		let pNo=$("input[name='p_no']").val(); //150
		let url ="/project1/projectView?p_no="+pNo;
		alert(pNo);
		$.ajax({
			url: url,
			method: 'get',
			//data : pNo,
			success:function(){
				//alert(data);
				location.href="http://localhost:8888/project1/html/projectUpdate.html?p_no="+pNo;
   				return false;
			},

			error:function(jqXHR){
                alert('오류:'+jqXHR.status);
                alert('projectview 오류');
            },

		});

    });
    //삭제하기 눌렀을때
  /*  $("input[name='projectdelete']").click(function(){
		let url=
})*/
	
});