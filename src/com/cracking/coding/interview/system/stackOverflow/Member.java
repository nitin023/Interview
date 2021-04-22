package com.cracking.coding.interview.system.stackOverflow;

import java.util.List;

public class Member extends User{
    Account account;
    List<Badge> badges;

    public void addQuestion(Question question){
    }

    public void addComment(Entity entity,Comment comment){
    }
    public void addAnswer(Question question,Answer answer){
    }
    public void vote(Entity entity , VoteType voteType){
    }
    public void addTag(Question question,Tag tag){
    }
    public void flag(Entity entity){
    }
    public List<Badge> getBadges(){
        return null;
    }
}
