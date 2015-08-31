function ajaxFileUpload(fileid, sucessFunction) {

    //starting setting some animation when the ajax starts and completes
    $("body").ajaxStart(function () {
        ajaxLoading('mainWin');
    }).ajaxComplete(function () {
        ajaxLoadEnd();
    });

    /*
     prepareing ajax file upload
     url: the url of script file handling the uploaded files
     fileElementId: the file type of input element id and it will be the index of  $_FILES Array()
     dataType: it support json, xml
     secureuri:use secure protocol
     success: call back function when the ajax complete
     error: callback function when the ajax failed

     */
    $.ajaxFileUpload
    (
        {
            url: 'file-upload',
            secureuri: false,
            fileElementId: fileid,
            dataType: 'json',
            success: function (json) {
                sucessFunction(json);
            },
            error: function (XMLHttpRequest, textStatus, thrownError) {

                 alert("访问出错，请刷新或重新登录");
            }
        }
    )

    return false;

}