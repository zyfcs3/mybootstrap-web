package cn.zhuyafeng.mybootstrapweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zhuyafeng.mybootstrapweb.service.ItemService;


@RequestMapping("page")
@Controller
public class PageController {
    
    @Autowired
    private ItemService itemService;

    @RequestMapping("{path}")
    public ModelAndView goPage(@PathVariable("path")String path,HttpServletRequest request){
        ModelAndView mv = new ModelAndView(path);
        Map<String,Object>items = itemService.queryPageItem();
        
        mv.addObject("items", items);
        return mv;
    }
    
    
}
