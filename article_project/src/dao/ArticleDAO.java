package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import crudInterface.CRUDInterface;
import db.DBConn;
import dto.ArticleDTO;
import entity.Article;
import entity.Comment;

public class ArticleDAO implements CRUDInterface {

	@Override
	public List<Article> findAll() {
		List<Article> articles = new ArrayList<Article>();

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM articles ORDER BY id DESC";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getLong("id"));
				article.setName(rs.getNString("name"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getNString("content"));
				article.setInsertedDate(rs.getTimestamp("inserted_date").toLocalDateTime());

				if (rs.getTimestamp("updated_date") != null) {
					article.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
				} else {
					article.setUpdatedDate(null);
				}
				articles.add(article);
			}

			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// 가져온 게시글의 댓글들을 각 article commentList에 담아오는 구문이 존재해야 함
		return getArticleComments(articles);
//		return articles;
	}

	public List<Article> getArticleComments(List<Article> articles) {
		// for 루프를 돌면서 article의 id로 게시글의 댓글을 찾는다.
		// 찾은 댓글을 article의 댓글리스트에 담는다.

		Connection conn = DBConn.getConnection();

		for (Article article : articles) {
			PreparedStatement psmt = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM comments WHERE article_id = ?";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setLong(1, article.getId());

				rs = psmt.executeQuery();

				while (rs.next()) {
					Comment comment = new Comment();
					comment.setC_id(rs.getLong("c_id"));
					comment.setArticle_id(rs.getLong("article_id"));
					comment.setC_name(rs.getString("c_name"));
					comment.setC_content(rs.getString("c_content"));
					article.getCommentLists().add(comment);

				}
				rs.close();
				psmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}

		return articles;
	}

	@Override
	public int insert(Article article) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;

		String sql = "INSERT INTO articles(name, title, content, inserted_date)" + "VALUES(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, article.getName());
			psmt.setString(2, article.getTitle());
			psmt.setString(3, article.getContent());
			psmt.setTimestamp(4, Timestamp.valueOf(article.getInsertedDate())); // 주의 !!;;

			result = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public int deleteById(Long id) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;

		String sql = "DELETE FROM articles WHERE id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, id);

			result = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public int updateById(Article article) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;

		String sql = "UPDATE articles SET title =?, content =?, inserted_date =?, updated_date =? WHERE id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, article.getTitle());
			psmt.setString(2, article.getContent());
			psmt.setTimestamp(3, Timestamp.valueOf(article.getInsertedDate()));
			psmt.setTimestamp(4, Timestamp.valueOf(article.getUpdatedDate()));
			psmt.setLong(5, article.getId());

			result = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	@Override
	public Article findById(Long id) {

		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM articles WHERE id=?";
		int result = 0;
		Article article = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, id);
			rs = psmt.executeQuery();
			// 갖고온 데이터를 Article에 담아서 리턴
			while (rs.next()) {
				article = new Article();
				article.setId(rs.getLong("id"));
				article.setName(rs.getString("name"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setInsertedDate(rs.getTimestamp("inserted_date").toLocalDateTime());

				if (rs.getTimestamp("updated_date") != null) {
					article.setUpdatedDate(rs.getTimestamp("updated_date").toLocalDateTime());
				} else {
					article.setUpdatedDate(null);
				}

			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return getArticleComments(article);
//		return article;
	}

	private Article getArticleComments(Article article) {
		Connection conn = DBConn.getConnection();

		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM comments WHERE article_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, article.getId());

			rs = psmt.executeQuery();

			while (rs.next()) {
				Comment comment = new Comment();
				comment.setC_id(rs.getLong("c_id"));
				comment.setArticle_id(rs.getLong("article_id"));
				comment.setC_name(rs.getString("c_name"));
				comment.setC_content(rs.getString("c_content"));
				article.getCommentLists().add(comment);

			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return article;
	}

	@Override
	public void insertComment(Comment comment) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;

		String sql = "INSERT INTO comments(article_id, c_name, c_content, inserted_date)" + "VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, comment.getArticle_id());
			psmt.setString(2, comment.getC_name());
			psmt.setString(3, comment.getC_content());
			psmt.setTimestamp(4, Timestamp.valueOf(comment.getInsertedDate()));

			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateComment(Comment comment) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;

		String sql = "UPDATE comments SET c_content =?, updated_date =? WHERE c_id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, comment.getC_content());
			psmt.setTimestamp(2, Timestamp.valueOf(comment.getUpdatedDate()));
			psmt.setLong(3, comment.getC_id());

			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteComment(Long deleteNum) {
		Connection conn = DBConn.getConnection();
		PreparedStatement psmt = null;
		String sql = "DELETE FROM comments WHERE c_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setLong(1, deleteNum);

			psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
