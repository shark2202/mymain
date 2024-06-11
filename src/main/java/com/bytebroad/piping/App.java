package com.bytebroad.piping;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.catalina.Wrapper;
import org.apache.catalina.connector.Connector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        // app.scan("com.bytebroad.piping");

        // Employee mybean = (Employee) app.getBean("employee");

        // System.out.println("name:" + mybean.getName());

              // 创建一个 Tomcat 服务器实例
              Tomcat tomcat = new Tomcat();
        
              tomcat.getConnector().setPort(10010);
              // 设置端口号
              //tomcat.setPort(10010);

              
              
              tomcat.getHost().setAppBase(".");

            //   File base = new File(System.getProperty("java.io.tmpdir"));
              File base = new File("/Users/mac/codes/java_demo/mymain/src/main/webapp/");

              Context ctx = tomcat.addContext("", base.getAbsolutePath());

              if(ctx instanceof StandardContext){
                    Wrapper wap = tomcat.addServlet("/mypath", "mypath", new HelloWorldServlet());
                    wap.addMapping("/ppppp");
              }
              // 指定 Web 应用程序的根目录
              //StandardContext ctx = (StandardContext) tomcat.addWebapp("/", "/Users/mac/codes/java_demo/mymain/src/main/webapp/");
              System.out.println(ctx.getDocBase());
        //       File additionWebInfClasses = new File("target/classes");
        // WebResourceRoot resources = new StandardRoot(ctx);
        // resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
        //         additionWebInfClasses.getAbsolutePath(), "/"));
        // ctx.setResources(resources);

                //Tomcat.initWebappDefaults(ctx);

                Class helloworld = HelloWorldServlet.class;
                Tomcat.addServlet(ctx, "myservlet1", helloworld.getName());
                ctx.addServletMappingDecoded("/hello/*", "myservlet1");
        
                
              // 启动 Tomcat 服务器
              try {
                tomcat.start();

                //System.out.println(tomcat.getConnector().getLocalPort());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              
              // 阻塞当前线程，直到服务器停止
              tomcat.getServer().await();
    }

    
}
