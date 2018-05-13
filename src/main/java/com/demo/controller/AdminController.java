package com.demo.controller;

import com.demo.dto.AmountDTO;
import com.demo.dto.DishesCountDTO;
import com.demo.dto.DishesDTO;
import com.demo.pojo.Dishes;
import com.demo.pojo.Material;
import com.demo.service.DishesService;
import com.demo.service.MaterialService;
import com.demo.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lichenxin@xinzhentech.com
 * @version 1.0
 * @since 2018/5/11 22:41
 */
@Controller
public class AdminController {

    @Autowired
    private DishesService dishesService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private OrdersService ordersService;

    //菜单列表
    @RequestMapping("/admin_dishes_list")
    public String dishesList(Map map){
        List<DishesDTO> list = dishesService.list();
        List<Material> mList = materialService.list();
        map.put("list",list);
        map.put("mlist",mList);
        return "admin_dishes_list";
    }


    //添加菜单
    @RequestMapping("admin_dishes_add")
    public String addDishes(HttpServletRequest request, Dishes dishes, @RequestParam("file") MultipartFile file) throws Exception{

        if(!file.isEmpty()) {
            //上传文件路径
            String s = request.getContextPath();
            String path = request.getRealPath("/img/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            dishes.setImg("img/"+File.separator+filename);
        }

        dishes.setNum(0);
        dishesService.addDishes(dishes);
        return "forward:/admin_dishes_list";
    }

    //删除菜单
    @RequestMapping("admin_dishes_del")
    public String delDishes(int id){
        dishesService.delDeshes(id);
        return "forward:/admin_dishes_list";
    }

    //食材列表
    @RequestMapping("admin_material_list")
    public String meterialList(Map map){
        List<Material> list = materialService.list();
        map.put("list",list);
        return "admin_material_list";
    }

    //进货
    @RequestMapping("admin_material_add")
    public String addMaterial(Material material){
        materialService.add(material);
        return "forward:/admin_material_list";
    }

    //退货
    @RequestMapping("admin_material_sub")
    public String subMaterial(int id,int num){
        materialService.sub(id,num);
        return "forward:/admin_material_list";
    }

    //收银统计
    @RequestMapping("admin_shouyin_list")
    public String shouyin(Map map){
        List<AmountDTO> list = ordersService.shouyin();
        map.put("list",list);
        return "admin_shouyin_list";
    }

    //菜品统计
    @RequestMapping("admin_dishesTongji_list")
    public String dishesTongji(Map map){
        List<DishesCountDTO> list = ordersService.dishesTongji();
        map.put("list",list);
        return "admin_dishesTongji_list";
    }

}
