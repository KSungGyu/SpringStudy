package kr.bit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.jdbc.log.Log;

import kr.bit.entity.Board;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	BoardMapper boardMapper;
	
	@Test
	/*
	public void testGetList() {
		List<Board> list=boardMapper.getList();
		for(Board vo : list) {
			System.out.println(vo);
			
		}
	}*/
	/*public void testInsert() {
		Board vo=new Board();
		vo.setMemID("bit01");
		vo.setTitle("A");
		vo.setContent("�����ۼ��� ��");
		vo.setWriter("������");
		boardMapper.insert(vo);
		log.info(vo);
	}*/
	public void testInsert() {
		Board vo=new Board();
		vo.setMemID("bit03");
		vo.setTitle("C");
		vo.setContent("�����ۼ��� ��");
		vo.setWriter("ȫ�浿");
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
}
