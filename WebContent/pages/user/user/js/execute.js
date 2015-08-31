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
            $(".image").attr("src", json.mess.url);
            $("#icon").val(json.mess.url);
            //url = json.mess.url;
            //窃取文件名
            //url = url.substring(url.lastIndexOf("/") + 1, url.length);
        });
    })

    //初始化上传文件事件
    $("#select_apk").click(function () {
        $("#btn_apk").click();
    })
    $("#btn_apk").live('change', function () {
        $("#apk_url").html("正在上传...");
        ajaxFileUpload("btn_apk", function (json) {
            $("#apk_url").html(json.mess.url);
            $("#apk").val(json.mess.url);
            //url = json.mess.url;
            //窃取文件名
            //url = url.substring(url.lastIndexOf("/") + 1, url.length);
        });
    })

    //初始化上传文件事件
    $("#select_ipa").click(function () {
        $("#btn_ipa").click();
    })
    $("#btn_ipa").live('change', function () {
        $("#ipa_url").html("正在上传...");
        ajaxFileUpload("btn_ipa", function (json) {
            $("#ipa_url").html(json.mess.url);
            $("#ipa").val(json.mess.url);
            //url = json.mess.url;
            //窃取文件名
            //url = url.substring(url.lastIndexOf("/") + 1, url.length);
        });
    })
}


// 提交表单
function subMit() {
	formSubMit(id != "" ? "user-update" : "user-insert", data);
}

function initView() {
	if (id != "") {
			initForm("user-get", data, function(json) {
                $("#apk_url").html(json.apk);
                $("#ipa_url").html(json.ipa);
		});// 初始化数据
	} else {
	}
}
