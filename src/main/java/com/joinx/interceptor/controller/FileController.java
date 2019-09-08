package com.joinx.interceptor.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.shape.Path;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;

import static java.nio.file.StandardOpenOption.*;

@Controller
public class FileController {

    @RequestMapping("{path}")
    public String  path(@PathVariable String path){
        System.out.println("基础的跳转方法");
        return path;
    }
    @RequestMapping("uploadfile")
    public String  uploadFile(MultipartFile file) throws IOException {
        long l1 = System.currentTimeMillis();
        String filename = file.getOriginalFilename();
        System.out.println(file.getOriginalFilename()+"====");
       InputStream in = (FileInputStream) file.getInputStream();
       //通过流直接拿到管道，给它在栈外开辟1024的空间进行文件的拷贝，节省了内存的开销，
        //但注意释放资源
        FileChannel inC=null;
        FileOutputStream out=null;
        FileChannel outC=null;
        ByteBuffer bf=null;
        try {
            inC= ((FileInputStream) in).getChannel();
            out=new FileOutputStream(new File("e:/sshupload/"+filename));
            outC = out.getChannel();
            bf=ByteBuffer.allocate(1024);
            while (inC.read(bf)!=-1){
             bf.flip();
             outC.write(bf);
             bf.clear();
            }
     }finally {
            //确保释放资源,防止内存泄漏
             bf=null;
             outC.close();
             out.close();
             inC.close();
             in.close();
     }
        long l2 = System.currentTimeMillis();
        System.out.println("nio上传耗时："+(l2-l1));
        return "index";
    }
    @RequestMapping("tranditionalLoad")
    public String tranditionalLoad(MultipartFile[] file2) throws IOException {
        long l1 = System.currentTimeMillis();
        InputStream in=null;
        OutputStream out=null;
        try {
        for (MultipartFile f:file2){
            in= f.getInputStream();
            out =new FileOutputStream(new File("e:/sshupload/"+f.getOriginalFilename()));

                byte[] bf=new byte[1024];
                int len=0;
                while((len=in.read(bf))!=-1){
                    out.write(bf);
                }

        }
        }
        finally {
            in.close();
            out.close();
        }

        long l2 = System.currentTimeMillis();
        System.out.println("传统上传耗时："+(l2-l1));
        return "index";
    }
    @RequestMapping("filelist")
    public String filelist(ModelMap map){
        File file=new File("e:/sshupload");
        File[] list = file.listFiles();
        map.put("list",list);
        return "filelist";
    }
    //springmvc的下载方式
    @RequestMapping("down")
    public ResponseEntity<byte[]> down(String filename){
        File file=new File("e:/sshupload/",filename);
        InputStream in=null;

        try {
            in= new FileInputStream(file);
            byte[] bf=new byte[in.available()];
            HttpHeaders headers = new HttpHeaders();
            filename=URLEncoder.encode(filename,"utf-8");
            headers.add("Content-Disposition", "attchement;filename=" + filename);
            HttpStatus status = HttpStatus.OK;
            //实例化响应实体对象
            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bf,headers,status);
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return null;
    }
    @ResponseBody
    @RequestMapping(value = "down2",produces = "text/html")
    public byte[] down2(String filename, HttpServletResponse response)  {
        File file=new File("e:/sshupload/",filename);
        FileInputStream fin=null;
        byte[] bf=null;
       try{
           fin=new FileInputStream(file);
           bf=new byte[fin.available()];
           filename=URLEncoder.encode(filename,"utf-8");
           response.addHeader("Content-Disposition", "inline;filename="+filename);
       }catch (Exception e){
            e.printStackTrace();
       }
        return bf;
    }
}
