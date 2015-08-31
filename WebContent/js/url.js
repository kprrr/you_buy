var baseUrl = "";
/**
 * 请求地址
 *
 */
var url = {
    WapMenusType: baseUrl + "menusType-wapGet" //获取wap端菜单分类
    , WapMenus: baseUrl + "menus-wapGet"//获取wap端菜单
    , WapCreateOrder: baseUrl + "order-create"//创建订单
    , WapTrainList: baseUrl + "train-wapGet"//车次

    //下面为管理系统请求
    , WebCarSegmentList: baseUrl + "carSegment-get"//车段列表
    , WebCarSegmentDelete: baseUrl + "carSegment-remove"//车段列表
    , WebCarSegmentInsert: baseUrl + "carSegment-insert"//车段列表
    , WebCarSegmentUpdate: baseUrl + "carSegment-update"//车段列表


    , WebTrainList: baseUrl + "train-get"//列车列表
    , WebTrainDelete: baseUrl + "train-remove"//
    , WebTrainInsert: baseUrl + "train-insert"//
    , WebTrainUpdate: baseUrl + "train-update"//

    , WebMenusTypeList: baseUrl + "menusType-get"//菜单分类
    , WebMenusTypeDelete: baseUrl + "menusType-remove"//删除分类
    , WebMenusTypeInsert: baseUrl + "menusType-insert"//添加分类
    , WebMenusTypeUpdate: baseUrl + "menusType-update"//修改分类

    , WebMenusList: baseUrl + "menus-get"//菜单列表
    , WebMenusUpdate: baseUrl + "menus-update"//修改菜单
    , WebMenusDelete: baseUrl + "menus-remove"//删除菜单
    , WebMenusInsert: baseUrl + "menus-insert"//添加菜单

}