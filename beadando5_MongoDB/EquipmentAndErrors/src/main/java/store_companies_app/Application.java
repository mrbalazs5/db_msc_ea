package store_companies_app;

import java.util.Date;
import java.util.Iterator;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Application {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			DB database = mongoClient.getDB("db_msc");
			
			DBCollection equipmentsCollection = database.getCollection("equipments");
			DBCollection errorLogsCollection = database.getCollection("error_logs");
			
			// insert
			
			/*BasicDBObject equipment1 = new BasicDBObject();
			equipment1.put("_id", 1);
			equipment1.put("name", "kalapács");
			equipment1.put("units", 4);
			
			BasicDBObject equipment2 = new BasicDBObject();
			equipment2.put("_id", 2);
			equipment2.put("name", "szög");
			equipment2.put("units", 150);
		
			BasicDBObject equipment3 = new BasicDBObject();
			equipment3.put("_id", 3);
			equipment3.put("name", "deszka");
			equipment3.put("units", 35);
			
			BasicDBObject equipment4 = new BasicDBObject();
			equipment4.put("_id", 4);
			equipment4.put("name", "fúró");
			equipment4.put("units", 3);
			
			equipmentsCollection.insert(equipment1);
			equipmentsCollection.insert(equipment2);
			equipmentsCollection.insert(equipment3);
			equipmentsCollection.insert(equipment4);
			
			BasicDBObject errorLog1 = new BasicDBObject();
			errorLog1.put("_id", 5);
			errorLog1.put("message", "Készlet hiány!");
			errorLog1.put("createDate", new Date());
			
			BasicDBObject errorLog2 = new BasicDBObject();
			errorLog2.put("_id", 6);
			errorLog2.put("message", "Ember hiány!");
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
			Date date = ft.parse("2021-05-01");
			errorLog2.put("createDate", date);
			
			BasicDBObject errorLog3 = new BasicDBObject();
			errorLog3.put("_id", 7);
			errorLog3.put("message", "Behatoló!");
			errorLog3.put("createDate", new Date());
			
			errorLogsCollection.insert(errorLog1);
			errorLogsCollection.insert(errorLog2);
			errorLogsCollection.insert(errorLog3);*/
			
			// update
			DBObject baseEquipment = new BasicDBObject();
			baseEquipment.put("_id", 1);
			DBObject updateEquipment = new BasicDBObject();
			DBObject updatedEquipment = new BasicDBObject();
			updatedEquipment.put("name", "hordó");
			updatedEquipment.put("units", 50);
			updateEquipment.put("$set", updatedEquipment);
			equipmentsCollection.update(baseEquipment, updateEquipment);
			
			DBObject baseErrorLog = new BasicDBObject();
			baseErrorLog.put("_id", 6);
			DBObject updateErrorLog = new BasicDBObject();
			DBObject updatedErrorLog = new BasicDBObject();
			updatedErrorLog.put("message", "Kalapács hiány!");
			updatedErrorLog.put("date", new Date());
			updateErrorLog.put("$set", updatedErrorLog);
			errorLogsCollection.update(baseErrorLog, updateErrorLog);
			
			// delete
			DBObject equipmentToDelete = new BasicDBObject();
			equipmentToDelete.put("_id", 3);
			equipmentsCollection.remove(equipmentToDelete);
			
			DBObject errorLogToDelete = new BasicDBObject();
			errorLogToDelete.put("_id", 5);
			errorLogsCollection.remove(errorLogToDelete);
			
			// query
			Iterator<DBObject> it;
			
			// 60 egységnél többel rendelkezõ felszerelések
			DBCursor q1 = equipmentsCollection.find(
					new BasicDBObject(
							"units",
							new BasicDBObject("$gt", 60)
                    )
			);
			
			it =  q1.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			System.out.println("\n");
			
			// error logok a mai napig
			DBCursor q2 = errorLogsCollection.find(
					new BasicDBObject(
							"date",
							new BasicDBObject("$lt", new Date())
                    )
			);
			
			it =  q2.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			
			System.out.println("\n");
			
			// legkevesebb egységgel rendelkezõ felszerelések (csak frissebb driverrel mûködik)
			/*BasicDBObject aggregateContent =  new BasicDBObject();
			aggregateContent.put("_id", null);
			aggregateContent.put("min", new BasicDBObject("$min", "$units"));
			Iterable<DBObject> q3 = equipmentsCollection.aggregate(
					Arrays.asList((DBObject) new BasicDBObject("$group", aggregateContent))
			).results();
			
			it = q3.iterator();
			
			while(it.hasNext()) {
				System.out.println(it.next());
			}*/
			// 100 egységnél kevesebbel rendelkezõ felszerelések száma
			int q4 = equipmentsCollection.find(
					new BasicDBObject(
							"units",
							new BasicDBObject("$lt", 100)
                    )
			).count();
			
			System.out.println(q4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
