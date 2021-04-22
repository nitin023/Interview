package com.cracking.coding.interview.system.stackOverflow;


import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Entity {
    int entityId;
    Member creator;
    Map<VoteType,Integer> voteTypeIntegerMap;
    Date createdDate;
    List<Comment> commentList;

    public boolean flagEntity(Member member){
        return true;
    }

    public boolean voteEntity(VoteType member){
        return true;
    }

    public boolean addComment(Comment member){
        return true;
    }
}
