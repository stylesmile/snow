//自定义 jquery方法
(function($){
    /**
     * 获取form表单数据
     */
    $.fn.getFormData = function (isValid) {
        var fieldElem = $(this).find('input,select,textarea'); //获取所有表单域
        var data ={};
        layui.each(fieldElem, function(index, item){
            if(!item.name) return;
            if(/^checkbox|radio$/.test(item.type) && !item.checked) return;
            var value = item.value;
            if(item.type == "checkbox"){//如果多选
                if(data[item.name]){
                    value = data[item.name] + "," + value;
                }
            }
            if(isValid)
            {
                //如果为true,只需要处理有数据的值
                if(!$.isEmpty(value))
                {
                    data[item.name] = value;
                }
            }
            else
            {
                data[item.name] = value;
            }
        });
        return data;
    };
    //序列化json   如form转json
    $.fn.serializeJson = function(){
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(
            function() {
                if (serializeObj[this.name]) {
                    if ($.isArray(serializeObj[this.name])) {
                        serializeObj[this.name].push(this.value);
                    } else {
                        serializeObj[this.name] = [
                            serializeObj[this.name], this.value ];
                    }
                } else {
                    serializeObj[this.name] = this.value;
                }
            });
        return serializeObj;
    }

}(jQuery));