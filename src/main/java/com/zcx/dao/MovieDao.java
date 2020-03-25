package com.zcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zcx.domain.Movie;

public interface MovieDao {
	/**
	 * 
	 * @param etime 
	 * @param stime 
	 * @param eprice 
	 * @param sprice 
	 * @param year 
	 * @param ecreated 
	 * @param screated 
	 * @param author 
	 * @param name 
	 * @param px3 
	 * @param px2 
	 * @param px1 
	 * @Title: getList 
	 * @Description: 查询列表
	 * @return
	 * @return: List<Movie>
	 */
	List<Movie> getList(@Param("name")String name,@Param("author") String author,
			@Param("screated")String screated, @Param("ecreated")String ecreated, 
			@Param("year")String year, @Param("sprice")String sprice, @Param("eprice")String eprice, 
			@Param("stime")String stime,@Param("etime") String etime, @Param("px1")String px1, @Param("px2")String px2,@Param("px3") String px3);
	/**
	 * 
	 * @Title: del 
	 * @Description: 批量删除
	 * @param ids
	 * @return
	 * @return: int
	 */
	int del(@Param("ids")String ids);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改状态
	 * @param id
	 * @param zhuangtai
	 * @return
	 * @return: int
	 */
	int update(@Param("id")String id, @Param("zhuangtai")String zhuangtai);


}
