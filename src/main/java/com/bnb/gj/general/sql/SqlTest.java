package com.bnb.gj.general.sql;

public class SqlTest {
	
	
	private static String BookingPaceOccupancyByDate_findTrendByOtaAndDate=" SELECT DATE_FORMAT(db_date,'%b %Y') AS days,DATE_FORMAT(db_date,'%y%m') as daysOrder,NAME,CASE WHEN SUM(revenue) IS NULL THEN 0 ELSE SUM(revenue) END AS revenue \n" +
            "                        ,CASE WHEN SUM(rooms) IS NULL THEN 0 ELSE SUM(rooms) END AS rooms  FROM ( SELECT occupancy_date,NAME,  \n" +
            "                                                                            ROUND(SUM(rpd)) AS revenue,  \n" +
            "                                                                            SUM(obd.no_of_rooms) AS rooms FROM   \n" +
            "                                                                           `booking_pace_occupancy_by_date` obd  INNER JOIN bookings b ON (obd.booking_id=b.id) \n" +
            "                                                                            INNER JOIN ota_mappings otm  ON (otm.id=obd.ota_id)   \n" +
            "                                                                            INNER JOIN otas  ON (otas.id=otm.ota_id)  \n" +
            "                                                                           WHERE obd.client_id = :clientId AND occupancy_date >= :startDate  AND  occupancy_date <= :endDate  AND cm_status not in ('B','cancel')  \n" +
            "                                                                           GROUP BY  occupancy_date,NAME ) A  \n" +
            "                         RIGHT JOIN time_dimension td ON (td.db_date=A.occupancy_date) \n" +
            "                         WHERE   db_date >= :startDate  AND  db_date <= :endDate\n" +
            "                         GROUP BY  DATE_FORMAT(db_date,'%b %Y'),NAME,DATE_FORMAT(db_date,'%y%m')                                            \n" +
            "                         ORDER BY daysOrder ,NAME ";
	

	public static void main(String[] args) {
		//System.out.println(BOOKINGPACEOCCUPANCYBYDATE_FINDTRENDBYOTA);
		
		String sql = BookingPaceOccupancyByDate_findTrendByOtaAndDate;
		sql = sql.replaceAll(":clientId", "10");
		sql = sql.replaceAll(":startDate", "'2020-06-01'");
		sql = sql.replaceAll(":endDate", "'2020-06-30'");
		
		
		System.out.println(sql);
		
		

	}
	
	
}
