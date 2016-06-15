package com.anbo.action;

import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.sql.Timestamp;  
import java.util.Date;  
import java.util.Map;  
  
import org.apache.struts2.ServletActionContext;  
  
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
  
//import dc.bean.Project;  
//import dc.bean.Projectfile;  
//import dc.bean.User;  
//import dc.service.ProjectService;  
//import dc.service.ProjectfileService;  
//  
public class ProjectfileAdd extends ActionSupport {  
//    private static final int FILE_SIZE=16*1024;  
//    private int projectid;  
//    private ProjectService projectService;  
//    private ProjectfileService projectfileService;  
//    private File file;  
//    private String fileFileName;  
//    private String fileContentType;  
//      
//    public int getProjectid() {  
//        return projectid;  
//    }  
//  
//    public void setProjectid(int projectid) {  
//        this.projectid = projectid;  
//    }  
//  
//    public ProjectService getProjectService() {  
//        return projectService;  
//    }  
//  
//    public void setProjectService(ProjectService projectService) {  
//        this.projectService = projectService;  
//    }  
//  
//    public ProjectfileService getProjectfileService() {  
//        return projectfileService;  
//    }  
//  
//    public void setProjectfileService(ProjectfileService projectfileService) {  
//        this.projectfileService = projectfileService;  
//    }  
//  
//    public File getFile() {  
//        return file;  
//    }  
//  
//    public void setFile(File file) {  
//        this.file = file;  
//    }  
//  
//    public String getFileFileName() {  
//        return fileFileName;  
//    }  
//  
//    public void setFileFileName(String fileFileName) {  
//        this.fileFileName = fileFileName;  
//    }  
//  
//    public String getFileContentType() {  
//        return fileContentType;  
//    }  
//  
//    public void setFileContentType(String fileContentType) {  
//        this.fileContentType = fileContentType;  
//    }  
//  
//    public static int getFileSize() {  
//        return FILE_SIZE;  
//    }  
//  
//    //写入文件时候用到的函数  
//     public void upLoadFile(File source,File target){  
//          InputStream in=null;  
//          OutputStream out=null;  
//          try{  
//           in=new BufferedInputStream(new FileInputStream(source),FILE_SIZE);  
//           out=new BufferedOutputStream(new FileOutputStream(target),FILE_SIZE);  
//           //in-->image-->out  
//           byte[] image=new byte[FILE_SIZE];  
//           while(in.read(image)>0){  
//            out.write(image);  
//           }  
//          }catch(IOException ex){  
//           ex.printStackTrace();  
//          }finally{  
//           try{  
//            in.close();  
//            out.close();  
//           }catch(IOException ex){  
//            ex.printStackTrace();  
//           }  
//          }  
//         }  
//       
//        public String execute() {  
//            try {  
//                Projectfile projectfile=new Projectfile();  
//                projectfile.setName(fileFileName);  
//                Project project=projectService.ReadByID(projectid);  
//                projectfile.setProject(project);  
//                projectfile.setModifytime( new Timestamp(new Date().getTime()));  
//                String filepath="file/"+project.getId()+"/"+fileFileName;  
//                projectfile.setFilepath(filepath);  
//                projectfile.setFilesize(file.length());  
//                //不是连接到外网的文件  
//                projectfile.setFilelink(0);  
//                projectfile.setContenttype(fileContentType);  
//                //--记录编辑人------------------  
//                ActionContext context = ActionContext.getContext();  
//                Map sessionMap = context.getSession();  
//                User currentuser=(User)sessionMap.get("user");  
//                projectfile.setUser(currentuser);  
//                //------------------------------  
//                //projectfile.setFilesize(1);  
//                projectfileService.save(projectfile);  
//                //文件上传，存至硬盘  
//                //ServletActionContext.getServletContext().getRealPath获得webRoot绝对路径  
//                String realfilePath=ServletActionContext.getServletContext().getRealPath("file")  
//                  +"/"+project.getId()+"/"+this.fileFileName;  
//                File targetFile=new File(realfilePath);  
//                targetFile.getParentFile().mkdirs();  
//                upLoadFile(file,targetFile);  
//            } catch (Exception ex) {  
//                ex.printStackTrace();  
//                return ERROR;  
//            }  
//            return SUCCESS;  
//        }  
}  