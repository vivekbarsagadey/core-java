package com.bnb.gj.general;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import com.bnb.gj.general.test.DatabaseDAO;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
	@Rule
	public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when(databaseDAO.save("temp.txt")).thenReturn(true);
	}

	@Mock
	DatabaseDAO databaseDAO;

	@Test
	public void saveTest() {
		boolean saved = databaseDAO.save("temp.txt");
		assertEquals(true, saved);
		
	}
}
