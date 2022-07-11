$(function(){
	//클릭한 게시글 번호를 a태그에 넣어서 
	//noticeView?boardNo=1
	//이런식으로 ajax요청이 아닌 주소요청 방식(GET)으로 서버에 게시글번호를 주면
	//서버에선 해당 글번호를 받아서 DB에 일치하는 게시글 정보를 찾고
	//noticeView.html 페이지에 게시글 정보를 붙여ㅓ 사용자에게 보여준다
   	$(".linkNotice").click(function(){
		//  div(글 정보포함 ) > div > a()
  		let $title=$(this);
  		let $divtitle=$title.parent();
    	let $notice=$divtitle.parent();
    	console.log($title);
    	console.log($divtitle);
    	console.log($notice);
   		let $boardNo=$notice.children(":first");
  		console.log($boardNo);
   		let boardNo=$boardNo.html();
   		console.log(boardNo);
   		//$('.linkNotice').prop('href',"http://localhost:8888/back4/noticeview?boardNo="+boardNo);
   		
   		location.href="../project_html/noticeView.html?boardNo=" + boardNo;
   		return false;
	});
});