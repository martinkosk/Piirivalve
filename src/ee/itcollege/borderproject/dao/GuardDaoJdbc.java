package ee.itcollege.borderproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ee.itcollege.borderproject.model.Guard;

public class GuardDaoJdbc implements GuardDao {

	private static final String INSERT_STATEMENT = "INSERT INTO guard (name, age) VALUES (?, ?)";
	private static final String SELECT_ALL_STATEMENT = "SELECT id, name, age FROM guard";
	
	private static final String SELECT_STATEMENT_FILTER_AGE = "SELECT id, name, age FROM guard WHERE age = ?";
	private static final String SELECT_STATEMENT_FILTER_NAME = "SELECT id, name, age FROM guard WHERE name = ?";
	private static final String SELECT_STATEMENT_FILTER_NAME_AGE = "SELECT id, name, age FROM guard WHERE name = ? AND age = ?";
	
	private static final String UPDATE_STATEMENT_SET_AGE = "UPDATE guard SET age = ? WHERE id = ?";
	private static final String UPDATE_STATEMENT_SET_NAME = "UPDATE guard SET name = ? WHERE id = ?";
	private static final String UPDATE_STATEMENT_SET_NAME_AGE = "UPDATE guard SET name = ?, age = ? WHERE id = ?";
	
	@Override
	public List<Guard> getGuards() {
		List<Guard> guards = new ArrayList<Guard>();
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_ALL_STATEMENT);
			while (resultSet.next()) {
				Guard guard = new Guard();
				guard.setId(resultSet.getInt(1));
				guard.setName(resultSet.getString(2));
				guard.setAge(resultSet.getInt(3));
				guards.add(guard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return guards;
	}

	@Override
	public void saveGuard(Guard guard) {
		Connection connection = getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT);
			statement.setString(1, guard.getName());
			statement.setInt(2, guard.getAge());
			statement.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Error connecting: " + sqle);
			throw new RuntimeException(sqle);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Error on connection closing");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void saveGuards(List<Guard> guards) {
		for (Guard guard : guards)
			saveGuard(guard);
	}

	@Override
	public List<Guard> searchGuards(String name, int age) {
		List<Guard> guards = new ArrayList<Guard>();
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT_FILTER_NAME_AGE);
			statement.setString(1, name);
			statement.setInt(2, age);
			guards.addAll(findGuards(statement));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guards;
	}

	@Override
	public List<Guard> searchGuards(String name) {
		List<Guard> guards = new ArrayList<Guard>();
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT_FILTER_NAME);
			statement.setString(1, name);
			guards.addAll(findGuards(statement));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guards;
	}

	@Override
	public List<Guard> searchGuards(int age) {
		List<Guard> guards = new ArrayList<Guard>();
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT_FILTER_AGE);
			statement.setInt(1, age);
			guards.addAll(findGuards(statement));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return guards;
	}

	@Override
	public void updateGuard(int id, int age) {
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_STATEMENT_SET_AGE);
			statement.setInt(1, age);
			statement.setInt(2, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateGuard(int id, String name) {
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_STATEMENT_SET_NAME);
			statement.setString(1, name);
			statement.setInt(2, id);
			statement.execute();
			System.out.println("jou");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateGuard(int id, String name, int age) {
		Connection connection = getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_STATEMENT_SET_NAME_AGE);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setInt(3, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection("jdbc:hsqldb:C:/hsql/BorderDB");
		} catch (Exception e) {
			System.out.println("Connection Error!");
			e.printStackTrace();
			return null;
		}
	}
	
	private List<Guard> findGuards(PreparedStatement statement) {
		List<Guard> guards = new ArrayList<Guard>();

		try {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Guard guard = new Guard();
				guard.setId(resultSet.getInt(1));
				guard.setName(resultSet.getString(2));
				guard.setAge(resultSet.getInt(3));
				guards.add(guard);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return guards;
	}
}
