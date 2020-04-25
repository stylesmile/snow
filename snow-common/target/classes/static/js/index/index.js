layui.define(['form'], function(exports) {
    var view = {
        init:function(){
            alert(1);
            this.initButton();
        },
        initButton: function(){
            $(function(){
                $("ul li dl dd").click(function(){
                    var url = $(this).attr("url");
                    console.log(url);
                    $("#iframe-body").html("<iframe src='"+url+"'></iframe>");
                })
            });
        }
    };
    exports('index',view);
});