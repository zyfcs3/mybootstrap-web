package cn.zhuyafeng.mybootstrapweb.pojo;

import org.apache.solr.client.solrj.beans.Field;

public class Foo {

    @Field("id")
    private Long id;
    @Field("title")
    private String title;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
