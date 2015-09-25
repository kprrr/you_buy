package com.weixin.model;

/**
 * 微信信息
 *
 * @author lxj
 */
public class ws_mess {
    private String toUserName;        //消息接收方微信号，一般为公众平台账号微信号
    private String fromUserName;    //消息发送方微信号
    private String createTime;        //消息创建时间
    private String msgType;            //文本消息为text
    private String content;            //消息内容

    private String mediaId;         //媒体id

    private String event;            //消息类型(菜单点击 关注或者取消关注)
    private String eventKey;        //消息内容 (菜单点击)


    private String location_X;        //地理位置维度
    private String location_Y;        //地理位置精度
    private String label;            //地理位置信息

    private String picUrl;            //图片链接
    private String title;            //图片标题
    private String description;        //图片介绍
    private String url;                //图片链接


    private String ticket;          //二维码Ticket

    private String musicUrl;        //音乐链接

    private String mess;            //第三方反馈的信息 主要图文格式信息 JSON

    private String app_id;            //聚信盒子appid

    private String menu_id;            //当前菜单ID


    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menuId) {
        menu_id = menuId;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String appId) {
        app_id = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String locationX) {
        location_X = locationX;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String locationY) {
        location_Y = locationY;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
