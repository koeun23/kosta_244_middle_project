$(function(){
	$(".loginBtn").click(function(){
		//아이디 입력칸 비밀번호 입력칸 찾기
		let $id=$(".id");
		let $pwd=$(".pwd");
		//입력한 아이디 값이랑 비밀번호 값을 찾기
		let inputIdValue=$id.val();
		let inputPwdValue=$pwd.val();

		//서버로 보내기 
		let url="";
		let data="id="+inputIdValue+"&pwd"+inputPwdValue;
		$.ajax({
			url: url,
			method:'post',
			data: data,
			success:function(jsonObj){
				if(jsonObj==1){
					alert("로그인 성공입니다");
					location.href="./mainpage.html";
				}else{
					alert('로그인 실패');
				}
			},
			error:function(jqXHR){
				alert(jqXHR.status);
			},
		});
	});	
});