var data = {
	id : id
};

$(function() {
	initView();
})

// 提交表单
function subMit() {
	formSubMit(id != "" ? "post-update" : "post-insert?category=2", data);
}

function initView() {
	if (id != "") {
		initForm("post-get", data, function(json) {
			initUsers(json.author);
		});// 初始化数据
	} else {
		initUsers();
	}
}

function initUsers(authorId) {
	var userDom = new initWithCommbox('author');
	userDom.setUrl("user-get?selectMenu=id,name");
	userDom.setValueAndText("id", "name");
	if (authorId) {
		userDom.setSelectItem(authorId);
	}
	userDom.loadData();
}
