$(function(){
	let queryString=location.search;
    //proejctView페이지에서 데이터 받아서 보여줌
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
                alert('projectupdate.js 오류');
            }
	});
	/* $(document).on("click",".button.updateBoard",function(){

	});*/
	//수정완료 눌렀을때
	$("input[name='projectupdate']").click(function(){
		alert("updatetest"); //여기까지 성공
		/*var content = document.getElementById('p_content');
		content.value = jsonObj.project.p_content;*/
		
		let userNo = $("input[name='user_no']").val();
		let projectNo=$("input[name='p_no']").val();
        let projectTitle=$("input[name='p_title']").val();
        //let projectContent=$("input[name='p_content']").val();
        let projectContent="content 수정 test"
        let projectDeadlineday = $("input[name='deadlineday']").val();
		//let projectDeadlineday = "2022-07-25";
		
		//alert(userNo);
		//let pNo=$("input[name='p_no']").val(); //150
		//user_no=updatetest&p_title=updatetest&p_content=updatetest&deadlineDay=2022-07-15&update=수정완료
		let data = "user_no="+userNo+"&p_no"+projectNo+"&p_title="+projectTitle
		+"&p_content="+projectContent+"$p_deadlineday"+projectDeadlineday;
		let url ="http://localhost:8888/project1/html/projectUpdate.html?"+data;
		alert(url);
		
		$.ajax({
			url: url,
			method: 'get',
			data: data,
			success:function(){
				//alert(data);
				location.href="http://localhost:8888/project1/html/projectList.html";
   				return false;
			},

			error:function(){},

		});

    });
    	$("input[name='delete']").click(function(){
			alert("test");
			location.href="http://localhost:8888/project1/html/projectList.html";
   	 		//페이지 이동만되고 삭제는 아직 안됨
   	 	});
    });
