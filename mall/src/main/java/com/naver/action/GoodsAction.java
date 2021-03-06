package com.naver.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.dao.GoodsDAO;
import com.naver.model.GoodsBean;

@Controller
public class GoodsAction {
	private GoodsDAO goodsService;

	public void setGoodsService(GoodsDAO goodsService) {
		this.goodsService = goodsService;
	}
	
	
	@RequestMapping(value="/GoodsList.do")
	public String goods_list(HttpServletRequest request, 
			                 HttpServletResponse response){
		
		List<GoodsBean> goodsList=null;
		
		GoodsBean gb=new GoodsBean();
		
		System.out.println("here");
		int count=1;
		int page=1;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		String category= request.getParameter("category");
		String level="";
		
		if(request.getParameter("searchCategory")==null||request.getParameter("searchCategory").equals("")){
			goodsList =this.goodsService.getGoodsList(gb);
		}else{
			category=request.getParameter("searchCategory");
		}
		
		int pageSize=12;
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		int startPage=(int)((page-1)/10)*10+1;
		int endPage=startPage+10-1;
		if(endPage>pageCount) endPage=pageCount;
		
		request.setAttribute("goodsList",goodsList);
		request.setAttribute("category", category);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

	
		return "/goods/goods_list";	
		
	}
		

	
}
