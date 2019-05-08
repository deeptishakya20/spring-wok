package com.capgemini.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.capgemini.bank.dao.BankAccountDao;
import com.capgemini.bank.exception.BankAccountNotFoundException;
import com.capgemini.bank.model.BankAccount;
import com.capgemini.bank.util.DbUtil;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;  
  
import org.springframework.transaction.annotation.*;

@Transactional
public class BankAccountDaoImpl implements BankAccountDao {

	
	private JdbcTemplate jdbcTemplate;

	
	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){

		this.jdbcTemplate = jdbcTemplate;

	}

	

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccounts ( customer_name, cutomer_type, account_balance) VALUES (accountHolderName , accountType , accountBalance)";
	//'"+account.getAccountHolderName()+"','"+account.getAccountType()+"','"+account.getAccountBalance()+"')";
		int result=jdbcTemplate.update(query);

		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance)throws BankAccountNotFoundException{
		
		String query = "UPDATE bankaccounts SET account_balance = '"+newBalance+"' WHERE account_id = '"+accountId+"'";
		try{
			int result = jdbcTemplate.update(query);
			if(result==1){
				System.out.println("No of rows update:" + result);
				return true;
			}
		}

		catch(Exception e){

			throw new BankAccountNotFoundException("account does not exist...");
		}
			
		return false;


	}

	@Override
	public double getBalance(long accountId){
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id = '"+accountId+"' ";
		double balance = jdbcTemplate.queryForObject(query, Double.class);
		
		return balance;
	}


	@Override
	public boolean deleteBankAccount(long accountId){

		String query = "DELETE FROM bankaccounts WHERE account_id = '"+accountId+"' ";
		int result = jdbcTemplate.update(query);
		if(result == 1)
			return true;
		else
			return false;

	}


	@Override 
	public boolean updateDetails(long accountId, String accountHolderName, String accountType){
		String query = "Update bankaccounts SET customer_name = '"+accountHolderName+"', cutomer_type = '"+accountType+"' WHERE account_id = '"+accountId+"' ";
		int result = jdbcTemplate.update(query);
		if(result != 0)
			return true;
		else
			return false;

	}


	@Override
	public List<BankAccount> findAllBankAccount() {
		String query = "SELECT * FROM bankaccounts";
		List <BankAccount> accounts = jdbcTemplate.query(query,(resultSet,rowNum)->{
			BankAccount account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
			return account;
		});
		return accounts;

	}

	
	@Override
	public List<BankAccount> searchBankAccount(long accountId) {
		String query = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;
		List<BankAccount> accounts = jdbcTemplate.query(query,(resultSet, rowNum)->{
			BankAccount account = new BankAccount(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4));
			return account;
		});

		return accounts;

	}

	/*public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccounts ( customer_name, cutomer_type, account_balance) VALUES (?,?,?)  ";

		int result;
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection()) {

			Object []param = new Object[3];
			param[0] = "accountHolderName";
			param[1] = "accountType";
			param[2] = "accountBalance";	
			
			result = jdbcTemplate.update(query, param);
			if (result == 1)
				return true;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


 
	@Override
	public void updateBalance(long accountId, double newBalance) throws SQLException {
		String query = "UPDATE bankaccounts SET account_balance = ? WHERE account_id=?";
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);

			int result = statement.executeUpdate();
			System.out.println("No of rows update:" + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	


	@Override
	public double getBalance(long accountId) {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id = " + accountId;
		double balance = -1;
		//Connection connection = DbUtil.getconnection();
		try ( Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {
			result.next();
			balance = result.getDouble(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}
	
	


	@Override
	public boolean deleteBankAccount(long accountId)  {
		String query = "DELETE FROM bankaccounts WHERE account_id= " + accountId;
		int result;
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query)) {

			result = statement.executeUpdate();
			if (result == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public List<BankAccount> findAllBankAccount() {
		String query = "SELECT * FROM bankaccounts";

		List<BankAccount> accounts = new ArrayList<>();
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			while (result.next()) {
				long accountId = result.getLong(1);
				String accountHolderName = result.getString(2);
				String accountType = result.getString(3);
				double accountBalance = result.getDouble(4);

				BankAccount account = new BankAccount(accountId, accountHolderName, accountType, accountBalance);
				accounts.add(account);

			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}

		return accounts;
	}

	@Override
	public List<BankAccount> searchBankAccount(long accountId) {
		String query = "SELECT * FROM bankaccounts WHERE account_id=" + accountId;

		List<BankAccount> accounts = new ArrayList<>();
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {

			if (result.next()) {
				String accountHolderName = result.getString(2);
				String accountType = result.getString(3);
				double accountBalance = result.getDouble(4);
				BankAccount account = new BankAccount(accountId, accountHolderName, accountType, accountBalance);
				accounts.add(account);
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public boolean updateDetails(long accountId, String accountHolderName, String accountType) {
		String query = "UPDATE bankaccounts SET customer_name = ?, cutomer_type = ? WHERE account_id = ?";
		//Connection connection = DbUtil.getconnection();
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, accountHolderName);
			statement.setString(2, accountType);
			statement.setLong(3, accountId);

			int result = statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return true;

	}*/


}
