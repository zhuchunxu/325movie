package com.zcx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zcx.domain.Movie;
import com.zcx.service.MovieService;

@Controller
public class MovieController {
	@Resource
	private MovieService service;
	/**
	 * 
	 * @Title: getList 
	 * @Description: 查询列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("getList")
	public String getList(Model model,@RequestParam(defaultValue = "1") int cur,
			@RequestParam(defaultValue="",name = "name") String name,@RequestParam(defaultValue="",name ="author") String author,
			@RequestParam(defaultValue="",name ="year") String year,@RequestParam(defaultValue="",name ="screated") String screated,
			@RequestParam(defaultValue="",name ="ecreated") String ecreated,@RequestParam(defaultValue="",name ="sprice") String sprice,
			@RequestParam(defaultValue="",name ="eprice") String eprice,@RequestParam(defaultValue="",name ="stime") String stime,
			@RequestParam(defaultValue="",name ="etime") String etime,@RequestParam(defaultValue="",name ="px1") String px1,
			@RequestParam(defaultValue="",name ="px2") String px2,@RequestParam(defaultValue="",name ="px3") String px3
			) {
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(cur, 3);
		List<Movie> list = service.getList(
				name,author,screated,ecreated,year,sprice,eprice,stime,etime,px1,px2,px3
				);
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("list", list);
		model.addAttribute("page", pageInfo);
		model.addAttribute("px1",px1);
		model.addAttribute("px2",px2);
		model.addAttribute("px3",px3);
		return "list";
	}
	/**
	 * 
	 * @Title: del 
	 * @Description: ajax批量删除
	 * @param ids
	 * @return
	 * @return: int
	 */
	@RequestMapping("del")
	@ResponseBody
	public int del(String ids) {
		
		return service.del(ids);
	}
	/**
	 * 
	 */
	@RequestMapping("/update")
	@ResponseBody
	public int update(@RequestParam("id")String id,@RequestParam("zhuangtai")String zhuangtai) {
		
		return service.update(id,zhuangtai);
	}
	
	
	
}
