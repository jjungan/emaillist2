package com.sds.icto.emaillist.test;

import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class EmailListDaoTest {
	public static void main(String[] args) {
		try {
//			testDeleteById();
			testDelete();
			testInsert();
			testFetchList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void testDeleteById() throws Exception{
		EmailListDao dao = new EmailListDao();
		dao.delete(3L);
	}
	public static void testDelete() throws Exception{
		System.out.println(1);
		EmailListDao dao = new EmailListDao();
		System.out.println(2);
		dao.delete();
		System.out.println(3);
	}
	
	public static void testFetchList() throws Exception{
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		for (EmailListVo email : list) {
			System.out.println(email);
		}
	}
	
	public static void testInsert() throws Exception{
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("aa");
		vo.setLastName("bb");
		vo.setEmail("aaa@bbb.ccc");
		
		EmailListDao dao = new EmailListDao();
		dao.insert(vo);
		
		vo.setFirstName("Jungan");
		vo.setLastName("Lee");
		vo.setEmail("aaa@bbb.ccc");
		
		dao.insert(vo);
		
	}

}
