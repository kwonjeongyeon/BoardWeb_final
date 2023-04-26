package com.myspring.biz.common;

import java.sql.Connection; //특정 데이터베이스와의 연결(세션), SQL 문이 실행되고 연결 컨텍스트 내에서 결과가 반환
import java.sql.DriverManager; //JDBC 드라이버 세트를 관리하기 위한 기본 서비스
import java.sql.PreparedStatement; //미리 컴파일된 SQL 문을 나타내는 개체
import java.sql.ResultSet; //데이터베이스 결과 집합을 나타내는 데이터 테이블, 일반적으로 데이터베이스를 쿼리하는 문을 실행하여 생성

//데이터베이스 연동 처리 (DAO 클래스에서 공통으로 사용하여 connection 획득과 해제 작업 처리)
public class JDBCUtil {
	public static Connection getConnection() {

		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if (stmt != null) {
			try {
				if (!stmt.isClosed()) {
					stmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}

}
