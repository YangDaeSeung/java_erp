package java_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_erp.dao.TitleDao;
import java_erp.dto.Title;
import java_erp.utill.JdbcUtill;


public class TitleDaoImpl implements TitleDao {

	private static final TitleDaoImpl instance = new TitleDaoImpl();
	
	public static TitleDaoImpl getInstance()
	{
		return instance;
	}
	private TitleDaoImpl()
	{
		
	}
	@Override
	public ArrayList<Title> selectTitleByAll() {
		// TODO Auto-generated method stub
		String sql = "select tno,tname from title";
		ArrayList<Title> list = null;
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			list = new ArrayList<Title>();
			while(rs.next())
			{

				list.add(getTitle(rs));
			}
			
		}
		catch(SQLException e)
		{
			System.err.println("SQL 문법 오류");
			e.printStackTrace();
		}
		return list;
	}
	private Title getTitle(ResultSet rs) throws SQLException{
		int tno = rs.getInt("tno");
		String tname = rs.getString("tname");
		return new Title(tno,tname);
	}
	
	@Override
	public Title selectTitleByNo(Title title) {
		// TODO Auto-generated method stub
		String sql = "select tno,tname from title where tno = ?";
		try(Connection con = JdbcUtill.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);)
		{
			pstmt.setInt(1, title.getTno());
			try(ResultSet rs = pstmt.executeQuery())
			{
				if(rs.next())
				{
					return getTitle(rs);
				}
			}
		}
		catch(SQLException e)
		{
			System.err.println("SQL 문법 오류");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		String sql = "insert into title values(?,?)";
		try(Connection con = JdbcUtill.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);)
		{
			pstmt.setInt(1, title.getTno());
			pstmt.setString(2, title.gettName());
			return pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		String sql = "update title set tname = ? where tno = ?;";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);)
			{
				System.out.println("Pstmt >>"+pstmt);
				pstmt.setString(1, title.gettName());
				pstmt.setInt(2, title.getTno());
				System.out.println("Pstmt >>"+pstmt);
				return pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		String sql = "delete from title where tno =?;";
		try(Connection con = JdbcUtill.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);)
			{
				pstmt.setInt(1, title.getTno());
				return pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return 0;
	}

}
