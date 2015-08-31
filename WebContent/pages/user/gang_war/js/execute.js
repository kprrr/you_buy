var data = {id: id};

$(function () {
    initView();
})

//提交表单
function subMit() {
    formSubMit(id != "" ? url.WebTrainUpdate : url.WebTrainInsert
        , data);
}

function initView() {
    if (id != "") {
        initForm(url.WebTrainList, data ,function(json){
            initCarSegment(json.car_segment_id);
        });//初始化数据
    }else{
        initCarSegment();
    }
}

function initCarSegment(car_segment_id){
    var csDom = new initWithCommbox('car_segment_id');
    csDom.setUrl(url.WebCarSegmentList + "?selectMenu=id,title");
    if(car_segment_id){
        csDom.setSelectItem(car_segment_id);
    }

    csDom.loadData();
}
