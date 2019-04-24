package dev.felipe.eletronicpoint.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import dev.felipe.eletronicpoint.utils.PasswordUtils;

public class PasswordUtilsTest {
	
	
	private static final String SENHA = "1234567";
	private final BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() throws Exception{
		
		assertNull(PasswordUtils.geraBCrypt(null));
	}
	@Test
	public void testSenhaHash() throws Exception{
		
		assertTrue(bEncoder.matches(SENHA, PasswordUtils.geraBCrypt(SENHA)));
	}

}
