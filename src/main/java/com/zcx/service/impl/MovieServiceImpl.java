package com.zcx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zcx.dao.MovieDao;
import com.zcx.domain.Movie;
import com.zcx.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Resource
	private MovieDao dao;
	
	
	@Override
	public List<Movie> getList(String name, String author, String screated, String ecreated, String year, String sprice, String eprice, String stime, String etime
			,String px1, String px2, String px3
			
			) {
		// TODO Auto-generated method stub
		return dao.getList(name,author,screated,ecreated,year,sprice,eprice,stime,etime,px1,px2,px3);
	}

	@Override
	public int del(String ids) {
		// TODO Auto-generated method stub
		return dao.del(ids);
	}

	@Override
	public int update(String id, String zhuangtai) {
		if(zhuangtai.equals("1")) {
			zhuangtai="2";
		}
		if(zhuangtai.equals("2")) {
			zhuangtai="1";
		}
		return dao.update(id,zhuangtai);
	}


}
