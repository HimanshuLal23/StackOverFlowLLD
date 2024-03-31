package Services;

import Dao.QuestionDao;
import Model.Question;
import Model.Status;
import Model.UserModel.User;
import Model.UserModel.UserType;
import Exception.*;

public class QuestionService {
    private QuestionDao questionDao;
    public QuestionService() {
        questionDao = QuestionDao.getInstance();
    }
    public String addQuestion(User user,Question question) throws SOFException{
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to add question");
        }
        question.addSubscriber(user);
        questionDao.addQuestion(question);
        return "You have successfully posted the question";
    }

    public String deleteQuestion(User user,Question question) throws SOFException{
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to delete question");
        }
        if(user.getUserType()==UserType.Moderator || question.getUserId().equals(user.getId())) {
            question.setStatus(Status.Delete);
            return "You have successfully deleted the question";
        }
        throw new SOFException(SOFExceptionType.InsufficientException,"You can't delete this question");
    }

    public String removeQuestion(User user,Question question) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to remove question");
        }
        if(!question.getUserId().equals(user.getId())) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You can't remove this question");
        }
        questionDao.removeQuestion(question);
        return "You have successfully removed the question";
    }

    public String undeleteQuestion(User user,Question question) throws SOFException {
        if(user.getUserType()!= UserType.Member) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to un-delete this question");
        }
        if(user.getUserType()==UserType.Moderator || question.getUserId().equals(user.getId())) {
            question.setStatus(Status.Open);
            return "You have successfully deleted the question";
        }
        throw new SOFException(SOFExceptionType.InsufficientException,"You can't un-delete this question");
    }

    public String closeQuestion(User user,Question question) throws SOFException {
        if(user.getUserType()!= UserType.Moderator) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You don't have privilege to close question");
        }
        question.setStatus(Status.Closed);
        return "You have successfully deleted the question";
    }
}
