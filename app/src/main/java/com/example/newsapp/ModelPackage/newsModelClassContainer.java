package com.example.newsapp.ModelPackage;

import java.util.ArrayList;

public class newsModelClassContainer {
private String status;
private int totalResults;
protected ArrayList<newsModelClass> articles;

    public newsModelClassContainer(String status, int totalResults, ArrayList<newsModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<newsModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<newsModelClass> articles) {
        this.articles = articles;
    }
}
