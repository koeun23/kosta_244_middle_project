$(function(){
	//아이디 찾기 버튼을 눌렀을 때 발생할 이벤트
	$('button.idFindBtn').click(function(){
		let url='';//회원정보가 있는 back의 주소로
		
  		//--이름과 이메일 입력 객체를 찾아서
  		let $inputName = $("div.findId input[name=name]");
  		let $inputEmail = $("div.findId input[name=email]");
 		//--이름과 이메일의 입력값을 받고 data에 집어넣는다
   		let inputNameValue = $inputName.val(); //사용자가 입력해준 이름 값
    	let inputEmailValue = $inputEmail.val(); //사용자가 입력해준 이메일 값
    	let data = 'name=' + inputNameValue + '&email='+ inputEmailValue;
    	
    	//--back에 있는 주소로 이름과 이메일을 보내준 후 back애서 2가지 응답을 줘야 할 것으로 예상
    	//-- 1. 회원정보에서 입력한 이름과 이메일을 가진 회원정보가 없을 땐 회원정보를 찾을 수 없습니다 라고 출력 ex)status: 1이 아닌 나머지 값으로
    	//-- 2. 회원정보에서 입려한 이름과 이메일과 회원정보의 데이터 중 일치하는 것이 있는 경우애는 id값을 alert로 보여줌 ex)status:1로
		$.ajax({
			url: url,
			method:'post',
			data: data,
			success: function(jsonObj){
				if(jsonObj.status==1){
					//회원정보 데이터 중 일치하는 것이 있다!
					alert();//회원정보에 있는 id값을 알람으로 보여주자
				}
				else{
					//입력한 이메일과 이름으로 회원정보에 있는 데이터랑 일치하는 것이 없어요
					//그런 회원은 없다고 알려주자
					alert("입력한 회원정보와 일차한 아이디는 존재하지 않습니다");
				}
				
			},
			error: function(jqXHR){
				alert(jqXHR.status);
			}, 
		});
	});
	
	//비밀번호 찾기 버튼을 눌렀을 때 발생할 이벤트 
	$('button.pwdFIndBtn').click(function(){
		let url='http://';//회원정보가 있는 back의 주소로
		
  		//--이름과 아이디 이메일 입력 객체를 찾아서
  		let $inputName = $("div.findPwd input[name=name]");
  		let $inputId = $("div.findPwd input[name=id]");
  		let $inputEmail = $("div.findIPwd input[name=email]");
  		
 		//--ajax로 보낼 data에 이름 아이디 이메일 값을 넣어주자
   		let inputNameValue = $inputName.val(); //사용자가 입력해준 이름 값
   		let inputIdValue = $inputId.val();
    	let inputEmailValue = $inputEmail.val(); //사용자가 입력해준 이메일 값
    	let data = 'name=' + inputNameValue +'&id='+ inputIdValue +'&email='+ inputEmailValue;
    	//-- 이것도 앞에의 ajax요청 처럼 전송 성공시 2개의 반응을 줄것을 예상
    	//-- 1. 회원정보에서 입력한 이름과 이메일 아이디를 가진 회원정보가 없을 땐 회원정보를 찾을 수 없습니다 라고 출력 ex)status: 1이 아닌 나머지 값으로
    	//-- 2. 회원정보에서 입력한 이름과 이메일과 아이디회원정보의 데이터 중 일치하는 것이 있는 경우애는
    	//--    일치한 회원정보로 로그인 상태로 만들어주고 비밀번호 변경 페이지로 이동
    	$.ajax({
			url: url,
			method: 'post',
			data:data,
			success:function(jsonObj){
				if(jsonObj.status==1){
					//해당 회원정보로 로그인 상태로 만들어주고 
					location.href = "./myInfoRevise.html";//비밀번호 변경페이지로 이동
				}else{
					alert("해당 정보와 일치하는 회원정보는 없습니다.");
				}
			},
			error:function(jqXHR){
				alert(jqXHR.status);
			}
			
		});
	});
});