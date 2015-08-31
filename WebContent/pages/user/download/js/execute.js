var data = {
	id : id
};

$(function() {
	initView();
})





// 提交表单
function subMit() {
	formSubMit(id != "" ? "downloads-update" : "downloads-insert", data);
}

function initView() {
	if (id != "") {
			initForm("downloads-get", data, function(json) {
		});// 初始化数据
	} else {
	}
}
