package ru.flamexander.spring.data.jdbc.demo.dtos;

import java.util.List;

public class SimplestPageDto<T> {
    private List<T> content;
    private Long currentPage;
    private Long totalPages;
    private Long totalEntities;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public SimplestPageDto() {
    }

    public SimplestPageDto(List<T> content) {
        this.content = content;
    }

    public SimplestPageDto(List<T> content, Long currentPage, Long totalPages, Long totalEntities) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalEntities = totalEntities;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalEntities() {
        return totalEntities;
    }

    public void setTotalEntities(Long totalEntities) {
        this.totalEntities = totalEntities;
    }
}
