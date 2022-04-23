package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public interface PurchaseService {
	
	public void addPurchase(PurchaseVO purchaseVO) throws Exception; // ���� ���
	
	public PurchaseVO getPurchase(int tranNo) throws Exception; // �������� ����ȸ
	
	public HashMap<String, Object> getPurchaseList(Search searchVO, String tranCode) throws Exception; // ���� ��� ����
		
	public PurchaseVO updatePurchase(PurchaseVO purchaseVO) throws Exception; // ���� ���� ����
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception; // ���� ���� ����

}