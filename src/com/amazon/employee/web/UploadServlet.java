package com.amazon.employee.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/us")
public class UploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY ="UPLOAD";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;//3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10;//10MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50;//50MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("success");
        String filePath="";
        String fileName="";

        if (!ServletFileUpload.isMultipartContent(request)){
            response.getWriter().println("does not support");
            //if not we stop here
            return;

        }
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload= new ServletFileUpload();
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
        System.out.println(getServletContext().getRealPath(""));//"E:\\
        //constructs the directory path to store upload file
        String uploadPath = getServletContext().getRealPath("")
                +File.separator + UPLOAD_DIRECTORY;
        //creates the directory if it does not exist
        File uploadDir=new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
        try {
            List formItems=upload.parseRequest(request);
            Iterator iterator=formItems.iterator();


            //iterates over form's fields
            while (iterator.hasNext()){
                FileItem item= (FileItem) iterator.next();

                if (!item.isFormField()){
                    fileName=new File(item.getName()).getName();
                    //System.out.println("Filename="+fileName);
                    filePath=uploadPath+File.separator+fileName;
                    System.out.println("filePath="+filePath);
                    File storeFile= new File(filePath);
                    //saves the files on disk
                    item.write(storeFile);
                }else {
                    if (item.getFieldName().equalsIgnoreCase("name")){
                        String name=item.getString();
                        System.out.println("name="+name);
                    }
                }
            }
            request.setAttribute("message","upload has been done");
        }catch (Exception ex){
            request.setAttribute("message","upload can't be done");
            ex.printStackTrace();
        }
        request.getRequestDispatcher("/views.jsp").forward(request,response);
    }


}
