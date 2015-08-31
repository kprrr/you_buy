var data = {
	id : id
};

$(function() {
	initUpload();
	initView();
})

function initUpload() {
	// 初始化上传文件事件
	$("#select_file").click(function() {
		$("#imageBut").click();
	})
	$("#imageBut").live('change', function() {
		ajaxFileUpload("imageBut", function(json) {
			$(".image").attr("title", "已上传");
			$(".image").attr("src", json.mess.url);
			$("#icon").val(json.mess.url);
			// url = json.mess.url;
				// 窃取文件名
				// url = url.substring(url.lastIndexOf("/") + 1, url.length);
			});
	})
}

// 提交表单
function subMit() {
	formSubMit(id != "" ? "gangGame-update" : "gangGame-insert", data);
}

function initView() {
	if (id != "") {
		initForm("gangGame-get", data, function(json) {
		});// 初始化数据
	} else {
		initUsers();
	}
}
