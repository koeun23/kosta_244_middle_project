$(function(){
	$("input[name=save]").click(function(){
		//분야 지역 나이대 제목 글내용 일자~
		let $field=$("");
		let feild=$title.val();
		
		let $title=$("input[type=text].form-control");
		let title=$title.val();
		
		let data="field="+field+"%location"+location;
		
		$.ajax({
       	 	url:'http://localhost:8888/project1/projectWrite2',
        	method:'post',
       	 	data:data,
        	success:function(jsonObj){ 
				alert(jsonObj.msg);
				
        },
        	error: function(jqXHR){
            	alert('에러코드 : '+jqXHR.status);

        }
    });

    return false;

    });
});