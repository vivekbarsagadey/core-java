package com.bnb.gj.general.string;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class StringTest {

	public static void main(String[] args) {
		System.out.println(DateUtils.asLocalDate(new Date()));

		BigDecimal amtAfterTax = new BigDecimal(0);

		amtAfterTax.add(new BigDecimal(20));

		System.out.println(amtAfterTax);

		Locale list[] = SimpleDateFormat.getAvailableLocales();
		Set set = new TreeSet();
		for (int i = 0; i < list.length; i++) {
			//System.out.println(">>>>>>>>>>>>>>>");
			//System.out.println(list[i].getDisplayScript());
			//System.out.println("--------------------");
			for(var l : list[i].getISOLanguages()) {
				//System.out.println(l);
			}
			
			//System.out.println(list[i].getISOLanguages());
		}
		
		
		System.out.println(System.getProperty("user.language"));
		System.out.println(System.getProperty("user.country"));
		new StringTest().dd();
	}
	
	
	
	private void dd () {
		String sql = "CREATE PROCEDURE hotelwiki.usp_daily_dashboard_report(\n"
				+ "IN STORE_ID VARCHAR(200),\n" + "OUT LIQUOR_AMT DECIMAL(20,2),\n" + "OUT FOOD_AMT DECIMAL(20,2)\n"
				+ ")\n" + "BEGIN\n" + "\n" + "	SELECT FL.TOTAL_PRICE INTO FOOD_AMT\n" + "	FROM (\n"
				+ "	Select A.ITEM_NAME, COUNT(*) AS COUNT, SUM(A.SELLING_PRICE) AS TOTAL_PRICE, A.REAL_NAME\n"
				+ "	from\n" + "	(\n"
				+ "	SELECT OI.NAME AS ITEM_NAME, PRD.SELLING_PRICE, CAT.PARENT_ID AS MAIN_CATEGORY_ID,OI.CREATED_DATE AS CREATED_DATE, CAT.REAL_NAME, CAT.STORE_ID\n"
				+ "	FROM tb_order_item OI\n"
				+ "	JOIN  tb_store_menu_item PRD ON (OI.STORE_MENU_ITEM_ID=PRD.ID)\n"
				+ "	JOIN tb_category CAT ON (CAT.ID = PRD.MAIN_PARENT_CATEGORY_ID)\n" + "	) A \n"
				+ "	WHERE A.REAL_NAME = 'FOOD' AND A.STORE_ID = STORE_ID \n"
				+ "	AND A.CREATED_DATE BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 0 and dc.store_id = STORE_ID ) AND NOW() )\n"
				+ "	GROUP BY A.REAL_NAME) FL;\n" + "		\n" + "	SELECT FL.TOTAL_PRICE INTO LIQUOR_AMT\n"
				+ "	FROM (\n"
				+ "	Select A.ITEM_NAME, COUNT(*) AS COUNT, SUM(A.SELLING_PRICE) AS TOTAL_PRICE, A.REAL_NAME\n"
				+ "	from\n" + "	(\n"
				+ "	SELECT OI.NAME AS ITEM_NAME, PRD.SELLING_PRICE, CAT.PARENT_ID AS MAIN_CATEGORY_ID,OI.CREATED_DATE AS CREATED_DATE, CAT.REAL_NAME, CAT.STORE_ID\n"
				+ "	FROM tb_order_item OI\n"
				+ "	JOIN  tb_store_menu_item PRD ON (OI.STORE_MENU_ITEM_ID=PRD.ID)\n"
				+ "	JOIN tb_category CAT ON (CAT.ID = PRD.MAIN_PARENT_CATEGORY_ID)\n" + "	) A \n"
				+ "	WHERE A.REAL_NAME = 'LIQUOR' AND A.STORE_ID = STORE_ID  \n"
				+ "	AND A.CREATED_DATE BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 0 and dc.store_id = STORE_ID ) AND NOW())\n"
				+ "	GROUP BY A.REAL_NAME) FL;\n" + "		\n" + "		\n" + "		SELECT LIQUOR_AMT \n"
				+ "		,	 FOOD_AMT;\n" + "\n" + "END";
		
		System.out.println(sql);
	}

}
