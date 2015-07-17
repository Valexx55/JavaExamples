package org.apache.struts.helloworld.action;

import java.io.File;
import java.io.IOException;
 


import javax.servlet.ServletContext;
 

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.util.ServletContextAware;
 
import org.apache.struts.helloworld.action.FilesUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFileAction extends ActionSupport{

	
	
     
    private File file;
    private String fileContentType;
    private String fileFileName;
    private String directorio;
 
    
   	public String execute(){
        System.out.println("File Name is:"+getFileFileName());
        System.out.println("File ContentType is:"+getFileContentType());
        System.out.println("Files Directory is:"+directorio);
        try {
            FilesUtil.saveFile(getFile(), getFileFileName(),  directorio);
            System.out.println("HA TERMINADO DE GUARDAR EL FICHERO");
        } catch (IOException e) {
            e.printStackTrace();
            return INPUT;
        }
        return SUCCESS;
         
    }
    
    
    
    
    public void espera()
    {
    	System.out.println("entro pero no hago nada");
    	//
    }
    public File getFile() {
        return file;
    }
 
    public void setFile(File file) {
        this.file = file;
    }
 
    public String getFileContentType() {
        return fileContentType;
    }
 
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
 
    public String getFileFileName() {
        return fileFileName;
    }
 
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
 
    public void setDirectorio(String filesPath) {
        this.directorio = filesPath;
    }
 
}
