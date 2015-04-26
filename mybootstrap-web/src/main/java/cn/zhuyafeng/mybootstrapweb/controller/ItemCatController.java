package cn.zhuyafeng.mybootstrapweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhuyafeng.mybootstrapweb.service.ItemCatService;

@RequestMapping("itemCat")
@Controller
public class ItemCatController {
    
    @Autowired
    private ItemCatService itemCatService;
    
    
    @RequestMapping("queryItemCatALL")
    @ResponseBody
    public List<String> queryItemCatALL(){
        String liItemCat =  itemCatService.queryItemCatALL();
        List<String> list= new ArrayList<String>();
        list.add(liItemCat);
        
        return list;
    }

}
