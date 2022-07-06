$(function(){
    //취소하기 눌렀을 때
    $("button.cancle").click(function(){
        //공지사항 글쓰기 페이지로 이동하도록
        location.href="./noticeWrite.html";
    });
    //작성완료 눌렀을 때 
    $("button.complete").click(function(){
        //공지사항 글제목과 글을 서버에 이동시켜서 
        //서버에서 글번호와 작성자 등의 정보와 함께 DB에 저장시킨다.
        let $title=$(".title");
        let $context=$(".noticeText");

        let title=$title.val();
        let context=$context.val();
        
        let url="";
        let data="title="+title+"&context="+context;
        $.ajax({
            url:url,
            method:'get',
            data:data,
            success:function(){},
            error:function(){}
        });
    });
});