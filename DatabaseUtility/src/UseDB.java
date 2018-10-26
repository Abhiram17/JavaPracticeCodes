
public class UseDB {

	public static void main(String[] args) {
		String query = "CREATE TABLE STUDENTS(student_id INTEGER, student_fname VARCHAR(20),student_lname VARCHAR(20))";
		String query1 = "INSERT INTO STUDENTS VALUES(1,'Abi','Ram')";
		DBUtility db = new DBUtility("TEST");
		db.DBCreateTable(query);
		db.DBInsertTable(query1);
		db.DBReadTable("STUDENTS");
		
		

	}

}
