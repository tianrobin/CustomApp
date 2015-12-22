///**
// * Alipay.com Inc.
// * Copyright (c) 2004-2013 All Rights Reserved.
// */
//package com.custom.app.service.task;
//
//import java.net.MalformedURLException;
//import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.Remote;
//import java.rmi.RemoteException;
//
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
//
//import com.caucho.hessian.client.HessianProxyFactory;
//import com.custom.app.service.DataBaseService;
//
///**
// * 
// * @author wb-tianzd
// * @version $Id: QuartzTest.java, v 0.1 2013-10-18 上午10:41:47 wb-tianzd Exp $
// */
//public class QuartzTest {
//
//    /**
//     * 
//     * @param args
//     */
//    public static void main(String[] args) {
////        System.out.println("Test start.");
////        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
////        //如果配置文件中将startQuertz bean的lazy-init设置为false 则不用实例化
////        System.out.print("Test end..\n");
//        
//      //Spring Hessian代理Servelet  
//        String url = "http://localhost:8080/CustomApp/remote/dataBaservices";  
//        HessianProxyFactory factory = new HessianProxyFactory();  
//        DataBaseService api=null;
//		try {
//			api = (DataBaseService) factory.create(DataBaseService.class, url);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}  
//	
//        System.out.println(api.sayHello("weitang"));  
//        
//        //调用WebService
//        JaxWsProxyFactoryBean cxffactory = new JaxWsProxyFactoryBean();
//        cxffactory.setServiceClass(DataBaseService.class);
//        cxffactory.setAddress("http://localhost:8080/CustomApp/services/remoteDataBaseService");
//        
//        DataBaseService service = (DataBaseService) cxffactory.create();
//        
//        System.out.println("#############Client##############");
//        System.out.println(service.sayHello("this  CXF "));
//        /*
//        HttpInvokerProxyFactoryBean hipfb = new HttpInvokerProxyFactoryBean();
//        hipfb.setServiceInterface(DataBaseService.class);
//        hipfb.setServiceUrl(serviceUrl);*/
//       
////        RmiProxyFactoryBean  rmifactory=new RmiProxyFactoryBean();
////        rmifactory.setServiceInterface(DataBaseService.class);
////        rmifactory.setServiceUrl(v);
////        DataBaseService dservice = (DataBaseService) rmifactory.
////        System.out.println(service.sayHello("this  RMI "));
//        try {
//        	Remote remote = Naming.lookup("rmi://localhost:9400/remoteService");
////        	remote.getClass().isInstance(obj)
//			System.out.println(remote);//service.sayHello("this  RMI "));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }  
//    
//
//}
