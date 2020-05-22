package com.bnb.gj.general.string;

public class SqlTest {
	
	private static final String DAY_CLOSER_QUERY = "SELECT dc.start_date FROM tb_day_closer dc where dc.status = 'ON' and dc.store_id = '%s'";
	private static final String DAY_CLOSER_CURRENT_QUERY = "BETWEEN (select dc.start_date from tb_day_closer dc where dc.status = 'ON' and dc.store_id = '%s' ) AND NOW()";
	
	static String ex_query =" SELECT * FROM ( SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow, IF(BR IS NULL , GR,BR)    AS MIN ,hotelName AS NAME,id  FROM (  \n" +
            "                                                 SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR   \n" +
            "                                                 FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
            "\t\t\t\t\t\t\tSELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date, RANK() OVER (PARTITION BY h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
            "                                                                         FROM rm_rates r    \n" +
            "                                                                         INNER JOIN hotels h ON (h.rm_code=r.hotel_code)       \n" +
            "                                                                         INNER JOIN clients_competitors cc ON (h.id=cc.hotel_id)     \n" +
            "                                                                         INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n" +
            "                                                                         INNER JOIN otas o ON otam.ota_id = o.id    \n" +
            "                                                                         WHERE  cc.client_id=  :clientId AND r.onsite_rate > 0  AND checkin_date BETWEEN :startDate AND  :endDate  ) F     \n" +
            "                                                                         WHERE RowNumberRank =1                                                            \n" +
            "                                                                         GROUP BY hotelName, otaName, checkin_date, rate_date ,id \n" +
            "                                                                         ORDER BY rate_date) AS B  GROUP BY  hotelName,checkin_date,id\n" +
            "                                                                          ) final    \n" +
            "                                                 UNION      \n" +
            "                                                 SELECT  checkin_date AS occupancyDate,DATE_FORMAT(checkin_date, '%a') AS dow, IF(BR IS NULL , GR,BR)    AS MIN ,hotelName AS NAME ,id FROM (  \n" +
            "                                                SELECT  id,hotelName,checkin_date,GROUP_CONCAT(IF(otaName='BOOKING.COM',minrate,NULL)) AS BR,SUBSTRING_INDEX(GROUP_CONCAT( IF(otaName<>'BOOKING.COM',minrate,NULL) ORDER BY minrate ASC),',',1) AS GR  \n" +
            "                                                 FROM (SELECT id, hotelName, otaName,checkin_date, MIN(onsite_rate) AS minRate, rate_date  FROM (\n" +
            "\t\t\t\t\t\t\tSELECT h.id,h.name AS hotelName, o.domain_name AS otaName, r.checkin_date, r.onsite_rate , r.rate_date, RANK() OVER (PARTITION BY h.name,r.checkin_date ORDER BY date_collected DESC)AS RowNumberRank \n" +
            "                                                                         FROM rm_rates r \n" +
            "\t\t\t\t\t\t\t\t\tINNER JOIN hotels h ON (h.rm_code=r.hotel_code) \n" +

            "                                                                         INNER JOIN clients c ON (h.id = c.hotel_id)  \n" +
            "                                                                         INNER JOIN ota_mappings otam ON (r.ota_id=otam.id) \n" +
            "                                                                         JOIN otas o ON otam.ota_id = o.id    \n" +
            "                                                                         WHERE   c.id= :clientId AND r.onsite_rate > 0 AND checkin_date BETWEEN :startDate AND  :endDate ) F     \n" +
            "                                                                         WHERE RowNumberRank =1                                                            \n" +
            "                                                                         GROUP BY hotelName, otaName, checkin_date, rate_date ,id \n" +
            "                                                                         ORDER BY rate_date) AS B   GROUP BY  hotelName,checkin_date,id\n" +
            "                                                                         \n" +
            "                                                                         \n" +
            "                                                                       ) final  ) DATA ORDER BY occupancyDate, FIELD(NAME,:clientName) DESC";
	
	
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
	
	static String a=  "select  msd.ms_date, IFNULL(sum(r.food_amount),0.00) as food_amount , IFNULL(sum(r.beverage_amount),0.00) as beverage_amount , IFNULL(sum(r.liquir_amount),0.00) as liquir_amount " + 
			"FROM ms_date msd left join tx_receipt r on msd.ms_date = date(r.closing_date) and r.store_id = :storeId " + 
			"where date(msd.ms_date) between :fromDate and :toDate " + 
			"group by date(msd.ms_date) order by msd.ms_date ";

	public static void main(String[] args) {
		
		var storeId = "328ecb4b-dbc0-41d8-a99e-e33dddf75cbe";
		String sql = String.format(sqlQuery, String.format(DAY_CLOSER_CURRENT_QUERY, storeId), storeId);
		
		System.out.println("sql >>> \n"+ex_query); 

	}

}
