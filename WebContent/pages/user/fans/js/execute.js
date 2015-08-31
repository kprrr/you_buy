var data = {
	id : id
};

$(function() {
	initView();
})

// 提交表单
function subMit() {
	formSubMit(id != "" ? "fans-update" : "fans-insert", data);
}

function initView() {
	if (id != "") {
		initForm("fans-get", data, function(json) {
			initUsers(json.uid, json.fan);
		});// 初始化数据
	} else {
		initUsers();
	}
}

function initUsers(uid, fan) {
	var userDom = new initWithCommbox('uid');
	userDom.setUrl("user-get?selectMenu=id,name");
	userDom.setValueAndText("id", "name");
	if (uid) {
		userDom.setSelectItem(uid);
	}
	userDom.loadData();

	var fanDom = new initWithCommbox('fan');
	fanDom.setUrl("user-get?selectMenu=id,name");
	fanDom.setValueAndText("id", "name");
	if (fan) {
		fanDom.setSelectItem(fan);
	}
	fanDom.loadData();
}
