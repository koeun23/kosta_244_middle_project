$(function(){
    $("button.pwdChangeBtn").click(function(){
        //pwd와 pwdChk의 객체를 찾아 주자 (비밀번호와 비밀번호 확인)
        let $pwd=$("input[name=pwd]");
        let $pwdChk=$('input[name=pwdChk]');
        //pwd와 pwdChk 값을 가져오고 일단 두개가 같은지 비교하자 (비밀번호와 비밀번호 확인이 일치하는지) 
        let inputPwdValue=$pwd.val();
        let inputPwdChkValue=$pwdChk.val();
       
        //일치하지 않는다면 다시 입력하라고 alert 발생 
        if(inputPwdValue!=inputPwdChkValue){
            alert("비밀번호와 비밀번호 확인 값이 다릅니다 다시 입력해주세요");
        }

        //일치하면 변경할 pwd를 전달해주자
        let data="pwd="+inputPwdValue;
        let url="";
        $.ajax({
            url:url,
            method: 'post',
            data: data,
            success:function(jsonObj){
                //pwd와 pwdChk 전송이 정상적으로 전달되면 서버에서 해당 회원정보에서 pwd값을 보내준 pwd 값으로 변경해주자 
                //그리고 password 변경이 정상적으로 완료되었으면 status 1?.. 
                if(jsonObj.status==1){
                    alert("비밀번호가 성공적으로 변경되었습니다");
                }
            },
            error:function(jqXHR){
                alert(jqXHR.error);
            }
        });
    });

});