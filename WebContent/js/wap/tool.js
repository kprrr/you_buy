/**
 * 发送请求
 * @param url 请求地址
 * @param successFunction 回调函数
 * @param data 请求参数 可不填
 */
function sendUrl(url,successFunction,data,isNotLoad){
    $.ajax({
        type:"POST",
        url:url,
        data:data,
        success:function(json){
            if(json.code==0){
                alert(json.mess);
            }else{
                if(json.mess){
                    successFunction(json.mess);
                }else{
                    successFunction(json.rows);
                }
            }
        },
        beforeSend:function(){
            if(!isNotLoad){
                if(!$(".loadBg")[0]){
                    var loadingDom = '<div class="loadBg">' +
                        '<div class="loadParam">' +
                        '<img src="/img/wap/loading.gif">' +
                        '<div class="title">请稍候</div>' +
                        '</div>';
                    $("body").append(loadingDom);
                }
            }
        },
        complete:function(){
            $(".loadBg").remove();
        },
        error:function(){
            alert("访问出错,刷新试试!");
        }
    })
}

$.format = function (source, params) {
    if (arguments.length == 1)
        return function () {
            var args = $.makeArray(arguments);
            args.unshift(source);
            return $.format.apply(this, args);
        };
    if (arguments.length > 2 && params.constructor != Array) {
        params = $.makeArray(arguments).slice(1);
    }
    if (params.constructor != Array) {
        params = [params];
    }
    $.each(params, function (i, n) {
        source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
    });
    return source;
};
