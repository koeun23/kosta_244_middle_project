$(function(){
    $("tbody a").click(function(){
        let $tdObj=$(this).parent();
        let $trObj=$tdObj.parent();
        let $introNo=$trObj.children(":first");
        let introNo=$introNo.val();
        $(this).prop( 'href','resumeWrite?introNo='+introNo);
    });
});