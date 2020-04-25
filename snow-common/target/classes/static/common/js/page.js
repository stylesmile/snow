

var Page = {

    /* 初始化搜索 */
    initSearchForm : function(btn,form, tableIns, layuiForm) {
        btn.on('click', function() {
            Page.doSearchForm(form, tableIns, 1);
        });
    },
    /* 搜索 */
    doSearchForm : function(form, tableIns, page) {
        var data = form.serializeJson()
        if (page != null) {
            tableIns.reload({
                where : data
                // ,page: {
                //     current: page
                // }

            });
        } else {
            tableIns.reload({
                where : data
            });
        }

    },
};

