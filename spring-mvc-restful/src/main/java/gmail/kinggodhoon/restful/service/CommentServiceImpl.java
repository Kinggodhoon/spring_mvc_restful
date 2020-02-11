package gmail.kinggodhoon.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.restful.dao.CommentDao;
import gmail.kinggodhoon.restful.domain.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int insert(Comment comment) {
		int result = 0;
		
		result = commentDao.insert(comment);
		
		return result;
	}

	@Override
	public List<Comment> list(int postid) {
		List<Comment> list = commentDao.list(postid);
		
		return list;
	}
	
}
