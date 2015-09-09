package com.sys.action;

import com.base.BaseAction;
import com.sys.model.sys_user;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;


/**
 * 文件上传
 *
 * @author 张宏
 */
@Component("fileAction")
@Scope("prototype")
public class FileAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    public File file;                                        //文件流
    public String fileFileName;                                //上传的文件名


    //文件上传 file-upload
    public void upload() {
            String dFileName = fileFileName + "";
            fileFileName = fileFileName.substring(
                    fileFileName.lastIndexOf("."), fileFileName.length());
            fileFileName = String.valueOf(new Date().getTime()) + fileFileName;
            try {
                FileInputStream fis = new FileInputStream(file);
                byte[] b = new byte[500];

                FileOutputStream fos =
                        new FileOutputStream(getFilePath() + "/upload/" + fileFileName);
                while (fis.read(b) > 0) {
                    fos.write(b);
                }
                fis.close();
                fos.close();
                logger.info(fileFileName + "文件上传完毕！");
                String url = getBaseUrl() + "upload/" + fileFileName;
                String json = "{\"fileName\":\""+ dFileName +"\",\"url\":\""+ url +"\"}";
                this.outJson(codeJson(SCODE, json));
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

}
