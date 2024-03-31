package Dao;

import Model.Question;
import Model.UserModel.User;
import Model.UserModel.UserType;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private static List<Question> questionList;
    private QuestionDao() {
        questionList = new ArrayList<>();
    }
    private static class Holder {
        private static QuestionDao INSTANCE = new QuestionDao();
    }
    public static QuestionDao getInstance() {
        return Holder.INSTANCE;
    }
    public void addQuestion(Question question){
        questionList.add(question);
    }
    public void removeQuestion(Question question) {
        questionList.remove(question);
    }
    public List<Question> getQuestionList() {
        return questionList;
    }
}
