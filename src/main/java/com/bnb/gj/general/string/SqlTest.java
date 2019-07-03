package com.bnb.gj.general.string;

public class SqlTest {
	
	private static final String DAY_CLOSER_QUERY = "SELECT dc.start_date FROM tb_day_closer dc where dc.status = 'ON' and dc.store_id = '%s'";
	private static final String DAY_CLOSER_CURRENT_QUERY = "BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 'ON' and dc.store_id = '%s' ) AND NOW()";
	
	
	static String sql = "\r\n" + 
			"CREATE PROCEDURE hotelwiki.usp_daily_dashboard_report(\r\n" + 
			"IN STORE_ID VARCHAR(200),\r\n" + 
			"OUT LIQUOR_AMT DECIMAL(20,2),\r\n" + 
			"OUT FOOD_AMT DECIMAL(20,2)\r\n" + 
			")\r\n" + 
			"BEGIN\r\n" + 
			"\r\n" + 
			"	SELECT FL.TOTAL_PRICE INTO FOOD_AMT\r\n" + 
			"	FROM (\r\n" + 
			"	Select A.ITEM_NAME, COUNT(*) AS COUNT, SUM(A.SELLING_PRICE) AS TOTAL_PRICE, A.REAL_NAME\r\n" + 
			"	from\r\n" + 
			"	(\r\n" + 
			"	SELECT OI.NAME AS ITEM_NAME, PRD.SELLING_PRICE, CAT.PARENT_ID AS MAIN_CATEGORY_ID,OI.CREATED_DATE, CAT.REAL_NAME, CAT.STORE_ID\r\n" + 
			"	FROM tb_order_item OI\r\n" + 
			"	JOIN  tb_store_menu_item PRD ON (OI.STORE_MENU_ITEM_ID=PRD.ID)\r\n" + 
			"	JOIN tb_category CAT ON (CAT.ID = PRD.MAIN_PARENT_CATEGORY_ID)\r\n" + 
			"	) A \r\n" + 
			"	WHERE A.REAL_NAME = 'FOOD' AND A.STORE_ID = STORE_ID \r\n" + 
			"	AND ( A.CREATED_DATE BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 'ON' and dc.store_id = STORE_ID ) AND NOW() )\r\n" + 
			"	GROUP BY A.REAL_NAME) FL;\r\n" + 
			"		\r\n" + 
			"	SELECT FL.TOTAL_PRICE INTO LIQUOR_AMT\r\n" + 
			"	FROM (\r\n" + 
			"	Select A.ITEM_NAME, COUNT(*) AS COUNT, SUM(A.SELLING_PRICE) AS TOTAL_PRICE, A.REAL_NAME\r\n" + 
			"	from\r\n" + 
			"	(\r\n" + 
			"	SELECT OI.NAME AS ITEM_NAME, PRD.SELLING_PRICE, CAT.PARENT_ID AS MAIN_CATEGORY_ID,OI.CREATED_DATE, CAT.REAL_NAME, CAT.STORE_ID\r\n" + 
			"	FROM tb_order_item OI\r\n" + 
			"	JOIN  tb_store_menu_item PRD ON (OI.STORE_MENU_ITEM_ID=PRD.ID)\r\n" + 
			"	JOIN tb_category CAT ON (CAT.ID = PRD.MAIN_PARENT_CATEGORY_ID)\r\n" + 
			"	) A \r\n" + 
			"	WHERE A.REAL_NAME = 'LIQUOR' AND A.STORE_ID = STORE_ID  \r\n" + 
			"	AND ( A.CREATED_DATE BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 'ON' and dc.store_id = STORE_ID ) AND NOW() )\r\n" + 
			"	GROUP BY A.REAL_NAME) FL;\r\n" + 
			"		\r\n" + 
			"		\r\n" + 
			"		SELECT LIQUOR_AMT \r\n" + 
			"		,	 FOOD_AMT;\r\n" + 
			"\r\n" + 
			"END;";
	
	
	static String sqlQuery = "select cat.real_name, sum(oi.selling_price) "
			+ "from tb_order_item oi , tb_store_menu_item smi ,tb_category cat " + 
			"where oi.CREATED_DATE %s " + 
			"AND smi.store_id = '%s' " +
			"AND cat.parent_id is null " + 
			"AND smi.id = oi.store_menu_item_id " + 
			"AND smi.main_parent_category_id = cat.id " + 
			"GROUP BY cat.real_name " ;

	public static void main(String[] args) {
		
		var storeId = "328ecb4b-dbc0-41d8-a99e-e33dddf75cbe";
		String sql = String.format(sqlQuery, String.format(DAY_CLOSER_CURRENT_QUERY, storeId), storeId);
		
		System.out.println("sql >>> \n"+sql); 

	}

}
