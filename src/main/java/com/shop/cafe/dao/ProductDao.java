package com.shop.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Repository
public class ProductDao {
	@Value("${spring.datasource.driver-class-name}")
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;

	// 예외 처리는 사용하는 쪽에서
	// 단, 원래 무슨 에러인지 구분해서 throws 해야 함
	public List<Product> getAllProducts() throws Exception { 
		/* JDBC 6단계 */
		
		// 1. 드라이버 등록
		Class.forName(DB_DRIVER);
		
		// 2. 연결
		String sql = "SELECT * FROM product";
		
		// try-with-resources (AutoClosable 자동으로 닫아줌)
		try(
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			
			// 3. Statement 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			// 4. SQL 전송
			ResultSet result = pstmt.executeQuery();
			
			// 5. 결과 받기	
			List<Product> list = new ArrayList<>();
			
			while (result.next()) {
				int code = result.getInt("prodCode");
				String name = result.getString("prodName");
				String img = result.getString("prodImg");
				int price = result.getInt("price");
				
				list.add(new Product(code, price, name, img));
			}	
			System.out.println(list);
			
			return list;
		}
	}
}
