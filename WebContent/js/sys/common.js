/* ----------表格宽度适应------------ */
function fixWidthTable() {
    var percent = 1.2;
    return getWidth(1) * percent;
}

function getWidth(percent) {
    return $(window).width() * percent;
}

//----------------辅助方法----------------//

function LocationHref() {
    location.href = window.location.href.split('#')[0];
}

//弹出消息框
function ShowMessage(title, body, icon) {
    $.messager.alert(title, body, icon);
}

//JOSN时间格式转换
function ChangeDateFormat(cellval) {
    if (cellval) {
        var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    } else {
        return "";
    }
}

function trim(value) {
    value = value.replace(/^ +| +$/g, '');
    return value;
}

