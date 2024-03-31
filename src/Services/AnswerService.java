package Services;

import Model.Answer;
import Model.Question;
import Model.Status;
import Model.UserModel.User;
import Model.UserModel.UserType;
import Exception.*;
import Services.Notification.Subject;

import java.util.List;

public class AnswerService implements Subject {
    public String addAnswer(User user, Question question, Answer answer) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to answer");
        }
        question.addAnswer(answer);
        if(!question.getSubscribers().contains(user)) {
            question.addSubscriber(user);
        }
        notify(question.getSubscribers());
        return "You have successfully posted the answer";
    }

    public String removeAnswer(User user,Question question, Answer answer) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to delete answer");
        }
        if(answer.getUserId().equals(user.getId())) {
            question.removeAnswer(answer);
            return "You have successfully deleted the answer";
        }
        throw new SOFException(SOFExceptionType.InsufficientException,"You can't delete this answer");
    }

    public List<Answer> getAnswer(User user,Question question, Answer answer) {
        return question.getAnswers();
    }

    @Override
    public void notify(List<User> userList) {
        for(var user:userList) {
            System.out.println("Hey "+user.getName()+" an answer has been added, check it out!!");
        }
    }
}
