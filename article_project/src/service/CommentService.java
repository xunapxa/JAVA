package service;

import crudInterface.CRUDInterface;
import dao.ArticleDAO;
import dto.CommentDTO;
import entity.Comment;

public class CommentService {

	CRUDInterface commentDAO = new ArticleDAO();
	
	public void addComment(CommentDTO comment) {
		commentDAO.insertComment(CommentDTO.fromDTO(comment));
	}

	public void deleteComment(Long deleteNum) {
		commentDAO.deleteComment(deleteNum);
	}

	public void updateComment(CommentDTO updateComment) {
		commentDAO.updateComment(CommentDTO.fromDTO(updateComment));		
	}



}
