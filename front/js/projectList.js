//on click 과 click의차이, on은 동적생성된 태에 이벤트가 바인딩된다.
//그냥click은 미리 생성된 태그에만 이벤트가 바인딩된다.
//$("#selector").on("click", "li", function(event){})
//$("#selector").click(function(){});
$(function(){

    //post방식으로 임시목록 ajax를 호출한다.
    HeyJs.fnAjaxPost(
       {}
       , "projectView"         //ajax 호출하는 URL
       , fnAjaxListCallBack   
    );
  });
 
 
 /****************************************
 * @author me
 * @desc ajax가 성공 후 호출하는 콜백 함수
 ​*/       
 let fnAjaxListCallBack = function(data){
    
    //ajax에서 받은 json형태의 결과값
    let list = data.response;
    
    console.log('ajax 호출');
    console.log(list);
    
    let appendHtml = "";
 
    //동적으로 그리는 영역 초기화   
    $('#setTempTbody').empty();
    
    list.forEach(function(v,i){ //포이치가 배열만큼 뺑뺑이돈다. 근데..v는 현재 뺑뺑이도는 현재 도는 위치의 값, i는 순번 index = i
       
       appendHtml +=   '<tr>';
       appendHtml +=      '<td>'+i+'</td>'
       appendHtml +=      '<td><a href="#">'+v.p_no+'</a></td>';
       appendHtml +=      '<td>'+v.user_no+'</td>';
       appendHtml += '<td>'+v.p_title+'</td>';
       appendHtml += '<td>'+v.p_content+'</td>';
       appendHtml += '<td>'+v.p_views+'</td>';
       appendHtml +=      '<td>0</td>';
       appendHtml +=      '<td>'+v.ptempCreateday+'</td>';
       appendHtml +=   '</tr>'
    
    });
    
    $('#setTempTbody').append(appendHtml);
 };
 