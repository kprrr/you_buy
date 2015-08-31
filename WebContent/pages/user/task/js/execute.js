var data = {
	id : id
};

$(function() {
	initView();
	initUpload();
})


function initUpload() {
    //初始化上传文件事件
    $("#select_file").click(function () {
        $("#imageBut").click();
    })
    $("#imageBut").live('change', function () {
        $("#title").html("正在上传...");
        ajaxFileUpload("imageBut", function (json) {
            $(".icon").attr("title", "已上传");
            $(".icon").attr("src", json.mess.url);
            $("#icon").val(json.mess.url);
            //url = json.mess.url;
            //窃取文件名
            //url = url.substring(url.lastIndexOf("/") + 1, url.length);
        });
    })
}


// 提交表单
function subMit() {
	formSubMit(id != "" ? "gangTask-update" : "gangTask-insert", data);
}

function initView() {
	if (id != "") {
			initForm("gangTask-get", data, function(json) {
		});// 初始化数据
	} else {
	}
}
