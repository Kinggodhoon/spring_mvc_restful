package gmail.kinggodhoon.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.restful.dao.PostDao;
import gmail.kinggodhoon.restful.domain.Post;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDao postDao;

	@Override
	public int insert(Post post) {
		int result = 0;
		
		result = postDao.insert(post);
		
		return result;
	}

	@Override
	public List<Post> list(int boardid) {
		List<Post> list = postDao.list(boardid);
		return list;
	}

	@Override
	public Post getPost(int postid) {
		Post post = postDao.getPost(postid);
		return post;
	}

	@Override
	public int update(Post post) {
		int result = 0;
		
		result = postDao.update(post);
		
		return result;
	}

	@Override
	public int increaseViews(int postid) {
		int result = 0;
		
		result = postDao.increaseViews(postid);
		
		return result;
	}

	@Override
	public int increaseRecommands(int postid) {
		int result = 0;
		
		result = postDao.increaseRecommand(postid);
		
		return result;
	}

	@Override
	public int delete(int postid) {
		int result = 0;
		
		result = postDao.delete(postid);
		
		return result;
	}

}
