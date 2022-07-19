$(function(){

    $.ajax({
        url:'/project1/projectDelete',
        method:'get',
        success:function(jsonObj){
            $(jsonObj).each(function(index, p){
               
            });
        }
    });
    });