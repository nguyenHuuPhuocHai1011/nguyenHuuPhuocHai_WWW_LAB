package com.example.nguyenhuuphuochai_www_lab06.backend.services;

import com.example.nguyenhuuphuochai_www_lab06.backend.models.Post;
import com.example.nguyenhuuphuochai_www_lab06.backend.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostRepository postRepository;

    public Page<Post> findPaginated(Pageable pageable){
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Post> list;
        List<Post> candidates = postRepository.findAll();
        if(candidates.size() >= startItem){
            int toIndex = Math.min(startItem + pageSize, candidates.size());
            list = candidates.subList(startItem, toIndex);
        }else {
            list = Collections.emptyList();
        }
        return new PageImpl<>(list, PageRequest.of(currentPage,pageSize), candidates.size());
    }

}
