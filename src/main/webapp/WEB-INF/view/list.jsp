<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/index.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
</head>
<body>
	<table >
		<tr>
			<td><input type="checkbox" id="ch"></td>
			<td>影片名</td>
			<td>导演</td>
			<td>票价</td>
			<td id ="t1" ondblclick="px1()">上映时间</td>
			<td id ="t2" ondblclick="px2()">时长</td>
			<td>类型</td>
			<td id ="t3" ondblclick="px3()">年代</td>
			<td>区域</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="m">
			<tr>
				<td><input type="checkbox" class="ch" value="${m.id }"></td>
				<td>${m.name }</td>
				<td>${m.author }</td>
				<td>${m.price }</td>
				<td>
					<fmt:formatDate value="${m.created }" pattern="yyyy-MM-dd"/>
				</td>
				<td>${m.time }</td>
				<td>${m.type }</td>
				<td>${m.y.year }</td>
				<td>${m.address }</td>
				<td id="${m.id }td">${m.zhuangtai==1? "正在热映":"已经下架" }</td>
				<td><input type="button" id="${m.id }" value="下架" onclick="upDate(${m.id },${m.zhuangtai})"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="100">
				第${page.pageNum }/${page.pages }共${page.total }条数据
				<input type="button" value="首页" onclick="page(1)">
				<input type="button" value="上一页" onclick="page(${page.prePage })">
				<input type="button" value="下一页" onclick="page(${page.nextPage })">
				<input type="button" value="尾页" onclick="page(${page.pages })">
				
				
			</td>
		</tr>
		<tr>
			<td colspan="100">
				<input type="button" value="批量删除" onclick="del()">
				<input type="button" value="查询影片" onclick="selects()">
			</td>
		</tr>
	</table>
 	<form action="getList" id = "form1" method="post"></form>
</body>

<script type="text/javascript">
	
	
	//排序
	//1为逆序2为正序
	function px1() {
		var px ='${px1}'
		if(px==1){
			location ="/getList?px1="+2;
		}else{
			location ="/getList?px1="+1;
		}
		
	}
	function px2() {
		var px ='${px2}'
		if(px==1){
			location ="/getList?px2="+2;
		}else{
			location ="/getList?px2="+1;
		}
	}

	function px3() {
		var px ='${px3}'
		if(px==1){
			location ="/getList?px3="+2;
		}else{
			location ="/getList?px3="+1;
		}
	}








	//下架
	function upDate(id,zhuangtai){
		$("#"+id).val("上架")
		$("#"+id+"td").html("已经下架")
		zhuangtai=2;
		
		//alert(id+"::"+zhuangtai)
		$.ajax({
			url:"/update",
			data:{id:id,zhuangtai:zhuangtai},
			type:"post",
			success:function(msg){
				if(msg>0){
					
					$("#"+id).click(function(){
						$("#"+id+"td").html("正在热销")
					})
				}
			}
		})
	}



	//分页
	function page(cur) {
		location = "/getList?cur="+cur
	}
	
	
	
	//全选反选
	$("#ch").click(function(){
		$(".ch").each(function(){
			this.checked=$("#ch")[0].checked;
		})
	})

	//批量删除
	function del(){
		var ids = $(".ch:checked").map(function(){
			return this.value
		}).get().join(",")
		alert(ids)		
		
		$.ajax({
			url:"/del",
			data:{ids:ids},
			type:"post",
			success:function(msg){
				if(msg>0){
					alert("删除成功")
					location="/getList";
				}else{
					alert("删除失败")
				}
			}
		})
	}
	//追加查询
	function selects() {
		
		
		var s = "<table>"+
			"<tr>"+
		"<td>影片名称:<input type='text' name='name'></td>"+
		"<td>上映时间:<input type='date' name='sdate'>-<input type='date' name=edate></td>"+
	"</tr>"+
	"<tr>"+
		"<td>导演:<input type='text'name='author'></td>"+
		"<td>价格:<input type='text'name='sprice'>-<input type='text'name='eprice'></td>"+
	"</tr>"+
	"<tr>"+
		"<td>"+
			"年代:"+
			"<select name='year'>"+
				"<option value=''>"+"请选择"+"</option>"+
				"<option value='1'>"+2018+"</option>"+
				"<option value='2'>"+2019+"</option>"+
				"<option value='3'>"+2020+"</option>"+
				"<option value='4'>"+2021+"</option>"+
			"</select>"+
		"</td>"+
		"<td>电影时长:<input type='text' name='stime'>-<input type='text' name='etime'></td>"+
	"</tr>"+
	"<tr><td colspan='100'><input type='submit' value='查询'></td> </tr>"
"</table>";
		
		$("#form1").append(s)
	}
	

</script>

</html>