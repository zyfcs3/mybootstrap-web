package cn.zhuyafeng.mybootstrapweb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.zhuyafeng.mybootstrapweb.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {
    
    @Autowired
    private ItemService itemService ;
    
    
    @RequestMapping(value="queryItem")
    public ModelAndView queryLikeItem(@RequestParam("name")String name){
        ModelAndView mv = new ModelAndView("LikeItem");
        Map<String, Object> likeItem =  itemService.queryLikeItem(name);
        mv.addObject("likeItem", likeItem);
        return mv;
    }

}
