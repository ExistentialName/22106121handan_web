package com.example.tust.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * (JouInfo)实体类
 *
 * @author silences
 * @since 2024-12-10 22:10:42
 */
@Data
public class JouInfo implements Serializable {
    private static final long serialVersionUID = 991521350824667614L;
    /**
     * 序号
     */
    private Integer id;
    /**
     * 论文标题
     */
    private String title;
    /**
     * 论文作者
     */
    private String author;
    /**
     * 论文摘要
     */
    private String abstracts;
    /**
     * 论文下载路径
     */
    private String htmlCon;

}

