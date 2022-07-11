$(function(){
    $(function(){
        let queryString=location.search;
        $.ajax({
            url: '/back4/noticeview'+ queryString,
            method: 'get',
            success: function(jsonObj){
                $('div.boardText').html(jsonObj.boardText);
            }
        });
        
        
        
        
        //공지사항 상세페이지에서 수정하기 버튼이 클릭되었을 때
        //참고로 공지사항 수정하기 버튼은 관리자에게만 보이기 때문에
        //관리자만 수정가능 하다.
        $("button.reviseNotice").click(function(){
            //공지사항 정보를 포함하는 부모 객체를 찾자
            let $noticeInfo=$this.parent();
            let $boardNo=$noticeInfo.firstChild();
        });
    });
});