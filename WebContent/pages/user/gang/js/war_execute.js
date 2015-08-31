var data = {
	id : id
};

$(function() {
	initView();
	initUpload();
})

function initUpload() {
	// 初始化上传文件事件
	$("#select_file").click(function() {
		$("#imageBut").click();
	})
	$("#imageBut").live('change', function() {
		$("#title").html("正在上传...");
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
	formSubMit(id != "" ? "gang-update" : "gang-insert", data);
}

function initView() {
	if (id != "") {
		initForm("gang-get", data, function(json) {
			initUsers(json.owner);
		});// 初始化数据
	} else {
		initUsers();
	}
}

function initUsers(owner) {
	var userDom = new initWithCommbox('owner');
	userDom.setUrl("user-get?selectMenu=id,name");
	userDom.setValueAndText("id", "name");
	if (owner) {
		userDom.setSelectItem(owner);
	}
	userDom.loadData();
}
