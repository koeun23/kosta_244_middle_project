$(function(){
    //글쓰기 버튼 눌렀을 때
    //projectWrite.html <a href=""~

    //user가 입력한 data를 sql구문에 추가, 그후에 sql구문에 있는 
    //data를 받아서 각각 카테고리에 뿌려주기

    //리스트 글중에 하나의 리스트에 있는 제목을 클릭했을 때
    //모집글번호를 서버로 보내줄꺼고
    //서버에서는 모집글번호를 받고 DB에서 보내진 모집글번호인 게시글 찾고
    //서버에서 해당하는 글의 정보를 projectView.html 보내는 것 
    //boardtitle이 클릭되었을 시에 발생할 이벤트들
    $("div.boardtitle").click(function(){
        let $board=$this.parent();
        let $boardNo=$board.firstChild();

        //모집글번호를 찾고
        let boardNo=$boardNo.val();
        //서버로 모집글번호를 전송
        let url="back/projectlist";
        let data="boardNo="+boardNo;
        //ajax는 servlet과 연결을 하는것에 필요한 파트임
        $.ajax({
            url:url,
            method: 'post',
            data: data,
            success:function(){
                //html 문자열로 받아서 뿌리기
            },
            error:function(jqXHE){
                alert(jqXHR.error);
            }
        });
    });

});