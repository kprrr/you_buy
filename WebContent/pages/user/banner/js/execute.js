var data = {
	id : id
};

$(function() {
	initView();
	initUpload();
})


function initUpload() {
    //初始化上传文件事件
    $("#btn_pic_url").click(function () {
        $("#file_pic_url").click();
    })
    $("#file_pic_url").live('change', function () {
        ajaxFileUpload("file_pic_url", function (json) {
            $("#img_pic_url").attr("src", json.mess.url);
            $("#pic_url").val(json.mess.url);
        });
    })

    //初始化上传文件事件
    $("#btn_pic_url2").click(function () {
        $("#file_pic_url2").click();
    })
    $("#file_pic_url2").live('change', function () {
        ajaxFileUpload("file_pic_url2", function (json) {
            $("#img_pic_url2").attr("src", json.mess.url);
            $("#pic_url2").val(json.mess.url);
        });
    })

}


// 提交表单
function subMit() {
	formSubMit(id != "" ? "banner-update" : "banner-insert", data);
}

function initView() {
	if (id != "") {
			initForm("banner-get", data, function(json) {
               
		});// 初始化数据
	} else {
	}
}
