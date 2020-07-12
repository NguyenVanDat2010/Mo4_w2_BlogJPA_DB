package blog.repository.impl;

import blog.model.Blog;
import blog.repository.IGeneralRepository;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends IGeneralRepository<Blog> {
}
