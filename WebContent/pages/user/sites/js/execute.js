var data = {
		id:id
};
//alert(data.id);

$(function() {
	initView();
	initUpload()
})

// 提交表单
function subMit() {
	var url="";
	if(data.id != ""){
		url="site-update";
	}else {
		url="site-add";
	};
	
	   $("#form").find("input").each(function(index,element){
		   if(element.id != "") {
			   if(element.id == "region_id") {
//				   alert($('#region_id').combobox('getValue'));
				   data.region_id = $('#region_id').combobox('getValue');
			   }else {
				   
				   eval("data."+element.id +"='"+$(element).val()+"'");  //这样一句就把一个表单元素的各个变量赋值到一个对象里去了
			   }
		   }
		   });
	   $.ajax({
		    type : "POST",
		    url : url,
		    data : data,
		    dataType : "json", //服务器返回结果的数据格式，如Json，xml，html等
		    processdata : true, //True or False
		    success : function(json) {
		     if(json.code==1) {
		    	//刷新父窗体数据
	                $("#list").datagrid('reload');
	                //关闭窗体
	                $('#win').window('close');
		     }else {
		      alert("服务器正忙，请稍后再试");
		     }
		    },
		    error : function(msg) {
		     //如果服务调用失败，如何提示给用户
		     //alert('服务调用失败: ' + msg.status + '' + msg.statusText);
		    }
		   });
	//formSubMit(id != "" ? "site-add" : "site-update", data);
}

function initView() {
	if(data.id != "") {
		initForm("site-getSingleSite", data, function(json) {
			initRegion();
		});
	}else {
		initRegion();
	}
	
	
	
}

function initRegion() {
	//初始化区域信息
	$.post('site-getRegion',function(json){
		if(json.code == 10000) {
			var data = json.data;
			$('#region_id').combobox({
				data : data,
				valueField:'region_id',
				textField:'region_name'
				});
		}
	},'json');
}


function initUpload() {
	// 初始化上传文件事件
	$("#select_file").click(function() {
		$("#imgBtn").click();
	})
	$("#imgBtn").live('change', function() {
		$("#title").html("正在上传...");
		ajaxFileUpload("imgBtn", function(json) {
			$(".image").attr("title", "已上传");
			$(".image").attr("src", json.mess.url);
			//alert(json.mess.url)
			$("#img").val(json.mess.url);
			// url = json.mess.url;
				// 窃取文件名
				// url = url.substring(url.lastIndexOf("/") + 1, url.length);
			});
	})
}