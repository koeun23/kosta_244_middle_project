$(function(){
    //자유게시판 상세페이지에서 수정하기 버튼이 클릭되었을 때
    //참고로 공지사항 수정하기 버튼은 글쓴이만 수정가능하기 때문에
    //글쓴이만 수정가능 하다.
    $("button.reviseNotice").click(function(){
        //공지사항 모든정보(글번호 제목 내용 등...)를 포함하는 부모 객체를 찾자
        let $boardInfo=$this.parent();
        //그 중 첫 번째 자식인 공지사항 글번호 객체를 찾아주고 
        let $boardNo=$boardInfo.firstChild();
        let boardNo=$boardNo.val();
        //1)자유게시판 글번호를 서버로 전달한다
        //2)서버에서는 전달된 글번호를 이용해서 DB에서 글번호,제목,내용,작성자등의 정보를 찾고
        //3)boardWrite.html 이동시킨 뒤에 DB정보를 넣어서 그 정보를 수정할 수 있게 만들어준다
        let url="";
        $.ajax({
            url: url,
            method:'post',
            data:boardNo,
            success:function(){
                
            },
            error:function(jqXHR){
                alert(jqXHR.error);
            }
        });
    });
});