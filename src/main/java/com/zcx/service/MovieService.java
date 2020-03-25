package com.zcx.service;

import java.util.List;

import com.zcx.domain.Movie;

public interface MovieService {

	List<Movie> getList(String name, String author, String screated, String ecreated, String year, String sprice, String eprice, String stime, String etime, String px1, String px2, String px3);

	int del(String ids);

	int update(String id, String zhuangtai);



}
