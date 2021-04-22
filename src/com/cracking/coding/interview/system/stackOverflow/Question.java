package com.cracking.coding.interview.system.stackOverflow;

import java.util.List;

public class Question extends Entity{
    List<EditHistory> editHistoryList;
    List<Answer> answerList;
    List<Tag> tagList;
    String title;
    String description;
    QuestionStatus questionStatus;

    public boolean addQuestion(){
        return false;
    }

    public boolean addTag(Tag tag){
        return true;
    }
}
