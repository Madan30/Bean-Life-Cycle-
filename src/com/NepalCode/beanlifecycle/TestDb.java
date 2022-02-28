package com.NepalCode.beanlifecycle;

import java.sql.SQLException;

public class TestDb {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		StudentDao dao = new StudentDao();
		dao.selectAllRows();
		dao.deleteStudentRecord(2);

	}

}
