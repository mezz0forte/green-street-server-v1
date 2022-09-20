package com.mezzoforte.greenstreet.domain.posting.repository;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingPhotoRepository extends JpaRepository<PostingPhoto, Long> {

    void deleteAllByPosting(Posting posting);
    List<PostingPhoto> findAllByPosting(Posting posting);
}
