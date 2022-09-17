package com.mezzoforte.greenstreet.domain.posting.repository;

import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.posting.entity.PostingPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingPhotoRepository extends JpaRepository<PostingPhoto, Long> {

    void deleteAllByPosting(Posting posting);
}
