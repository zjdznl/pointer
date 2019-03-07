package com.zhengjiadi.pointer.repository;

import com.zhengjiadi.pointer.model.Image;
import com.zhengjiadi.pointer.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
