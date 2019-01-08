function openDialog(title,contentOrUrl){
    layer.open({
        title: title
        ,content: contentOrUrl
    });
}

var Common = {
    ctxPath: "",
    version:"",
    log: function (info) {
        console.log(info);
    },
    alert: function (info, iconIndex) {
        parent.layer.msg(info, {
            icon: iconIndex
        });


    },
    info: function (info) {
        Common.alert(info, 0);
    },
    success: function (info) {
        Common.alert(info, 1);
    },
    error: function (info) {
        Common.openConfirm(info)
    },
    post: function (url, paras, nextUrl) {
        $.ajax({
            url:Common.ctxPath+url,
            type:"POST",
            data:paras,
            success:function(rsp){
                if(rsp.code!=0){
                    Common.error(rsp.msg);
                }else{
                    //成功
                    Common.info("删除成功");
                    location.href=nextUrl;
                }
            },
            error:function(rsp){
                Common.error(rsp.responseJSON.msg);
            }
        })

    },
    getOneFromTable:function(layuiTable,tableId){
        var checkStatus = layuiTable.checkStatus(tableId)
            ,data = checkStatus.data;
        if(data.length==0){
            Common.info("请选中一条记录");
        }else if(data.length>1){
            Common.info("只能选中一条记录")
        }else{
            return  data[0];
        }
    },
    getMoreDataFromTable:function(layuiTable,tableId){
        var checkStatus = layuiTable.checkStatus(tableId)
            ,data = checkStatus.data;
        if(data.length==0){
            Common.info("请选中记录");
        }else{
            return  data;
        }
    },
    openDlg:function(url,title){
        var index = layer.open({
            type: 2,
            content: Common.ctxPath+url,
            title: title,
            maxmin: false
        });
        layer.full(index);
    },
    topOpenDlg:function(url,title,width,height){
        if(!width){
            width= '100%';
        }
        if(!height){
            height= '100%';
        }
        var index = top.layer.open({
            type: 2,
            content: Common.ctxPath+url,
            title: title,
            area:[width,height],
            maxmin: false
        });
        layer.full(index);
    },
    openConfirm:function(content,callback,callBackNo){
        var index = layer.confirm(content, {
            btn: ['确认','取消'] //按钮
        }, function(){
            if(callback!=null){
                callback();
            }
            layer.close(index);
        }, function(){
            if(callBackNo!=null){
                callBackNo()
            }
            layer.close(index);
        });

    },
    openPrompt:function(title,defaultValue,callback){
        layer.prompt({title: title, formType: 0,value:defaultValue}, function(value, index,elem){
            layer.close(index);
            callback(value);
        });
    },
    concatBatchId:function(data,idField){
        var ids = ""
        var name=idField==null?"id":idField;
        for(var i=0;i<data.length;i++){
            var item = data[i];
            ids=ids+item[name];
            if(i!=data.length-1){
                ids=ids+","
            }
        }
        return ids;
    },
    sessionTimeoutRegistry: function () {
        $.ajaxSetup({
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            complete: function (XMLHttpRequest, textStatus) {
                //通过XMLHttpRequest取得响应头，sessionstatus，
                var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
                if (sessionstatus == "timeout") {
                    //如果超时就处理 ，指定要跳转的页面
                    window.location = Common.ctxPath + "/global/sessionError";
                }
            }
        });
    },
    initValidator: function(formId,fields){
        $('#' + formId).bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: fields,
            live: 'enabled',
            message: '该字段不能为空'
        });
    },
    getDate:function(date,pattern){
        if(date==null||date==''){
            return "";
        }else{
            if(pattern){
                return new Date(date).format(pattern);
            }else{
                return date.substring(0,10);
            }

        }
    },
    closeFrame : function() {
        var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
        parent.layer.close(index); // 再执行关闭
    },
    dataReload : function() {
        parent.window.dataReload();
    },
    post: function (url, paras, next) {
        $.ajax({
            url:Common.ctxPath+url,
            type:"POST",
            data:paras,
            success:function(rsp){
                if(rsp.code!=0){
                    Common.error(rsp.msg);

                }else{
                    //成功
                    if(next!=null){
                        next(rsp.data);
                    }else{
                        Common.success(rsp.responseJSON.msg);
                    }
                }
            },
            error:function(rsp){
                Common.error(rsp.responseJSON.msg);
            }
        })
    },
    dataReload : function() {
        parent.window.location.reload(); //刷新
    },
};