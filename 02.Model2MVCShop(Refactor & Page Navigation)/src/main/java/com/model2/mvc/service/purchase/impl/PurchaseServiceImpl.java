package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}
	
	public void addPurchase(PurchaseVO purchaseVO) throws Exception{
		purchaseDAO.insertPurchase(purchaseVO);
	}
	
	public PurchaseVO getPurchase(int tranNo) throws Exception{
		return purchaseDAO.findPurchase(tranNo);
	}
	
	public HashMap<String, Object> getPurchaseList(SearchVO searchVO, String tranCode) throws Exception{
		return purchaseDAO.getPurchaseList(searchVO, tranCode);
	}
	
	
	public PurchaseVO updatePurchase(PurchaseVO purchaseVO) throws Exception{
		purchaseDAO.updatePurchase(purchaseVO);
		return purchaseVO;
	}
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception{
		purchaseDAO.updateTranCode(purchaseVO);
	}
	
}
