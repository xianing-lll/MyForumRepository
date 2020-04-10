package cn.itcast.myforum.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.itcast.myforum.domain.Note;

class test {

	Notedao notedao=new Notedao();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws SQLException {
		List<Note> notes=notedao.findallNode(2, 3);
		for (Note note : notes) {
			System.out.println(note);
		}
	}

}
