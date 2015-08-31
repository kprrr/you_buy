var data = {
};

$(function() {
	initView();
})

// 提交表单
function subMit() {
	formSubMit(id != "" ? "post-update" : "post-insert?category=1", data);
}

function initView() {
	$.post('site-getRegion',function(json){
		if(json.code == 10000) {
			var data = json.data;
			$.each(data,function(index,ele){
				alert(22)
				var dom = "<option value='"+data[index].region_id+"' >"+data[index].region_name+"</option>";
				$("#region_id").append(dom);
			});
		}
	},'json');
//		initForm("site-getRegion", data, function(json) {
//			console.log(json.data)
//			initUsers(json.author);
//		});// 初始化数据
}
//初始化下拉菜单值
function initRegions(authorId) {
	var userDom = new initWithCommbox('author');
	userDom.setUrl("user-get?selectMenu=id,name");
	userDom.setValueAndText("id", "name");
	if (authorId) {
		userDom.setSelectItem(authorId);
	}
	userDom.loadData();
}
