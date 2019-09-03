package com.jevons.controller;

import com.github.pagehelper.PageInfo;
import com.jevons.dto.AppInfoDTO;
import com.jevons.pojo.AppCategory;
import com.jevons.pojo.AppInfo;
import com.jevons.pojo.DataDictionary;
import com.jevons.pojo.DevUser;
import com.jevons.service.AppCategoryService;
import com.jevons.service.AppInfoService;
import com.jevons.service.DataDictionatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/app")
public class DevAppController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionatyService dataDictionatyService;

    @Autowired
    private AppCategoryService appCategoryService;

    @RequestMapping("/index/devId/{id}")
    public String index(@PathVariable("id")Long id, Model model, HttpSession session){


        session.setAttribute("USER_ID",id);

        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        pageInfo = appInfoService.queryByDevUserId(id,pageInfo);
        //查询所有的平台
        List<DataDictionary> appFlatforms = appInfoService.queryAllAppFlatforms();

        //查询所有的app状态
        List<DataDictionary> appStatuses = appInfoService.queryAllAppAtatus();

        //查询所有的一级分类
        List<AppCategory> levelOne = appCategoryService.queryAllLevelOne();

        model.addAttribute("page",pageInfo);
        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        return "app/index";
    }


    @RequestMapping("/query")
    public String query(AppInfoDTO appInfoDTO,Model model,HttpSession session){

        Object obj = session.getAttribute("USER_ID");
        if (obj!=null){
            long userId = (long) obj;
           /* if (appInfoDTO == null){
                appInfoDTO = new AppInfoDTO();
                appInfoDTO.setPageNum(1);
            }*/
            appInfoDTO.setDevUserId(userId);
            PageInfo<AppInfo> pageInfo = appInfoService.query(appInfoDTO);

            //查询所有的平台
            List<DataDictionary> appFlatforms = appInfoService.queryAllAppFlatforms();

            //查询所有的app状态
            List<DataDictionary> appStatuses = appInfoService.queryAllAppAtatus();

            //查询所有的一级分类
            List<AppCategory> levelOne = appCategoryService.queryAllLevelOne();

            model.addAttribute("appFlatforms",appFlatforms);
            model.addAttribute("appStatuses",appStatuses);
            model.addAttribute("levelOne",levelOne);
            model.addAttribute("page",pageInfo);
            model.addAttribute("appInfoDTO",appInfoDTO);
            return "app/index";

        }else {
            return "redirect:/";
        }
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){

        //查询所有的app状态
        List<DataDictionary> appStatuses = appInfoService.queryAllAppAtatus();
        //查询所有的一级分类
        List<AppCategory> levelOne = appCategoryService.queryAllLevelOne();
        //查询所有的平台
        List<DataDictionary> appFlatforms = appInfoService.queryAllAppFlatforms();

        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        model.addAttribute("appFlatforms",appFlatforms);
        return "app/add";
    }

    @RequestMapping("/add")
    public String add(AppInfo appInfo,Model model,HttpSession session){
        Object id = session.getAttribute("USER_ID");
        long userId = Long.parseLong(id.toString());

        boolean flag = appInfoService.add(appInfo,userId);

        //转发到action
        return "redirect:/app/index/devId/" + userId;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model,HttpSession session){

        Object uid = session.getAttribute("USER_ID");
        long userId = Long.parseLong(uid.toString());
        boolean flag = appInfoService.delete(id);

        return "redirect:/app/index/devId/" + userId;
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id,Model model,HttpSession session){

        AppInfo appInfo = appInfoService.queryById(id);
        //查询所有的app状态
        List<DataDictionary> appStatuses = appInfoService.queryAllAppAtatus();
        //查询所有的一级分类
        List<AppCategory> levelOne = appCategoryService.queryAllLevelOne();
        //查询所有的平台
        List<DataDictionary> appFlatforms = appInfoService.queryAllAppFlatforms();

        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("app",appInfo);
        System.out.println(appInfo.getApkName());

       return "app/edit";

    }

    @RequestMapping("/edit")
    public String edit(AppInfo appInfo,Model model,HttpSession session){
        Object uid = session.getAttribute("USER_ID");
        Long userId = Long.parseLong(uid.toString());
        DevUser devUser = new DevUser();
        devUser.setId(userId);
        appInfo.setCreateUser(devUser);
        appInfo.setModifyUser(devUser);
        appInfo.setDevUser(devUser);
        appInfoService.update(appInfo);
        return "redirect:/app/query";
    }


    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable("id") Long id,Model model) {
        AppInfo app = appInfoService.queryDetailById(id);
        model.addAttribute("app",app);
        return "app/appDetail";
    }

}
