package cn.gmluo.bebetterme.controller;

import cn.gmluo.bebetterme.entity.BeBetter;
import cn.gmluo.bebetterme.service.BeBetterService;
import cn.gmluo.bebetterme.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 4.控制层
 * 4.1Controller控制类实现
 * Created by gmluo on 2018/4/9.
 */
@Controller
@RequestMapping("/bebetterme")
public class BeBetterController {
    @Resource(name = "beBetterServiceImpl")
    private BeBetterService beBetterService;

    /**
     * 分页查询每日报告信息
     * @param pageIndex
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getReportsByPageIndex",method = RequestMethod.GET)
    public PageBean<BeBetter> getReportsByPageIndex(@RequestParam(value = "pageIndex") int pageIndex ){
        if (pageIndex<=0){
            pageIndex=1;
        }
        PageBean<BeBetter> pageBean=new PageBean<BeBetter>();
        pageBean.setCurrentPage(pageIndex);
        beBetterService.getAllReports(pageBean);
        return pageBean;
    }

    /**
     * 新增报告
     * @param beBetter
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saveReport",method = RequestMethod.POST)
    public String saveReport(@RequestBody BeBetter beBetter){
        beBetterService.saveReport(beBetter);
        return "success";
    }

    /**
     * 根据id删除报告
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteReport",method = RequestMethod.DELETE)
    public String deleteReport(@RequestParam(value = "id")int id){
        beBetterService.deleteReport(id);
        return "success";
    }

    /**
     * 修改报告
     * @param beBetter
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateReport",method = RequestMethod.POST)
    public String updateReport(@RequestBody BeBetter beBetter){
        beBetterService.uadateReport(beBetter);
        return "success";
    }

    /**
     * 根据id查询报告
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findReportById",method = RequestMethod.GET)
    public BeBetter findReportById(@RequestParam(value = "id")int id){
        return beBetterService.findById(id);
    }

}
