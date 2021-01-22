package com.yoyling.service.impl;

import com.yoyling.domain.Comment;
import com.yoyling.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {
	@Override
	public List<Comment> selectCommentListByContentId(int id) {
		return commentMapper.selectCommentListByContentId(id);
	}

	@Override
	public String selectCommentAuthorById(Integer coid) {
		return commentMapper.selectCommentAuthorById(coid);
	}

	@Override
	public int insert(Comment comment) {
		return commentMapper.insert(comment);
	}

	@Override
	public List<Comment> selectAllComment() {
		return commentMapper.selectAllCommment();
	}

	@Override
	public int deleteByPrimaryKey(int coid) {
		return commentMapper.deleteByPrimaryKey(coid);
	}

	@Override
	public int deleteSelectComment(String[] coids) {
		try {
			if (coids != null && coids.length > 0) {
				for (String coid: coids) {
					commentMapper.deleteByPrimaryKey(Integer.parseInt(coid));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}