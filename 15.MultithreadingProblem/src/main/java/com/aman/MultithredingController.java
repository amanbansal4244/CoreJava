package com.aman;

import java.util.ArrayList;  
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  
import com.aman.Multithreding;  
import com.aman.MultithredingDao; 

@Controller  
public class MultithredingController {  
	
    @Autowired  
    MultithredingDao dao;//will inject dao from xMultithreading-servlet.xml file  
      
    @RequestMapping("/processMultiThreadingData")  
    public void processMultiThreadingData(){  
        List<Multithreding> multiThreadingDataList=dao.getMultiThreadingData();  
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(new MyCallableThread());
        
       // return new ModelAndView("viewemp","empObj",list);  
    }  
    
}