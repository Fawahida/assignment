package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.beans.Account;
import com.cg.exceptions.Invalid_Account_Number_Exception;
import com.cg.repo.repo;
import com.cg.repo.repo_interfaces;

public class RepositoryTest 
{
	private static repo_interfaces repository;
	
	@BeforeAll
	public static void init()
	{
		repository = new repo (new HashMap<Integer, Account>());
	}
	
	@Test
	public void save_123_Name_300() throws Exception
	{
		Account account = new Account(123, "Name", 300);
		assertEquals (repository.save (account), account);
	}
	
	@Test
	public void save_negative_Name_300()
	{
		Account account = new Account(-123, "Name", 300);
		assertThrows (Invalid_Account_Number_Exception.class, () ->
		  {
			  repository.save (account);
		  });	
	}



}
